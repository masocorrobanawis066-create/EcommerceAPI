@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int stockQuantity;
    private String imageUrl; // optional
}
2.2 Implement Constructors and Accessors

• Use Lombok annotations:

◦ @NoArgsConstructor: Default constructor.

◦ @AllArgsConstructor: Constructor with all fields.

◦ @Getter, @Setter: Generate getters and setters.

◦ @ToString, @EqualsAndHashCode: Utility methods.

◦ Alternatively, use @Data to combine all above.

2.3 VCS Checkpoint
git add .
git commit -m "feat: create Product entity with Lombok"
git push origin feat:product-model
Task 3: In-Memory Data Storage

3.1 Create Service Layer

In service package, create ProductService:
@Service
public class ProductService {
    private final List<Product> productList = new ArrayList<>();
    private Long nextId = 1L;

    // Initialize with sample data
    public ProductService() {
        productList.add(new Product(nextId++, "Laptop", "Gaming laptop", 999.99, "Electronics", 10, "url"));
        // Add at least 10 products
    }

    // CRUD methods
    public List<Product> getAllProducts() { return new ArrayList<>(productList); }

    public Product getProductById(Long id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Product createProduct(Product product) {
        product.setId(nextId++);
        productList.add(product);
        return product;
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        // Implementation
    }

    public void deleteProduct(Long id) {
        // Implementation
    }

    public List<Product> filterByCategory(String category) {
        // Implementation
    }

    // Other filter methods
}
3.2 ID Generation Strategy

• Use a counter (nextId) to ensure unique IDs.

• Increment after each creation.

3.3 VCS Checkpoint
git add .
git commit -m "feat: implement ProductService with in-memory storage"
git push origin feat:service-layer