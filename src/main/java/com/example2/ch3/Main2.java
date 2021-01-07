package com.example2.ch3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections.synchronizedList로 메서드 동기화
 */
public class Main2 {
    public static void main(String[] args) {
        final List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        new WriterThread(list).start();
        new ReaderThread1(list).start();
    }
}
