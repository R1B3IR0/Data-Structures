package collections.demos;

import collections.lists.DoubleLinkedUnorderedList;

public class DemoDoubleLinkedUnorderedList {
    public static void main(String[] args) {
        DoubleLinkedUnorderedList<Integer> list = new DoubleLinkedUnorderedList<>();
        System.out.println("Is empty: " + list.isEmpty());
        //verifyModCount(list, 0); // Espera-se que o modCount seja 0
        list.addToFront(5);
        //verifyModCount(list, 1); // Espera-se que o modCount seja 1 após uma adição
        list.addToFront(2);
        //verifyModCount(list, 2); // Espera-se que o modCount seja 2 após uma remoção
        list.addToFront(8);
        //verifyModCount(list, 3); // Espera-se que o modCount seja 3 após uma remoção
        System.out.println("List: " + list);
        System.out.println("Is empty: " + list.isEmpty());

        list.addAfter(1, 2);
        System.out.println("List: " + list);

        list.addAfter(4, 5);
        System.out.println("List: " + list);

        list.remove(2);
        System.out.println("List: " + list);

        list.addToFront(3);
        System.out.println("List: " + list);

        list.addToRear(7);
        System.out.println("List: " + list);
        //verifyModCount(list, 8); // Espera-se que o modCount seja 8 após uma remoção
    }
/*
    // Método auxiliar para verificar o valor do modCount
    private static void verifyModCount(DoubleLinkedUnorderedList<?> list, int expectedModCount) {
        if (list.getModCount() == expectedModCount) {
            System.out.println("modCount atualizado corretamente: " + expectedModCount);
        } else {
            System.out.println("modCount não corresponde ao esperado. Esperado: "
                    + expectedModCount + ", Atual: " + list.getModCount());
        }
    }
*/
}
