package model;

import java.time.LocalDate;

public class Rental {
    private Car car;
    private Customer customer;
    private LocalDate rentalDate;

    public Rental(Car car, Customer customer) {
        this.car = car;
        this.customer = customer;
        this.rentalDate = LocalDate.now();
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    @Override
    public String toString() {
        return "Rental Record:\n" +
                "Customer: " + customer.getName() + "\n" +
                "Car: " + car.getBrand() + " " + car.getModel() + "\n" +
                "Price/Day: $" + car.getPricePerDay() + "\n" +
                "Date: " + rentalDate + "\n";
    }
}
