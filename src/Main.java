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

            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Enter brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter price per day: ");
                    double price;
                    try {
                        price = Double.parseDouble(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid price. Car not added.");
                        break;
                    }

                    carService.addCar(new Car(carId++, brand, model, price));
                    System.out.println("✅ Car added successfully.");
                    break;

                case 2:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    try {
                        customerService.addCustomer(new Customer(customerId++, name));
                        System.out.println("✅ Customer added successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ " + e.getMessage());
                        customerId--; // rollback ID if failed
                    }
                    break;

                case 3:
                    System.out.println("🚗 Available Cars:");
                    carService.getAvailableCars().forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter car ID: ");
                    int rentCarId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter customer ID: ");
                    int custId = Integer.parseInt(scanner.nextLine());

                    Car carToRent = carService.getCarById(rentCarId);
                    Customer rentingCustomer = customerService.getCustomerById(custId);

                    if (carToRent != null && rentingCustomer != null) {
                        rentalService.rentCar(carToRent, rentingCustomer);
                    } else {
                        System.out.println("❌ Invalid car or customer ID.");
                    }
                    break;

                case 5:
                    System.out.print("Enter car ID to return: ");
                    int returnCarId = Integer.parseInt(scanner.nextLine());
                    Car carToReturn = carService.getCarById(returnCarId);

                    if (carToReturn != null && !carToReturn.isAvailable()) {
                        rentalService.returnCar(carToReturn);
                    } else {
                        System.out.println("❌ Invalid car ID or car is already available.");
                    }
                    break;

                case 6:
                    System.out.println("📜 Rental History:");
                    rentalService.printAllRentalRecords();
                    break;

                case 0:
                    System.out.println("👋 Thank you for using Rent-Car Management System.");
                    return;

                default:
                    System.out.println("❌ Invalid option.");
            }
        }
    }
}
