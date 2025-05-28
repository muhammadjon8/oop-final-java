package model;

public class Car {
    private int id;
    private String brand;
    private String model;
    private boolean isAvailable;

    public Car(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "ID" + id + " - " + brand + " " + model + " | " + (isAvailable ? "Available" : "Rented");
    }
}
