package collections.demos;

import collections.lists.DoubleLinkedOrderedList;

import java.util.Iterator;

public class DemoDoubleLinkedOrderedList {
    public static void main(String[] args) {
        // Testes básicos para a classe DoubleLinkedOrderedList
        DoubleLinkedOrderedList<Integer> list = new DoubleLinkedOrderedList<>();

        System.out.println("Is empty: " + list.isEmpty());

        list.add(5);
        //verifyModCount(list, 1); // Espera-se que o modCount seja 1 após uma adição
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(4);
        //verifyModCount(list, 5); // Espera-se que o modCount seja 5 após uma adição

        System.out.println("Ordered List:");
        for (Integer element : list) {
            System.out.print(element + " ");
        }
        System.out.println("\nSize: " + list.size());
        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());
        System.out.println("Contains 3: " + list.contains(3));
        System.out.println("Contains 8: " + list.contains(8));
        System.out.println("Is empty: " + list.isEmpty());
        System.out.println("--------------------");

        Iterator<Integer> it = list.iterator();
        System.out.println("Iterator: ");
        while (it.hasNext()) {
            Integer i = it.next();
            if(i.equals(2)) {
                it.remove();
            }
        }
        System.out.println("List: " + list);

        //verifyModCount(list, 6); // Espera-se que o modCount seja 6 após uma remoção
    }


/*
    // Método auxiliar para verificar o valor do modCount
    private static void verifyModCount(DoubleLinkedOrderedList<?> list, int expectedModCount) {
        if (list.getModCount() == expectedModCount) {
            System.out.println("modCount atualizado corretamente: " + expectedModCount);
        } else {
            System.out.println("modCount não corresponde ao esperado. Esperado: "
                    + expectedModCount + ", Atual: " + list.getModCount());
        }
    }

*/

}

