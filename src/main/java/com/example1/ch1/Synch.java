package com.example1.ch1;

import java.text.NumberFormat;

public class Synch {

    private static long[] locking_time = new long[100];
    private static long[] not_locking_time = new long[100];
    private static final int ITERATIONS = 1000000;

    synchronized long locking(long a, long b) {
        return a + b;
    }

    long not_locking(long a, long b) {
        return a + b;
    }

    private void test(int id) {
        long start = System.currentTimeMillis();

        for(long i = ITERATIONS ; --i >= 0 ;) {
            locking(i, i);
        }

        locking_time[id] = System.currentTimeMillis() - start;
        start            = System.currentTimeMillis();

        for(long i = ITERATIONS ; --i >= 0 ;) {
            not_locking(i, i);
        }

        not_locking_time[id] = System.currentTimeMillis() - start;
    }

    static void print_results(int id) {
        NumberFormat compositor = NumberFormat.getInstance();
        compositor.setMaximumFractionDigits(2);

        double time_in_synchronization = locking_time[id] - not_locking_time[id];

        System.out.println("Pass " + id + ": Time lost: "
                    + compositor.format(time_in_synchronization)
                    + "ms."
                    + compositor.format( ((double) locking_time[id] / not_locking_time[id]) * 100.0)
                    + "% increase");
    }

    public static void main(String[] args) throws InterruptedException {
        final Synch tester = new Synch();

        for(int i = 0 ; i <= 6 ; i++) {
            tester.test(i);
            print_results(i);
        }

        final Object start_gate = new Object();

        Thread t1 = new Thread() {
            public void run() {
                try {
                    synchronized (start_gate) {
                        start_gate.wait();
                    }
                } catch (InterruptedException e) { }
                tester.test(7);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                try {
                    synchronized (start_gate) {
                        start_gate.wait();
                    }
                } catch (InterruptedException e) { }
                tester.test(8);
            }
        };

        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();

        synchronized (start_gate) {
            start_gate.notifyAll();
        }

        t1.join();
        t2.join();

        print_results(7);
        print_results(8);

    }

}
