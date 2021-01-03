package com.example1.ch3;

public final class Mutex implements Semaphore {
    private Thread owner = null;
    private int lock_count = 0;

    private final int id = Lock_manager.new_id();
    public int id() { return id; }

    @Override
    public synchronized boolean acquire(long timeout) throws InterruptedException, Timed_out {
        if(timeout == 0) {
            return acquire_without_blocking();
        } else if (timeout == FOREVER) {
            while(!acquire_without_blocking()) {
                this.wait(FOREVER);
            }
        } else {
            long expiration = System.currentTimeMillis() + timeout;
            while(!acquire_without_blocking()) {
                long time_remaing = expiration - System.currentTimeMillis();

                if (time_remaing <= 0)
                    throw new Semaphore.Timed_out(
                            "Timed out waiting for Mutex");

                this.wait(time_remaing);
            }
        }
        return true;
    }

    public void acquire() throws InterruptedException, Semaphore.Timed_out {
        acquire(FOREVER);
    }

    private boolean acquire_without_blocking() {
        Thread current = Thread.currentThread();

        if(owner == null) {
            owner = current;
            lock_count = 1;
        } else if (owner == current) {
            ++lock_count;
        }

        return owner == current;
    }

    @Override
    public synchronized void release() {
        if ( owner != Thread.currentThread() )
            throw new Semaphore.Ownership();

        if(--lock_count <= 0) {
            owner = null;
            notify();
        }
    }
}
