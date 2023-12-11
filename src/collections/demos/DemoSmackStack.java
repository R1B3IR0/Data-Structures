package collections.demos;

import collections.stacks.SmackStack;

public class DemoSmackStack {
    public static void main(String[] args) {
        SmackStack<Integer> stack = new SmackStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);
        //System.out.println(stack.pop());
        //System.out.println(stack);
        System.out.println(stack.smack()); //Em caso de teste(2 linhas anteriores) de stack comentar esta linha e a próxima
        System.out.println(stack);
    }
}
