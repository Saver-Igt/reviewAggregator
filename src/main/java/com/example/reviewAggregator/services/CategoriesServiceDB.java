package com.example.reviewAggregator.services;

import com.example.reviewAggregator.models.Category;
import com.example.reviewAggregator.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriesServiceDB implements CategoriesService{
    private final CategoriesRepository categoriesRepository;

    public CategoriesServiceDB(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<Category> getCategories() throws Exception {
        return categoriesRepository.findAll();
    }

    @Override
    public Category getCategory(int id) throws Exception {
        return categoriesRepository.findById(id).orElse(new Category());
    }

    @Override
    public Category addCategory(Category category) throws Exception {
        return categoriesRepository.save(category);
    }

    @Override
    public Category editCategory(int id, String name) throws Exception {
        Category findCategory = getCategory(id);
        findCategory.setName(name);
        return categoriesRepository.save(findCategory);
    }

    @Override
    public void deleteCategory(int id) throws Exception {
        categoriesRepository.deleteById(id);
    }
}
