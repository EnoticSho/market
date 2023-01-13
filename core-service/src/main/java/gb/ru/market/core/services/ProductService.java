package gb.ru.market.core.services;

import gb.ru.market.api.ProductDto;
import gb.ru.market.core.converter.ProductConverter;
import gb.ru.market.core.repository.ProductRepository;
import gb.ru.market.core.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product createNewProduct(ProductDto productDto) {
        return productConverter.dtoToEntity(productDto);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
