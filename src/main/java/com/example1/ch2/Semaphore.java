package com.example1.ch2;

import java.util.concurrent.TimeoutException;

public class Semaphore extends Exception {

    public Semaphore() {
        super();
    }

    public Semaphore(String msg) {
        super(msg);
    }

}
