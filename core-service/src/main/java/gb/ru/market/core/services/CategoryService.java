package gb.ru.market.core.services;

import gb.ru.market.core.repository.CategoryRepository;
import gb.ru.market.core.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findCategoriesByTitle(title);
    }
}
