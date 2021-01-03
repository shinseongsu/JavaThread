package com.example1.ch3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Lock_manager {

    private static Object id_lock = new int[]{ 0 };
    private static int id_pool = 0;

    private Lock_manager() { };

    public static int new_id() {
        synchronized (id_lock) {
            return id_pool++;
        }
    }

    private static final Comparator comparer_strategy = new Comparator() {
        @Override
        public int compare(Object a, Object b) {
            return ((Semaphore)a).id() - ((Semaphore)b).id();
        }

        public boolean equals(Object obj) {
            return obj == this;
        }
    };

    public static void acquire_multiple(Collection semaphores, long timeout) throws InterruptedException,
                                                                                Semaphore.Timed_out {
        acquire( semaphores.toArray(), timeout);
    }

    public static void acquire(Object[] locks, long timeout) throws InterruptedException,
                                                                                    Semaphore.Timed_out {
        int current_lock = 0;

        try {
            long expiration = (timeout == Semaphore.FOREVER ? Semaphore.FOREVER : System.currentTimeMillis() + timeout);

            Arrays.sort(locks, comparer_strategy);
            for( ; current_lock < locks.length ; ++current_lock) {
                long time_remaining = expiration - System.currentTimeMillis();
                if (time_remaining <= 0 )
                    throw new Semaphore.Timed_out(
                            "Timed out waiting to acquier multiple locks");

                ((Semaphore) locks[current_lock]).acquire(time_remaining);
            }
        } catch (InterruptedException exception ) {
            while(--current_lock >= 0) {
                ((Semaphore)locks[current_lock]).release();
            }
            throw exception;
        } catch ( Semaphore.Timed_out exception ) {
            while( --current_lock >= 0) {
                ((Semaphore)locks[current_lock]).release();
            }
            throw exception;
        }
    }
}
