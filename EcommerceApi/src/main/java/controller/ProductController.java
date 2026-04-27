com.ws101.capoquian.banawis.controller;

import com.ws101.yourlastname.model.Product;
import com.ws101.yourlastname.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products") // Base path [cite: 86, 88]
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping // GET /api/v1/products [cite: 88]
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts()); // 200 OK [cite: 113]
    }

    @GetMapping("/{id}") // GET /api/v1/products/{id} [cite: 89]
    public ResponseEntity<Product> getProductById(@PathVariable String id) { [cite: 103]
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // 404 Not Found [cite: 113]
    }

    @PostMapping // POST /api/v1/products [cite: 93]
    public ResponseEntity<Product> createProduct(@RequestBody Product product) { [cite: 102]
        Product created = productService.createProduct(product);
        return new ResponseEntity<>(created, HttpStatus.CREATED); // 201 Created [cite: 113]
    }

    @DeleteMapping("/{id}") // DELETE /api/v1/products/{id} [cite: 96]
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id) 
            ? ResponseEntity.noContent().build() // 204 No Content [cite: 113]
            : ResponseEntity.notFound().build();
    }
}