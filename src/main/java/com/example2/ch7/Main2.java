package com.example2.ch7;

import java.util.concurrent.Executors;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host2 host = new Host2(
                Executors.defaultThreadFactory()
        );

        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }
}
