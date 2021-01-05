package com.example2.ch1;

/**
 * PrintThread를 사용하여 2개의 쓰레드를 기동하는 프로그램
 */
public class Main2 {
    public static void main(String[] args) {
        new PrintThread("Good!").start();
        new PrintThread("Nice!").start();
    }
}
