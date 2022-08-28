package com.example.lab3.controller;

import com.example.lab3.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers;

    public CustomerController() {
        List<Customer> keepCustomers = new ArrayList<>();
        Customer cust1 = new Customer("1010", "John", "male", 25);
        Customer cust2 = new Customer("1018", "Peter", "male", 24);
        Customer cust3 = new Customer("1019", "Sara", "female", 23);
        Customer cust4 = new Customer("1110", "Rose", "female", 23);
        Customer cust5 = new Customer("1001", "Emma", "female", 30);
        keepCustomers.add(cust1);
        keepCustomers.add(cust2);
        keepCustomers.add(cust3);
        keepCustomers.add(cust4);
        keepCustomers.add(cust5);
        this.customers = keepCustomers;

    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("/customerbyid/{id}")
    public Customer getCustomerById(@PathVariable("id") String ID) {
        for (Customer cus :  this.customers) {
            if (cus.getID().equals(ID)){
                return cus;
            }
        }
        return null;
    }

    @GetMapping("/customerbyname/{n}")
    public Customer getCustomerByName(@PathVariable String n) {
        for (Customer cus :  this.customers) {
            if (cus.getName().equals(n)){
                return cus;
            }
        }
        return null;
    }

    @DeleteMapping("/customerDelByid/{id}")
    public boolean delCustomerByID(@PathVariable("id") String ID) {
        for (Customer cust : customers) {
            if (cust.getID().equals(ID)){
                customers.remove(cust);
                return true;
            }
        }
        return false;
    }

    @DeleteMapping("/customerDelByname/{n}")
    public boolean delCustomerByName(@PathVariable String n) {
        for (Customer cust : customers) {
            if (cust.getName().equals(n)){
                customers.remove(cust);
                return true;
            }
        }
        return false;
    }

    @GetMapping("/addCustomer")
    public boolean addCustomer(@RequestParam String ID, @RequestParam String n, @RequestParam String s, @RequestParam int a) {
        try {
            Customer newCust = new Customer(ID, n, s, a);
            customers.add(newCust);
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }

    @PostMapping("/addCustomer2")
    public boolean addCustomer2(@RequestParam String ID, @RequestParam String n, @RequestParam String s, @RequestParam int a) {
        try {
            Customer newCust = new Customer(ID, n, s, a);
            customers.add(newCust);
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }
}
