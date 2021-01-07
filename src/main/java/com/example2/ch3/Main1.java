package com.example2.ch3;

import java.util.ArrayList;
import java.util.List;

/**
 * 읽고 쓰기를 병행하여 에러가 발생한다.
 */
public class Main1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
