package algorithms.demos.ex2;

import algorithms.SortingandSearchingLinkedList;
import algorithms.demos.ex1.Car;
import collections.lists.OrderedLinkedList;
import collections.lists.UnorderedLinkedList;

public class Demo {
    public static void main(String[] args) {
        // Criando uma lista ligada de carros
       UnorderedLinkedList<Car> carList = new UnorderedLinkedList<>();

        // Adicionar carros à lista
        carList.addToFront(new Car("Brand1", "ModelA", 2010));
        carList.addToRear(new Car("Brand2", "ModelB", 2015));
        carList.addToRear(new Car("Brand3", "ModelC", 2020));
        carList.addToRear(new Car("Brand4", "ModelD", 2012));
        carList.addToRear(new Car("Brand5", "ModelE", 2018));

        // Exemplo de uso da pesquisa linear para encontrar um carro específico na lista
        Car carToFind = new Car("Brand3", "ModelC", 2020);
        boolean linearSearchResult = SortingandSearchingLinkedList.linearSearch(carList, 0, carList.size() - 1, carToFind);
        System.out.println("Linear Search Result for Car 'Brand3 ModelC 2020': " + linearSearchResult); /* true */

        // Ordenando a lista antes de usar a pesquisa binária
        SortingandSearchingLinkedList.quickSort(carList, 0, carList.size() - 1);
        System.out.println("Sorted List: ");
        for(Car car : carList) {
            System.out.println(car);
        }

        // Exemplo de uso da pesquisa binária para encontrar um carro específico na lista não ordenada
        boolean binarySearchResult = SortingandSearchingLinkedList.binarySearch(carList, 0, carList.size() - 1, carToFind);
        System.out.println("Binary Search Result for Car 'Brand3 ModelC 2020': " + binarySearchResult); /* false */


        OrderedLinkedList<Car> orderedCarList = new OrderedLinkedList<>();

        // Adicionar carros à lista
        orderedCarList.add(new Car("Brand1", "ModelA", 2010));
        orderedCarList.add(new Car("Brand2", "ModelB", 2015));
        orderedCarList.add(new Car("Brand3", "ModelC", 2020));
        orderedCarList.add(new Car("Brand4", "ModelD", 2012));
        orderedCarList.add(new Car("Brand5", "ModelE", 2018));

        SortingandSearchingLinkedList.quickSort(orderedCarList, 0, orderedCarList.size() - 1);
        System.out.println("Sorted List: ");
        for(Car car : orderedCarList) {
            System.out.println(car);
        }

        SortingandSearchingLinkedList.mergeSort(orderedCarList, 0, orderedCarList.size() - 1);
        System.out.println("Sorted List: ");
        for(Car car : orderedCarList) {
            System.out.println(car);
        }

        SortingandSearchingLinkedList.bubbleSort(orderedCarList);
        System.out.println("Sorted List: ");
        for(Car car : orderedCarList) {
            System.out.println(car);
        }

        SortingandSearchingLinkedList.insertionSort(orderedCarList);
        System.out.println("Sorted List: ");
        for(Car car : orderedCarList) {
            System.out.println(car);
        }
    }
}
