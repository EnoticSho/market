package gb.ru.market.core.converter;

import gb.ru.market.api.CategoryDto;
import gb.ru.market.core.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    private final ProductConverter productConverter;

    @Autowired
    public CategoryConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public CategoryDto entityToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(categoryDto.getTitle());
        categoryDto.setProductList(category.getProductEntities().stream()
                .map(productConverter::entityToDto).toList());
        return categoryDto;
    }
}
