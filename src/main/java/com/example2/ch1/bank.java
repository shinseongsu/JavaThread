package com.example2.ch1;

/**
 * synchronized 메소드, 동기 메소드
 */
public class bank {
    private int money;
    private String name;

    public bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    // 예금한다.
    public synchronized void deposit(int m) {
        money += m;
    }

    // 인출한다.
    public synchronized boolean withdraw(int m) {
        if(money >= m) {
            money -= m;
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

}
