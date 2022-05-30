package spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.demo.entity.Product;
import spring.demo.service.ProductService;

@Controller
@RequestMapping("/products")
public class AppController {


    private ProductService productService;

    @Autowired
    public void setProductsService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProductsList(Model model) {
        Product product = new Product();

        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product", product);
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute(value = "product")Product product) {
        productService.add(product);
        return "redirect:/products";
    }

    @GetMapping("/show2/{id}")
    public String productPageShow(Model model, @PathVariable(value = "id") Long id) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product-page";
    }



}
