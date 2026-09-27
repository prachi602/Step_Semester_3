package rental.class_problems;

public class Product {

    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be blank");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be blank");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }

        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}