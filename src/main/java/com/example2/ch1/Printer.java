package com.example2.ch1;

/**
 * 주어진 문자열을 표시하는 Printer 클래스
 */
public class Printer implements Runnable {
    private String message;

    public Printer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 10000 ; i++) {
            System.out.println(message);
        }
    }
}
