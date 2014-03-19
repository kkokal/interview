package com.kokal.one;

public class Cart {
    private Customer customer;

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
