package com.example2.ch3;

import java.util.List;

/**
 * 쓰는 메소드
 */
public class WriterThread extends Thread {
    private final List<Integer> list;

    public WriterThread(List<Integer> list) {
        super("WriterThread");
        this.list = list;
    }

    public void run() {
        for(int i = 0 ; true ; i++) {
            list.add(i);
            list.remove(0);
        }
    }
}
