package collections.Demos;

import collections.lists.*;

public class DemoRecursion {
    public static void main(String[] args) {
        System.out.println("Demo Recursion");
        System.out.println("--------------");
        System.out.println("OrderedLinkedList");
        OrderedLinkedList<Integer> list = new OrderedLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printRecursiveList();
        System.out.println("\nOriginal List: " + list);
        list.reverse();
        System.out.println("Reversed List: " + list);
        System.out.println("--------------");
        System.out.println("UnorderedLinkedList");
        UnorderedLinkedList<Integer> list2 = new UnorderedLinkedList<>();
        list2.addToFront(1);
        list2.addToFront(2);
        list2.addToFront(3);
        list2.addToFront(4);
        list2.addToRear(5);
        list2.printRecursiveList();
        System.out.println("\nOriginal List: " + list);
        list.reverse();
        System.out.println("Reversed List: " + list);
        System.out.println("\n--------------");
        System.out.println("DoubleLinkedOrderedList");
        DoubleLinkedOrderedList<Integer> list3 = new DoubleLinkedOrderedList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        System.out.print("Forward: ");
        list3.printForward();
        System.out.print("Backward: ");
        list3.printBackward();
        System.out.println("\nOriginal List: " + list3);
        list3.reverse();
        System.out.println("Reversed List: " + list3);
        System.out.println("--------------");
        System.out.println("DoubleLinkedUnorderedList");
        DoubleLinkedUnorderedList<Integer> list4 = new DoubleLinkedUnorderedList<>();
        list4.addToFront(1);
        list4.addToFront(2);
        list4.addToFront(3);
        list4.addToFront(4);
        list4.addToRear(5);
        System.out.print("Forward: ");
        list4.printForward();
        System.out.print("Backward: ");
        list4.printBackward();
        System.out.println("\nOriginal List: " + list4);
        list4.reverse();
        System.out.println("Reversed List: " + list4);
        System.out.println("\n--------------------------------");

        /* How to use replace method */
        System.out.println("----How to use replace method----");
        System.out.println("---------------------------------");
        System.out.println("OrderedLinkedList");
        OrderedLinkedList<String> list5 = new OrderedLinkedList<>();
        list5.add("Ferrari");
        list5.add("Lamborghini");
        list5.add("Audi");
        list5.add("Mercedes");
        list5.add("Porsche");
        System.out.println("Original List: " + list5);
        list5.replace("Mercedes", "Buggati");
        System.out.println("Replaced List: " + list5);
        System.out.println("---------------------------------");
        System.out.println("UnorderedLinkedList");
        UnorderedLinkedList<String> list6 = new UnorderedLinkedList<>();
        list6.addToFront("Ferrari");
        list6.addToFront("Lamborghini");
        list6.addToFront("Audi");
        list6.addToFront("Mercedes");
        list6.addToFront("Porsche");
        System.out.println("Original List: " + list6);
        list6.replace("Mercedes", "BMW");
        System.out.println("Replaced List: " + list6);
        System.out.println("---------------------------------");
        System.out.println("DoubleLinkedOrderedList");
        DoubleLinkedOrderedList<String> list7 = new DoubleLinkedOrderedList<>();
        list7.add("Ferrari");
        list7.add("Lamborghini");
        list7.add("Audi");
        list7.add("Mercedes");
        list7.add("Porsche");
        System.out.println("Original List: " + list7);
        list7.replace("Mercedes", "Buggati");
        System.out.println("Replaced List: " + list7);
        System.out.println("---------------------------------");
        System.out.println("DoubleLinkedUnorderedList");
        DoubleLinkedUnorderedList<String> list8 = new DoubleLinkedUnorderedList<>();
        list8.addToFront("Ferrari");
        list8.addToFront("Lamborghini");
        list8.addToFront("Audi");
        list8.addToFront("Mercedes");
        list8.addToFront("Porsche");
        System.out.println("Original List: " + list8);
        list8.replace("Mercedes", "BMW");
        System.out.println("Replaced List: " + list8);
        System.out.println("---------------------------------");






    }
}
