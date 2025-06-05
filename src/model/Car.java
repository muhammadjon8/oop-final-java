package model;

public class Car {
    private int id;
    private String brand;
    private String model;
    private boolean isAvailable;
    private double pricePerDay;

    public Car(int id, String brand, String model, double pricePerDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
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

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return "ID" + id + " - " + brand + " " + model + " | Price/Day: $" + pricePerDay + " | " +
                (isAvailable ? "Available" : "Rented");
    }
}
