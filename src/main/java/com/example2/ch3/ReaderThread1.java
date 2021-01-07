package com.example2.ch3;

import java.util.List;

/**
 * 읽기 동기화
 */
public class ReaderThread1 extends Thread {
    private final List<Integer> list;

    public ReaderThread1(List<Integer> list) {
        super("ReaderThread");
        this.list = list;
    }

    public void run() {
        while(true) {
            synchronized (list) {
                for(int n : list) {
                    System.out.println(n);
                }
            }
        }
    }
}
