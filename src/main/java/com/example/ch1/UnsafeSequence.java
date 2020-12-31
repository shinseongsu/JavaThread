package com.example.ch1;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * 유일한 값을 리턴
     */
    public int getNext() {
        return value++;
    }
}
