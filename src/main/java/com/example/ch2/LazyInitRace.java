package com.example.ch2;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if(instance == null)
            instance = new ExpensiveObject();
        return instance;
    }
}
