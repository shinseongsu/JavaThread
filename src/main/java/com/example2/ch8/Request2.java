package com.example2.ch8;

import java.util.Random;

public class Request2 implements Runnable {

    private final String name;
    private final int number;
    private static final Random random = new Random();

    public Request2(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "executes" + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) { }
    }

    public String toString() {
        return "[ Request from " + name + " No." + number + " ]";
    }
}
