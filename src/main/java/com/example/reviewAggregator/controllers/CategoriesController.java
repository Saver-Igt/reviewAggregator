package com.example.reviewAggregator.controllers;

import com.example.reviewAggregator.models.Category;
import com.example.reviewAggregator.services.CategoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/categories")
public class CategoriesController {
    private final CategoriesService categoriesService;
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }
    @GetMapping()
    public @ResponseBody
    List<Category> getCategories() throws Exception{
        return categoriesService.getCategories();
    }
    @GetMapping("/{id}")
    public @ResponseBody
    Category getCategory(@PathVariable int id) throws Exception{
        return categoriesService.getCategory(id);
    }
    @PostMapping
    public @ResponseBody
    Category addCategory(@RequestBody Category category) throws Exception{
        return categoriesService.addCategory(category);
    }
    @PutMapping("/{id}")
    public@ResponseBody
    Category editCategory(@PathVariable int id,@RequestBody String name) throws Exception{
        return categoriesService.editCategory(id, name);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable int id)throws Exception{
        categoriesService.deleteCategory(id);
    }
}
