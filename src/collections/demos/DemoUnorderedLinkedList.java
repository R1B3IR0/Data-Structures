package collections.demos;

import collections.lists.UnorderedLinkedList;

import java.util.Iterator;

public class DemoUnorderedLinkedList {
    public static void main(String[] args) {
        UnorderedLinkedList<Integer> list = new UnorderedLinkedList<>();
        list.addToFront(1);
        list.addToFront(2);
        list.addToFront(3);
        list.addToFront(4);
        list.addToFront(5);
        list.addToRear(8);
        list.addAfter(7, 8);
        list.addToFront(6);

        System.out.println(list);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if(i.equals(2)) {
                it.remove();
            }
        }
        System.out.println(list);
    }
}
