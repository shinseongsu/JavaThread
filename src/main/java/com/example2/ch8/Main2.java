package com.example2.ch8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            new ClientThread2("Alice", executorService).start();
            new ClientThread2("Bobby", executorService).start();
            new ClientThread2("Chris", executorService).start();

            Thread.sleep(5000);
        } catch (InterruptedException e) {
        } finally {
            executorService.shutdown();
        }
    }
}
