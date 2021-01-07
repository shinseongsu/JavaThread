package com.example2.ch3;

import java.util.List;

/**
 * 읽는 메서드
 */
public class ReaderThread extends Thread {
    private final List<Integer> list;

    public ReaderThread(List<Integer> list) {
        super("ReaderThread");
        this.list = list;
    }

    public void run() {
        while(true) {
            for(int n : list) {
                System.out.println(n);
            }
        }
    }
}
