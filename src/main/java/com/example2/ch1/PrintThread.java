package com.example2.ch1;

/**
 * Thread 클래스스의 서브 클래스를 사용
 */
public class PrintThread extends Thread {
    private String message;

    public PrintThread(String message) {
        this.message = message;
    }

    public void run() {
        for(int i = 0 ; i < 10000; i++) {
            System.out.println(message);
        }
    }
}
