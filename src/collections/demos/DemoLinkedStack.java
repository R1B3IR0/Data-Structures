package collections.demos;

import collections.stacks.LinkedStack;

public class DemoLinkedStack {
    public static void main(String[] args) {
        LinkedStack<Integer> ls1 = new LinkedStack<>();

        System.out.println(ls1.isEmpty() + " se a stack está vazia.");

        ls1.push(20);
        ls1.push(50);
        ls1.push(80);
        ls1.push(29); // -> 29, 80, 50, 20

        System.out.println(ls1.isEmpty() + " se a stack contém elementos");

        System.out.println("Tamanho da stack: " + ls1.size());

        ls1.pop(); // Remove o 29

        System.out.println("Tamanho da Stack: " + ls1.size());

        ls1.push(22);

        System.out.println(ls1.peek());  // 80

        System.out.println(ls1.toString());

    }
}
