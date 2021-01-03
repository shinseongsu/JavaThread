package com.example1.ch2;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IO_block {

    public IO_block() {

        Thread server = new Thread() {
            public void run() {
                try {
                    ServerSocket server = new ServerSocket(9999);
                    Socket client = server.accept();
                    synchronized (this) { wait(); }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        };
        server.start();

        try {
            Thread.currentThread().sleep(5);
            Socket socket = new Socket("localhost", 9999);
            final InputStream in = socket.getInputStream();

            Thread client = new Thread() {
                public void run() {
                    try {
                        in.read();
                    } catch (Exception e) {
                        System.out.println("=============");
                        System.out.println("READ EXCEPTION");
                        System.out.println("=============");
                        e.printStackTrace();
                    }
                }
            };
            client.start();

            client.interrupt();
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

    }

    public static void main(String[] args) {
        new IO_block();
    }

}
