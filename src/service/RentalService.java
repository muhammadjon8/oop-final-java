package service;

import model.Car;
import model.Customer;
import model.Rental;

import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private final List<Rental> rentals = new ArrayList<>();

    public void rentCar(Car car, Customer customer) {
        if (car.isAvailable()) {
            car.setAvailable(false);
            Rental rental = new Rental(car, customer);
            rentals.add(rental);
            System.out.println("Rental successful!");
            System.out.println(rental);
        } else {
            System.out.println("Car is not available.");
        }
    }

    public void returnCar(Car car) {
        car.setAvailable(true);
        System.out.println("Car returned successfully.");
    }

    public List<Rental> getAllRentals() {
        return rentals;
    }

    public void printAllRentalRecords() {
        if (rentals.isEmpty()) {
            System.out.println("No rentals found.");
        } else {
            for (Rental rental : rentals) {
                System.out.println(rental);
            }
        }
    }
}
