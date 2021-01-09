package com.example2.ch5;

import java.util.concurrent.ArrayBlockingQueue;

public class Table1 extends ArrayBlockingQueue<String> {

    public Table1(int count) {
        super(count);
    }

    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "puts" + cake);
        super.put(cake);
    }

    public String take() throws InterruptedException {
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + "takes" + cake);
        return cake;
    }

}
