package com.example1.ch2;

public class Exception_test {
    private boolean some_condtion = false;

    private Thread the_thread = new Thread() {
        public void run() {
            if(some_condtion) {
                throw new RuntimeException("Hello world");
            }

            synchronized (Exception_test.this) {
                Exception_test.this.notify();
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Exception_test test = new Exception_test();
        test.test();
    }

    public synchronized void test() throws InterruptedException {
        System.out.println("above");
        some_condtion = true;
        the_thread.start();
        wait();

        System.out.println("below");
    }

}
