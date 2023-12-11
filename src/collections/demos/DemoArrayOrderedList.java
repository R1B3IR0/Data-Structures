package collections.demos;

import collections.lists.arrayLists.ArrayOrderedList;

import java.util.Iterator;

public class DemoArrayOrderedList {
    public static void main(String[] args) {
        //Tests for ex1
        ArrayOrderedList<Integer> list = new ArrayOrderedList<>();
        list.add(1);
        //verifyModCount(list, 1); // Espera-se que o modCount seja 1 após uma adição
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);
        //verifyModCount(list, 5); // Espera-se que o modCount seja 1 após uma adição


        System.out.println("List: " + list.toString());
        System.out.println("Size: " + list.size());
        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());
        System.out.println("Contains 3: " + list.contains(3));
        System.out.println("Contains 6: " + list.contains(6));
        System.out.println("Is empty: " + list.isEmpty());


        /*

        //Removing element using method remove of ArrayList during iteration
        //This will throw ConcurrentModificationException
        for(Integer i : list) {
            if(i.equals(3)) {
                list.remove(i);
            }
        }
        */

        //Solution
        //Removing element using iterator
        Iterator<Integer> it = list.iterator();
        System.out.print("Iterator: ");
        while (it.hasNext()) {
            Integer i = it.next();
            if(i.equals(2)) {
                it.remove();
            }
        }
        //verifyModCount(list, 6); // Espera-se que o modCount seja 6 após uma remoção

        System.out.println("\nList: " + list);
        System.out.println("--------------------");
        System.out.println("Remove 3: " + list.remove(3));
        System.out.println("List: " + list.toString());
        System.out.println("Remove first: " + list.removeFirst());
        System.out.println("List: " + list.toString());
        System.out.println("Remove last: " + list.removeLast());
        System.out.println("List: " + list.toString());

    }

/*
    // Método auxiliar para verificar o valor do modCount
    private static void verifyModCount(ArrayList<?> list, int expectedModCount) {
        if (list.getModCount() == expectedModCount) {
            System.out.println("modCount atualizado corretamente: " + expectedModCount);
        } else {
            System.out.println("modCount não corresponde ao esperado. Esperado: "
                    + expectedModCount + ", Atual: " + list.getModCount());
        }
    }
*/
}
