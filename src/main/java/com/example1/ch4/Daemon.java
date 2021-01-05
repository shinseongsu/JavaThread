package com.example1.ch4;

import java.util.Date;

public class Daemon extends Thread {

    final Runnable operation;
    final Runnable delay;

    public Daemon(Runnable operation, Runnable delay) {
        setDaemon(true);
        this.operation = operation;
        this.delay = delay;
    }

    public void run() {
        while(!isInterrupted()) {
            new Thread() {
                public void run() {
                    operation.run();
                }
            }.start();

            delay.run();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Daemon(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {}
            }
        }).start();

        Thread.currentThread().sleep(5000);
    }

}
