package com.example2.ch4;

import java.util.concurrent.TimeoutException;

public class Main1 {
    public static void main(String[] args) {
        Host host = new Host(10000);

        try {
            System.out.println("execute BEGIN");
            host.execute();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
