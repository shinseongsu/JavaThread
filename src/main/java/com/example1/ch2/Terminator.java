package com.example1.ch2;

public final class Terminator extends Thread {

    private final Thread victim;
    private final long timeout;

    public Terminator(Thread victim, long timeout) {
        this.victim = victim;
        this.timeout = timeout;
        setDaemon(true);
        setPriority(getThreadGroup().getMaxPriority());
        start();
    }

    public void run() {
        try {
            sleep(timeout);
            victim.interrupt();
        } catch (InterruptedException e) { }
    }

    private static final class Test {
        public static void main(String[] args) {
            new Thread() {
                public void run() {
                    try {
                        new Terminator(this, 1000);
                        synchronized (this) { wait(); }
                        System.out.println("Notified");
                    } catch (InterruptedException e) {
                        System.out.println("Timed out");
                    }
                }
            }.start();
        }
    }

}
