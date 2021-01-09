package com.example2.ch4;

import java.util.concurrent.TimeoutException;

public class Host {
    private final long timeout;
    private boolean ready = false;

    public Host(long timeout) {
        this.timeout = timeout;
    }

    // 상태를 변경한다.
    public synchronized void setExecutable(boolean on) {
        ready = on;
        notifyAll();
    }

    // 상태를 고려하여 실행한다.
    public synchronized void execute() throws InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();

        while(!ready) {
            long now = System.currentTimeMillis();
            long rest = timeout - (now - start);

            if (rest <=  0 ){
                throw new TimeoutException("now - start = " + (now - start) + ", timeout = " + timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    private void doExecute() {
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }

}
