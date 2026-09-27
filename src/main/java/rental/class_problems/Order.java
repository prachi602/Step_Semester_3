package rental.class_problems;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public enum Status {
        PENDING,
        PAID
    }

    private String orderId;
    private Customer customer;
    private List<Product> products;
    private Status status;

    public Order(String orderId, Customer customer) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Order ID cannot be blank"
            );
        }

        if (customer == null) {
            throw new IllegalArgumentException(
                    "Customer cannot be null"
            );
        }

        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.status = Status.PENDING;
    }

    public void addProduct(Product product) {
        if (status == Status.PAID) {
            throw new IllegalStateException(
                    "Cannot modify a paid order"
            );
        }

        if (product == null) {
            throw new IllegalArgumentException(
                    "Product cannot be null"
            );
        }

        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    public boolean makePayment(PaymentMethod paymentMethod) {

        if (paymentMethod == null) {
            return false;
        }

        if (products.isEmpty()) {
            System.out.println(
                    "Cannot make payment for an empty order."
            );
            return false;
        }

        if (status == Status.PAID) {
            return false;
        }

        boolean successful =
                paymentMethod.processPayment(calculateTotal());

        if (successful) {
            status = Status.PAID;
            System.out.println(
                    "Payment successful. Order is now PAID."
            );
        } else {
            System.out.println(
                    "Payment failed. Order remains PENDING."
            );
        }

        return successful;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Status getStatus() {
        return status;
    }
}