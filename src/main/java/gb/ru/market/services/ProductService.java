package gb.ru.market.services;

import gb.ru.market.converter.ProductConverter;
import gb.ru.market.dto.ProductDto;
import gb.ru.market.entity.Product;
import gb.ru.market.repository.ProductRepository;
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
