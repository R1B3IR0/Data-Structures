package algorithms.demos.ex1;

public class Car implements Comparable<Car> {

    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns a string representation of the car
     * @return
     */
    @Override
    public String toString() {
        String str = " ";

        str += "Brand: " + brand + "\n";
        str += "Model: " + model + "\n";
        str += "Year: " + year + "\n";
        return str;
    }

    /**
     * Compares two cars by year
     * @param o
     * @return
     */
    @Override
    public int compareTo(Car o) {
        // Compare by year
        return this.year - o.year;
    }
}
