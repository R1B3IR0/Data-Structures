package collections.demos;

import collections.queues.LinkedQueue;

public class DemoLinkedQueue {
    public static void main(String[] args) {
        LinkedQueue<Integer> lq1 = new LinkedQueue<>();

        System.out.println(lq1.isEmpty()); // Retorna true se

        lq1.enqueue(2);
        lq1.enqueue(5);
        lq1.enqueue(7);
        System.out.println(lq1.first());// Deve retornar o primeiro elemento da Fila(Queue) ou seja 2
        System.out.println(lq1.isEmpty());
        System.out.println(lq1.toString());
        lq1.dequeue();
        lq1.dequeue();
        System.out.println(lq1.first()); // Deve retornar o 7

    }
}
