package com.example2.ch2;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore 클래스를 사용한 예제 프로그램.
 */
public class Main2 {
    public static void main(String[] args) {
        BoundedRResource resource = new BoundedRResource(3);

        for(int i = 0 ; i < 10 ; i++) {
            new UserThread2(resource).start();
        }
    }
}

class Log {
    public static void println(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}

// 수 제한이 있는 리소스
class BoundedRResource {
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(314159);

    public BoundedRResource(int permits) {
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        } finally {
            semaphore.release();
        }
    }

    protected void doUse() throws InterruptedException {
        Log.println("BEGIN: used = " + (permits-semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("END:    used =" + (permits-semaphore.availablePermits()));
    }

}

class UserThread2 extends Thread {
    private final static Random random = new Random(26535);
    private final BoundedRResource resource;

    public UserThread2(BoundedRResource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            while(true) {
                resource.use();
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) { }
    }
}