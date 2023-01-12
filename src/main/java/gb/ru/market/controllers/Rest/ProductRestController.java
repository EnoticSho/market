package gb.ru.market.controllers.Rest;

import gb.ru.market.converter.ProductConverter;
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

    private final ProductService productService;
    private final ProductConverter productConverter;

    @Autowired
    public ProductRestController(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    @GetMapping("/")
    public List<ProductDto> showAllProducts() {
        return productService.getAllProducts().stream()
                .map(productConverter::entityToDto).toList();
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден, id: " + id));
        return productConverter.entityToDto(product);
    }

    @PostMapping
    public ProductDto createNewProduct(@RequestBody ProductDto productDto) {
        Product product = productService.createNewProduct(productDto);
        return productConverter.entityToDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
