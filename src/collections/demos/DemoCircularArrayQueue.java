package collections.demos;

import collections.queues.CircularArrayQueue;

public class DemoCircularArrayQueue {
    public static void main(String[] args) {
        CircularArrayQueue<Integer> cq1 = new CircularArrayQueue<>();
        System.out.println(cq1.size());
        System.out.println(cq1.isEmpty());
        cq1.enqueue(10);
        System.out.println(cq1.isEmpty());
        cq1.enqueue(15);
        cq1.enqueue(20);
        System.out.println(cq1.size());
        System.out.println(cq1.toString());
        cq1.dequeue();
        System.out.println(cq1.first());
    }
}
