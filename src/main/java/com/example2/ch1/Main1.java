package com.example2.ch1;

/**
 * MyThread 인스턴스를 생성하고 쓰레드 가동하기
 */
public class Main1 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        for(int i = 0 ; i < 10000 ; i++) {
            System.out.println("Good!");
        }
    }
}
