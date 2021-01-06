package com.example2.ch2;

/**
 * 첫 글자와 출신지의 첫 글자를 일치 키는 예제
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit CTRRL+C to exit.");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
