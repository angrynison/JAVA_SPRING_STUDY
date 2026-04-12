package hello.core.repository;

import hello.core.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaProductRepository extends JpaRepository<Product, Long> , ProductRepository {

    @Override
    Optional<Product> findByproductName(String name);
}
