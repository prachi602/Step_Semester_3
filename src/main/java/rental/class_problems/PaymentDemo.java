package rental.class_problems;

public class PaymentDemo {

    public static void main(String[] args) {

        Customer customerX =
                new Customer("C201", "Customer X");

        Customer customerZ =
                new Customer("C202", "Customer Z");

        Product laptop =
                new Product("P101", "Laptop", 1000);

        Product mouse =
                new Product("P102", "Mouse", 50);

        // Customer X's order
        Order orderX =
                new Order("O101", customerX);

        orderX.addProduct(laptop);
        orderX.addProduct(mouse);

        PaymentMethod creditCard =
                new CreditCardPayment(true);

        orderX.makePayment(creditCard);

        System.out.println(
                "Order X status: "
                        + orderX.getStatus()
        );

        // Empty order
        Order emptyOrder =
                new Order("O102", customerX);

        PaymentMethod bankTransfer =
                new BankTransferPayment(true);

        emptyOrder.makePayment(bankTransfer);

        System.out.println(
                "Empty order status: "
                        + emptyOrder.getStatus()
        );

        // Customer Z's failed PayPal payment
        Order orderZ =
                new Order("O103", customerZ);

        orderZ.addProduct(mouse);

        PaymentMethod payPal =
                new PayPalPayment(false);

        orderZ.makePayment(payPal);

        System.out.println(
                "Order Z status: "
                        + orderZ.getStatus()
        );
        Order upiOrder =
                new Order("O104", customerX);

        upiOrder.addProduct(mouse);

        PaymentMethod upi =
                new UPIPayment(true);

        upiOrder.makePayment(upi);

        System.out.println(
                "UPI order status: "
                        + upiOrder.getStatus()
        );
    }
    }