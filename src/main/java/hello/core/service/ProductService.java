package hello.core.service;

import hello.core.domain.Product;
import hello.core.repository.ProductRepository;

import java.util.Optional;

public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 제품 등록 서비스
    public Long join(Product product) {
        Optional<Product> foundProduct = productRepository.findByName(product.getItemName());

        if (foundProduct.isPresent()) {
            Product existingProduct = foundProduct.get();
            existingProduct.setProductCount(existingProduct.getProductCount() + 1);
            productRepository.save(existingProduct);
            return existingProduct.getProductId();
        }
        else {
            product.setProductCount(1L);
            productRepository.save(product);
            return product.getProductId();
        }
    }

    // 제품 Id로 제품 탐색
    public Optional<Product> findProductById(Long productId) {
        return productRepository.findById(productId);
    }




}
