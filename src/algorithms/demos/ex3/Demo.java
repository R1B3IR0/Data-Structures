package algorithms.demos.ex3;

import algorithms.SortingandSearchingArray;

public class Demo {
    public static void main(String[] args) {
        // Testes com SortingandSearchingArray
        Pessoa[] pessoas = {
                new Pessoa("Alice", 25),
                new Pessoa("Bob", 20),
                new Pessoa("Charlie", 30),
                new Pessoa("David", 22),
                new Pessoa("Eva", 28)
        };

        // Testando os algoritmos de ordenação
        System.out.println("Array original:");
        printArray(pessoas);

        SortingandSearchingArray.selectionSort(pessoas);
        System.out.println("\nSelection Sort:");
        printArray(pessoas);

        SortingandSearchingArray.insertionSort(pessoas);
        System.out.println("\nInsertion Sort:");
        printArray(pessoas);

        SortingandSearchingArray.bubbleSort(pessoas);
        System.out.println("\nBubble Sort:");
        printArray(pessoas);

        SortingandSearchingArray.quickSort(pessoas, 0, pessoas.length - 1);
        System.out.println("\nQuick Sort:");
        printArray(pessoas);

        SortingandSearchingArray.mergeSort(pessoas, 0, pessoas.length - 1);
        System.out.println("\nMerge Sort:");
        printArray(pessoas);
    }

    private static void printArray(Pessoa[] array) {
        for (Pessoa pessoa : array) {
            System.out.println(pessoa);
        }
    }
}
