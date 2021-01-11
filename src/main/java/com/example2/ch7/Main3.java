package com.example2.ch7;

import java.util.concurrent.Executor;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host3 host = new Host3(
                new Executor() {
                    @Override
                    public void execute(Runnable r) {
                        new Thread(r).start();
                    }
                }
        );
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }
}
