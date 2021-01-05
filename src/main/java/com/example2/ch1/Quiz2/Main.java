package com.example2.ch1.Quiz2;

/**
 * sychronized를 빼고 예금 잔고를 마이너스가 되면 경고하는 프로그램
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("A Bad Bank", 1000);
        new ClientThread(bank).start();
        new ClientThread(bank).start();
    }
}
