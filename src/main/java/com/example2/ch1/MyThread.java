package com.example2.ch1;

/**
 * MyThread 인스턴스
 */
public class MyThread extends Thread {
    public void run() {
        for(int i = 0 ; i < 10000 ; i++) {
            System.out.println("Nice!");
        }
    }
}
