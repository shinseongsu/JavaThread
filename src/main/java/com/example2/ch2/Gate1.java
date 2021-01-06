package com.example2.ch2;

/**
 * pass synchronized 로 한개의 쓰레드만 실행되도록 보증
 */
public class Gate1 {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String addrress) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    public synchronized String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }

    private void check() {
        if(name.charAt(0) != address.charAt(0)) {
            System.out.println("*****BROKEN***** " + toString());
        }
    }
}
