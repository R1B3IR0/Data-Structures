package collections.demos;

import collections.lists.OrderedLinkedList;

import java.util.Iterator;

public class DemoOrderedLinkedList {
    public static void main(String[] args) {
        OrderedLinkedList<Integer> list = new OrderedLinkedList<>();
        list.add(1);
        //verifyModCount(list, 1); // Espera-se que o modCount seja 1 após uma remoção
        list.add(2);
        //verifyModCount(list, 2); // Espera-se que o modCount seja 2 após uma remoção
        list.add(3);
        //verifyModCount(list, 3); // Espera-se que o modCount seja 3 após uma remoção
        list.add(4);
        //verifyModCount(list, 4); // Espera-se que o modCount seja 4 após uma remoção
        list.add(5);
        //verifyModCount(list, 5); // Espera-se que o modCount seja 5 após uma remoção

        System.out.println(list);

        Iterator<Integer> it = list.iterator();
        System.out.println("Iterator: ");
        while (it.hasNext()) {
            Integer i = it.next();
            if(i.equals(8)) {
                it.remove();
                //verifyModCount(list, 6); // Espera-se que o modCount seja 6 após uma remoção
            }
        }

        System.out.println("List: \n" + list);
        System.out.println("List size: " + list.size());
        System.out.println("List isEmpty: " + list.isEmpty());
        System.out.println("List contains 3: " + list.contains(3));
        System.out.println("List contains 8: " + list.contains(8));
        System.out.println("List first: " + list.first());
        System.out.println("List last: " + list.last());
        System.out.println("List remove first: " + list.removeFirst());
        System.out.println(list.toString());
    }


    /* Colocar GetModCount() na classe LinkedList
    // Método auxiliar para verificar o valor do modCount
    private static void verifyModCount(LinkedOrderedList<?> list, int expectedModCount) {
        if (list.getModCount() == expectedModCount) {
            System.out.println("modCount atualizado corretamente: " + expectedModCount);
        } else {
            System.out.println("modCount não corresponde ao esperado. Esperado: "
                    + expectedModCount + ", Atual: " + list.getModCount());
        }
    }
     */
}
