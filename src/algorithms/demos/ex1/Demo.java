package algorithms.demos.ex1;

import algorithms.SortingandSearchingArray;


import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new Car("Toyota", "Corolla", 2020);
        cars[1] = new Car("Honda", "Civic", 2019);
        cars[2] = new Car("Ford", "Fusion", 2021);
        cars[3] = new Car("Tesla", "Model S", 2022);
        cars[4] = new Car("BMW", "X5", 2023);

        // Sorting the array of cars by year (for binary search to work properly)
        Arrays.sort(cars, Comparator.comparingInt(Car::getYear));

        Car targetCar = new Car("Ford", "Fusion", 2021);

        // Linear search
        boolean linearResult = SortingandSearchingArray.linearSearch(cars, 0, cars.length - 1, targetCar);
        System.out.println("Linear search result: " + linearResult);

        // Binary search
        boolean binaryResult = SortingandSearchingArray.binarySearch(cars, 0, cars.length - 1, targetCar);
        System.out.println("Binary search result: " + binaryResult);

       cars.toString();
    }
}
