package dev.siraev.services;

import dev.siraev.models.Category;
import dev.siraev.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceDB implements CategoryService{
    private final CategoryRepository categoryRepository;
    public CategoryServiceDB(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getCategories() throws Exception {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) throws Exception {
        return categoryRepository.findById(id).orElse(new Category());
    }

    @Override
    public Category addCategory(Category category) throws Exception {
        return categoryRepository.save(category);
    }

    @Override
    public Category editCategory(Long id, Category category) throws Exception {
        Category findCategory = getCategory(id);
        findCategory.setName(findCategory.getName());
        return categoryRepository.save(findCategory);
    }

    @Override
    public void deleteCategory(Long id) throws Exception {
        categoryRepository.deleteById(id);
    }
}
