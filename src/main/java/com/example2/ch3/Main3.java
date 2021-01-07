package com.example2.ch3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList 클래스로 쓰레드 세이프한 클래스
 */
public class Main3 {
    public static void main(String[] args) {
        final List<Integer> list = new CopyOnWriteArrayList<Integer>();
        new WriterThread(list).start();
        new ReaderThread1(list).start();
    }
}
