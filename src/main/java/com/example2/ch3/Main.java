package com.example2.ch3;

/**
 *  한개에 3개의 쓰레드가 엑세스 되는 에제
 */
public class Main {
    public static void main(String[] args) {
        Person alice = new Person("Alice", "Alaska");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
    }
}
