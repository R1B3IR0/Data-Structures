package algorithms.demos.ex2;

import algorithms.SortingandSearchingLinkedList;
import algorithms.demos.ex1.Car;
import collections.lists.OrderedLinkedList;

public class CarLinkedList {
    public static void main(String[] args) {
        //Tests the sorting and searching algorithms for a linked list of cars
        OrderedLinkedList<Car> cars = new OrderedLinkedList<>();
        cars.add(new Car("Toyota", "Corolla", 2020));
        cars.add(new Car("Honda", "Civic", 2019));
        cars.add(new Car("Ford", "Fusion", 2021));
        cars.add(new Car("Tesla", "Model S", 2022));
        cars.add(new Car("BMW", "X5", 2023));
        System.out.println("Original list of cars: ");

        System.out.println(cars.toString());

        //Sorting the linked list of cars by year (for binary search to work properly)
        SortingandSearchingLinkedList.quickSort(cars, 0, cars.size() - 1);

        //Printing the sorted list of cars
        System.out.println(cars);

        Car targetCar = new Car("Ford2", "Fusion2", 2021);

        //Linear search
        boolean linearResult = SortingandSearchingLinkedList.linearSearch(cars, 0, cars.size() - 1, targetCar);
        System.out.println("\nLinear search result: " + linearResult);

        //Binary search
        boolean binaryResult = SortingandSearchingLinkedList.binarySearch(cars, 0, cars.size() - 1, targetCar);
        System.out.println("\nBinary search result: " + binaryResult);

        cars.toString();
    }
}
