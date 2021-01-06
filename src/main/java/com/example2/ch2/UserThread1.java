package com.example2.ch2;

/**
 * Gate1 로 실행 (값이 깨지지 않는다.)
 */
public class UserThread1 extends Thread {
    private final Gate1 gate;
    private final String myname;
    private final String myaddress;

    public UserThread1(Gate1 gate, String myname, String myaddress) {
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;
    }

    public void run() {
        System.out.println(myname + " BEGIN");
        while(true) {
            gate.pass(myname, myaddress);
        }
    }

}
