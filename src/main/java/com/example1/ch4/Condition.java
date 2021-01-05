package com.example1.ch4;

import com.example1.ch3.Lock_manager;
import com.example1.ch3.Semaphore;

public class Condition {

    private boolean _is_true;

    public Condition(boolean is_true) {
        _is_true = is_true;
    }

    public synchronized void set_false() {
        _is_true = false;
    }

    public synchronized void set_true() {
        _is_true = true;
        notifyAll();
    }

    public final void set() {
        set_true();
    }
    public final void reset() {
        set_false();
    }

    public final boolean is_true() {
        return _is_true;
    }

    public final synchronized void release_all() {
        notifyAll();
    }

    public final synchronized void release_one() {
        notify();
    }

    public final synchronized boolean wait_for_true(long timeout) throws InterruptedException, Semaphore.Timed_out {
        if(timeout == 0 || _is_true)
            return _is_true;

        if(timeout == Semaphore.FOREVER)
            return wait_for_true();

        long expiration = System.currentTimeMillis() + timeout;
        while(!_is_true) {
            long time_remaining = expiration - System.currentTimeMillis();
            if(time_remaining <= 0)
                throw new Semaphore.Timed_out("Timed out waiting to acquire Condition Variable");

            wait(time_remaining);
        }

        if(!_is_true)
            throw new Semaphore.Timed_out();

        return true;
    }

    public final synchronized boolean wait_for_true() throws InterruptedException {
        while(!_is_true)
            wait();
        return true;
    }

    private final int _id = Lock_manager.new_id();

    public int id() {
        return _id;
    }

    public boolean acquire(long timeout) throws InterruptedException, Semaphore.Timed_out {
        return wait_for_true(timeout);
    }

    public void release() {
        set_true();
    }

}
