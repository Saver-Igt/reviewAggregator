package dev.siraev.services;

import dev.siraev.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories() throws Exception;

    Category getCategory(Long id) throws Exception;

    Category addCategory(Category category) throws Exception;

    Category editCategory(Long id, Category category) throws Exception;

    void deleteCategory(Long id) throws Exception;
}
