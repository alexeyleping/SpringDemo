package spring.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.demo.entity.Product;

import java.util.List;
import java.util.Optional;

import spring.demo.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public Product byId(Long id) {
        Optional<Product> byId = productRepository.findById(id);
        return byId.orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public void add(Product product) {
        productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

}
