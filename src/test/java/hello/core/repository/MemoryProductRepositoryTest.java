package hello.core.repository;

import hello.core.domain.Product;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryProductRepositoryTest {

    MemoryProductRepository memoryProductRepository = new MemoryProductRepository();

    @Test
    void 제품저장테스트() {
        //Given
        Product product = new Product(0L,"휴지", 500);

        //When
        memoryProductRepository.save(product);

        //Then
        Optional<Product> tmp = memoryProductRepository.findById(product.getProductId());
        assertThat(product.getProductId()).isEqualTo(tmp.get().getProductId());
    }


}
