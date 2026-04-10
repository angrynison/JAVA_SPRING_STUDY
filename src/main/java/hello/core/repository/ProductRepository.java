package hello.core.repository;

import hello.core.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);
    Optional<Product> findById(Long productId);
    List<Product> findAll();
    Optional<Product> findByName(String name);
}
