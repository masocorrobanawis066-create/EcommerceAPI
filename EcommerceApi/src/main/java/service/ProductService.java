com.ws101.capoquian.banawis.service;

import com.ws101.yourlastname.model.Product;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {
    // In-memory storage [cite: 66]
    private final List<Product> productList = new ArrayList<>();

    public ProductService() {
        // Initialize with sample data [cite: 67]
        for (int i = 1; i <= 10; i++) {
            productList.add(new Product(String.valueOf(i), "Product " + i, "Desc", 10.0 * i, "Category", 100, "url"));
        }
    }

    public List<Product> getAllProducts() { return productList; } [cite: 69]

    public Optional<Product> getProductById(String id) { [cite: 70]
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Product createProduct(Product product) {
        product.setId(UUID.randomUUID().toString()); // ID Generation [cite: 77]
        productList.add(product);
        return product;
    }

    public boolean deleteProduct(String id) { [cite: 73]
        return productList.removeIf(p -> p.getId().equals(id));
    }
    
    // Additional methods for Update and Filtering would go here [cite: 72, 74]
}