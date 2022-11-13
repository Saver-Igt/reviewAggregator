package com.example.reviewAggregator.controllers;

import com.example.reviewAggregator.models.Product;
import com.example.reviewAggregator.models.ProductType;
import com.example.reviewAggregator.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductService productService;
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public @ResponseBody
    List<Product> getProducts() throws Exception{
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public @ResponseBody
    Product getProduct(@PathVariable int id) throws Exception{
        return productService.getProduct(id);
    }
    @PostMapping
    public @ResponseBody
    Product addProduct(@RequestBody Product product) throws Exception{
        return productService.addProduct(product);
    }
    @PutMapping("/{id}")
    public@ResponseBody
    Product editProduct(@PathVariable int id,
                        @RequestBody String name,
                        @RequestBody String description,
                        @RequestBody ProductType type) throws Exception{
        return productService.editProduct(id, name, description, type);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable int id)throws Exception{
        productService.deleteProduct(id);
    }
}
