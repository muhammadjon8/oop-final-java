package service;

import model.Car;
import model.Customer;
import model.Rental;
import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private List<Rental> rentals = new ArrayList<>();

    public void rentCar(Car car, Customer customer) {
        if (car.isAvailable()) {
            car.setAvailable(false);
            rentals.add(new Rental(car, customer));
            System.out.println("Rental successful!");
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
}
