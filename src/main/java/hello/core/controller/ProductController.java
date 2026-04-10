package hello.core.controller;

import hello.core.domain.Product;
import hello.core.dto.ProductForm;
import hello.core.repository.ProductRepository;
import hello.core.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private ProductRepository productRepository;
    private ProductService productService;

    public ProductController(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping("/products/createProduct")
    public String createProduct(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "/products/createProductForm";
    }

    @PostMapping("/products/new")
    public String newProduct(ProductForm productForm) {
        Product product = new Product();
        product.setItemPrice(productForm.getProductPrice());
        product.setItemName(productForm.getProductName());
        productService.join(product);
        return "redirect:/products/createProduct";
    }


    @GetMapping("/productList")
    public String productList(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        return "/products/productList";
    }



}
