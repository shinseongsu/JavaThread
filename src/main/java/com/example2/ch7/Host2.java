package com.example2.ch7;

import java.util.concurrent.ThreadFactory;

public class Host2 {
    private final Helper helper = new Helper();
    private final ThreadFactory threadFactory;

    public Host2(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        threadFactory.newThread(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        ).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
