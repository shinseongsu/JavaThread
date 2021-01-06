package com.example2.ch2;

/**
 * run시 무한루프 진입, ( 작동시켜 보니.. 깨진다. )
 */
public class UserThread extends Thread {
    private final Gate gate;
    private final String myname;
    private final String myaddress;

    public UserThread(Gate gate, String myname, String myaddress) {
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
