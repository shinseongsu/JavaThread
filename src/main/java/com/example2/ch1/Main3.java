package com.example2.ch1;

/**
 * Runnable 인터페이스를 사용하여 2개의 쓰레드를 가동
 */
public class Main3 {
    public static void main(String[] args) {
        new Thread(new Printer("Good!")).start();
        new Thread(new Printer("Nice!")).start();
    }
}
