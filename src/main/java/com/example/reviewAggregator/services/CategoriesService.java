package com.example.reviewAggregator.services;

import com.example.reviewAggregator.models.Category;

import java.util.List;

public interface CategoriesService {
    List<Category> getCategories() throws Exception;

    Category getCategory(int id) throws Exception;

    Category addCategory(Category category) throws Exception;

    Category editCategory(int id, String name) throws Exception;

    void deleteCategory(int id) throws Exception;
}
