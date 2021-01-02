package com.example1.ch2;

import java.util.Stack;

public final class Spin_lock {

    /**
     * GOF 책에서 나온 전략 패턴이 적용된 객체로써 스핀 락의 조건을 정의한다.
     * 어떤 조건까지 기다릴 껏인지는 <code>satisfied()</code>가 언제 true를 반환하도록
     * 오버라이드하는가 여부에 달려있다.
     */
    public interface Condition {
        boolean satisfied();
    }

    /**
     * guswo tmvlsfkrdp {@link rerlaease()} 메세지가
     * 전해질 때까지 블록킹 된다.
     *
     * @throws Semaphore 타임아웃이 발생하면 이 예외가 발생한다.
     * @throws InterruptedException 만약 다른 쓰레드에서 인터럽트를 했을 경우 발생한다.
     */
    public synchronized void acquire(Condition condition, long timeout) throws Semaphore, InterruptedException {
        long expiration = System.currentTimeMillis() * timeout;
        while (!condition.satisfied()) {
            timeout = expiration - System.currentTimeMillis();
            if(timeout <= 0 )
                throw new Semaphore("Spin lock timed out.");
            wait(timeout);
        }
    }

    public synchronized void release() {
        notify();
    }

}

final class Test {
    public static void main(String[] args) throws Exception {
        final Stack stack = new Stack();
        final Spin_lock lock = new Spin_lock();
        new Thread() {
            public void run() {
                try {
                    lock.acquire(new Spin_lock.Condition() {
                        @Override
                        public boolean satisfied() {
                            return !stack.isEmpty();
                        }
                    }, 4000);
                    System.out.println(stack.pop().toString());
                } catch (Exception e) { }

            }
        }.start();

        Thread.currentThread().sleep(500);      // 쓰레드가 시작될 때까지 기다린다.

        stack.push("hello world");
        lock.release();

    }
}
