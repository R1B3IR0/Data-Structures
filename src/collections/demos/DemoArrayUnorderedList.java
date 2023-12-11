package collections.demos;

import collections.lists.arrayLists.ArrayUnorderedList;

public class DemoArrayUnorderedList {
    public static void main(String[] args) {
        ArrayUnorderedList<Integer> list = new ArrayUnorderedList<>();
        System.out.println("Is empty: " + list.isEmpty());
        //verifyModCount(list, 0); // Espera-se que o modCount seja 0 após uma adição
        list.addToFront(5);
        //verifyModCount(list, 1); // Espera-se que o modCount seja 1 após uma adição
        list.addToFront(2);
        list.addToFront(8);
        System.out.println("List: " + list);
        System.out.println("Is empty: " + list.isEmpty());

        list.addAfter(1, 2);
        System.out.println("List: " + list);

        list.addAfter(4, 5);
        System.out.println("List: " + list);

        list.remove(2);
        System.out.println("List: " + list);
    }
/*
    // Método auxiliar para verificar o valor do modCount
    private static void verifyModCount(ArrayUnorderedList<?> list, int expectedModCount) {
        if (list.getModCount() == expectedModCount) {
            System.out.println("modCount atualizado corretamente: " + expectedModCount);
        } else {
            System.out.println("modCount não corresponde ao esperado. Esperado: "
                    + expectedModCount + ", Atual: " + list.getModCount());
        }
    }
*/
}
