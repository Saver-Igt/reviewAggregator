package com.example.reviewAggregator.repository;

import com.example.reviewAggregator.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Integer> {
}
