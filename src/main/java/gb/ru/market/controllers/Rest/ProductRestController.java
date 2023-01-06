package gb.ru.market.controllers.Rest;

import gb.ru.market.dto.ProductDto;
import gb.ru.market.entity.Product;
import gb.ru.market.exception.ResourceNotFoundException;
import gb.ru.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {
    @Autowired
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<ProductDto> showAllProducts() {
        return productService.getAllProducts().stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getPrice())).toList();
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден, id: " + id));
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
