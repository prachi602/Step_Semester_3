package rental.class_problems;

public class Customer {

    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Customer ID cannot be blank"
            );
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Customer name cannot be blank"
            );
        }

        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}