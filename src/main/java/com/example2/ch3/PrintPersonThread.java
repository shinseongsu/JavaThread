package com.example2.ch3;

/**
 * Thread.currentThread.getName() 자기 쓰레드 이름을 구하는 메소드
 */
public class PrintPersonThread extends Thread {
    private Person person;

    public PrintPersonThread(Person person) {
        this.person = person;
    }

    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName() + "prints" + person);
        }
    }
}
