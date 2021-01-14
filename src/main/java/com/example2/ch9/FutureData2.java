package com.example2.ch9;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureData2 extends FutureTask<RealData> implements Data {

    public FutureData2(Callable<RealData> callable) {
        super(callable);
    }

    @Override
    public String getConnection() {
        String string = null;
        try {
            string = get().getConnection();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }
}
