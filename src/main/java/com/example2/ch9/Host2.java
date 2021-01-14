package com.example2.ch9;

import java.util.concurrent.Callable;

public class Host2 {
    public FutureData2 request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + " ) BEGIN");

        FutureData2 future = new FutureData2(
                new Callable<RealData>() {
                    @Override
                    public RealData call() throws Exception {
                        return new RealData(count, c);
                    }
                }
        );

        new Thread(future).start();

        System.out.println("    request(" + count + ", " + c + ") EMD");

        return future;
    }
}
