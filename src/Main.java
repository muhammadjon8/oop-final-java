import model.Car;
import model.Customer;
import service.CarService;
import service.CustomerService;
import service.RentalService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarService carService = new CarService();
        CustomerService customerService = new CustomerService();
        RentalService rentalService = new RentalService();

        int carId = 1, customerId = 1;
        while (true) {
            System.out.println("\n==== Rent-Car Management ====");
            System.out.println("1. Add Car");
            System.out.println("2. Add Customer");
            System.out.println("3. View Available Cars");
            System.out.println("4. Rent Car");
            System.out.println("5. Return Car");
            System.out.println("6. View Rental History");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    carService.addCar(new Car(carId++, brand, model));
                    System.out.println("Car added successfully.");
                    break;

                case 2:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    customerService.addCustomer(new Customer(customerId++, name));
                    System.out.println("Customer added successfully.");
                    break;

                case 3:
                    System.out.println("Available Cars:");
                    for (Car car : carService.getAvailableCars()) {
                        System.out.println(car);
                    }
                    break;

                case 4:
                    System.out.print("Enter car ID: ");
                    int rentCarId = scanner.nextInt();
                    System.out.print("Enter customer ID: ");
                    int custId = scanner.nextInt();
                    Car carToRent = carService.getCarById(rentCarId);
                    Customer rentingCustomer = customerService.getCustomerById(custId);
                    if (carToRent != null && rentingCustomer != null) {
                        rentalService.rentCar(carToRent, rentingCustomer);
                    } else {
                        System.out.println("Invalid car or customer ID.");
                    }
                    break;

                case 5:
                    System.out.print("Enter car ID to return: ");
                    int returnCarId = scanner.nextInt();
                    Car carToReturn = carService.getCarById(returnCarId);
                    if (carToReturn != null && !carToReturn.isAvailable()) {
                        rentalService.returnCar(carToReturn);
                    } else {
                        System.out.println("Invalid car ID or car is already available.");
                    }
                    break;

                case 6:
                    System.out.println("Rental History:");
                    rentalService.getAllRentals().forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Thank you for using Rent-Car Management System.");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
