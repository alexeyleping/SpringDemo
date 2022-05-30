package spring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.entity.Product;
import spring.demo.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.byId(id);
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "hello, world!";
    }

    @GetMapping("/show")
    public List<Product> showProductsList() {
        return productService.getAllProducts();
    }
}

