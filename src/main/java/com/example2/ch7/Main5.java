package com.example2.ch7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main5 {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(5);
        Host4 host = new Host4(
                scheduledExecutorService
        );

        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            scheduledExecutorService.shutdown();
            System.out.println("main END");
        }
    }
}
