package com.example1.ch4;

import java.util.Date;

public class Wait_for_start extends Thread {

    Runnable operation;
    Runnable delay;

    public Wait_for_start(Runnable operation, Runnable delay) {
        setDaemon(true);
        this.operation = operation;
        this.delay = delay;
    }

    public void run() {
        try {
            while(!isInterrupted()) {
                final Condition lock_is_running = new Condition(false);

                Thread lock = new Thread() {
                    synchronized public void run() {
                        lock_is_running.set_true();

                        try {
                            wait();
                        } catch (InterruptedException e) {

                        }
                    }
                };

                lock.start();
                lock_is_running.wait_for_true();

                operation.run();

                synchronized (lock) {
                    lock.notify();
                }

                delay.run();
            }
        } catch (InterruptedException e) {

        }
    }

    public static class Test {
        public static void main(String[] args) throws InterruptedException {
            new Wait_for_start(new Runnable() {
                @Override
                public void run() {
                    System.out.println(new Date());
                }
            }, new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) { }
                }
            }).start();

            Thread.currentThread().sleep(5000);
        }
    }

}
