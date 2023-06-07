package dev.siraev.rest;

import dev.siraev.models.Category;
import dev.siraev.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")

public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> getCategories() throws Exception{
        return categoryService.getCategories();
    }
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) throws Exception{
        return categoryService.getCategory(id);
    }
    @PostMapping
    public Category addCategory(@RequestBody Category category) throws Exception{
        return categoryService.addCategory(category);
    }
    @PutMapping("/{id}")
    public Category editCategory(@PathVariable Long id, @RequestBody Category category) throws Exception{
        return categoryService.editCategory(id, category);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable Long id)throws Exception{
        categoryService.deleteCategory(id);
    }
}
