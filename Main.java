package com.hw.model;

import com.hw.model.Customer;
import com.hw.model.Order;
import com.hw.model.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
// Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100

        ArrayList<Order> booksOrders = getOrders();
        List<Product> books = booksOrders.stream()
                .flatMap(e -> e.getProducts().stream())
                .filter(e -> e.getCategory().equalsIgnoreCase("books"))
                .filter(e -> e.getPrice() > 100)
                .collect(Collectors.toList());

        System.out.println(books);

// Exercise 2 — Obtain a list of order with products belong to category “Baby”
        ArrayList<Order> babyOrders = getOrders();
        List<Product> baby = babyOrders.stream()
                .flatMap(e -> e.getProducts().stream())
                .filter(e -> e.getCategory().equalsIgnoreCase("baby"))
                .collect(Collectors.toList());

        System.out.println(baby);

// Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
//        (не работает)

//        ArrayList<Order> toysOrders = getOrders();
//        List<Product> toys = toysOrders.stream()
//                .flatMap(e -> e.getProducts().stream())
//                .filter(e -> e.getCategory().equalsIgnoreCase("toys"))
//                .map(e -> (e.getPrice() * 0.9))
//                .collect(Collectors.toList());
//        System.out.println(toys);


// Exercise 5 — Get the cheapest products of “Books” category

        ArrayList<Order> cheapestProduct = getOrders();
        Optional<Product> cheap = cheapestProduct.stream()
                .flatMap(e -> e.getProducts().stream())
                .filter(e -> e.getCategory().equalsIgnoreCase("books"))
                .min(Comparator.comparing(Product::getPrice));
        System.out.println(cheap);

    }

    private static ArrayList<Order> getOrders() {
        Order order = new Order();
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);
        Product product1 = new Product(1L,"имяОдин", "Toys", 58.5);
        Product product2 = new Product(2L,"имяДва", "Books", 101.5);
        Product product3 = new Product(3L,"имяТри", "Baby", 39.5);
        Product product4 = new Product(4L,"имяЧетыре", "Toys", 85.4);
        Product product5 = new Product(5L,"имяПять", "Books", 66.4);
        Product product6 = new Product(6L,"имяШесть", "Other", 74.1);
        Product product7 = new Product(7L,"имяСемь", "Baby", 38.4);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);


        Customer customer = new Customer(1L, "customerName", 5);
        order.setId(1L);
        order.setOrderDate(LocalDate.now().minusDays(1));
        order.setDeliveryDate(LocalDate.now().plusDays(7));
        order.setStatus("someStatus");
        order.setCustomer(customer);
        order.setProducts(products);

        return orders;
    }
}
