package com.example2.ch1.Quiz1;

/**
 * * 1000개 표시 후, + 1000개 표시
 */
public class Main {
    public static void main(String[] args) {
        new PrintThread("*").run();
        new PrintThread("+").run();
    }
}
