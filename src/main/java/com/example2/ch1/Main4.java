package com.example2.ch1;

/**
 * 약 1초 간격으로 Good!을 표시하는 프로그램
 */
public class Main4 {
    public static void main(String[] args) {
        for(int i = 0 ; i < 10000 ; i++) {
            System.out.println("Good!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
        }
    }
}
