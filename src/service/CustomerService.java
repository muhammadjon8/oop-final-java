package service;

import model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        if (getCustomerById(customer.getId()) != null) {
            throw new IllegalArgumentException("Customer with ID " + customer.getId() + " already exists");
        }

        if (isNameTaken(customer.getName())) {
            throw new IllegalArgumentException("Customer name '" + customer.getName() + "' is already in use");
        }

        customers.add(customer);
    }

    private boolean isNameTaken(String name) {
        return customers.stream()
                .anyMatch(c -> c.getName().equalsIgnoreCase(name));
    }

    public Customer getCustomerById(int id) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
