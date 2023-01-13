package gb.ru.market.core.converter;

import gb.ru.market.api.ProductDto;
import gb.ru.market.api.ResourceNotFoundException;
import gb.ru.market.core.entity.Category;
import gb.ru.market.core.entity.Product;
import gb.ru.market.core.services.CategoryService;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private final CategoryService categoryService;

    public ProductConverter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory().
                        getTitle());
    }

    public Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).orElseThrow(() -> new ResourceNotFoundException("not"));
        product.setCategory(category);
        return product;
    }
}
