package com.example2.ch2;

/**
 * 첫 글자와 출신지의 첫 글자를 일치 키는 예제
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit CTRRL+C to exit.");
        Gate1 gate = new Gate1();
        new UserThread1(gate, "Alice", "Alaska").start();
        new UserThread1(gate, "Bobby", "Brazil").start();
        new UserThread1(gate, "Chris", "Canada").start();
    }
}
