package com.example1.ch2;

public class Simple_notifying_queue {

    private static final int QUEUE_SIZE = 10;
    private Object[] queue = new Object[QUEUE_SIZE];
    private int head = 0;
    private int tail = 0;

    public synchronized void enqueue(Object item) {
        tail = ++tail % QUEUE_SIZE;
        queue[tail] = item;
        this.notify();
    }

    public synchronized Object dequeue() {
        try {
            // 만약 큐가 비어있다면 다른 쓰레드에서 원소를 집어넣을 때까지
            // 블록킹 된다. 아래의 구문은
            // 반드시 if문이 아닌 while문으로 구현되어야 한다.

            while(head == tail) {
                this.wait();
            }

        } catch (InterruptedException e) {
            return null;
        }

        head = ++head % QUEUE_SIZE;
        Object dequeued_object = queue[head];
        queue[head] = null;
        return dequeued_object;
    }

}
