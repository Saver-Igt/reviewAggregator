package com.example.reviewAggregator.services;

import com.example.reviewAggregator.models.Product;
import com.example.reviewAggregator.models.ProductType;
import com.example.reviewAggregator.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceDB implements ProductService{

    private final ProductRepository productRepository;
    private ProductServiceDB(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getProducts() throws Exception {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int id) throws Exception {
        return productRepository.findById(id).orElse(new Product());
    }

    @Override
    public Product addProduct(Product product) throws Exception {
        return productRepository.save(product);
    }

    @Override
    public Product editProduct(int id, String name, String description, ProductType type) throws Exception {
        Product findProduct = getProduct(id);
        findProduct.setName(name);
        findProduct.setDescription(description);
        findProduct.setType(type);
        return productRepository.save(findProduct);
    }

    @Override
    public void deleteProduct(int id) throws Exception {
        productRepository.deleteById(id);
    }
}
