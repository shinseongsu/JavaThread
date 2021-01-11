package com.example2.ch7;

import java.util.concurrent.ThreadFactory;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host2 host = new Host2(
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                }
        );
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }
}
