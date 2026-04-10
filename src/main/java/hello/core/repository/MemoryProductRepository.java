package hello.core.repository;

import hello.core.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryProductRepository implements ProductRepository {

    ConcurrentHashMap<Long, Product> product_store = new ConcurrentHashMap<Long, Product>();

    Long sequence = 0L;

    @Override
    public void save(Product product) {
        sequence++;
        product.setProductId(sequence);
        product_store.put(product.getProductId(), product);
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return Optional.ofNullable(product_store.get(productId));
    }


    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>(product_store.values());
        return products;
    }

    @Override
    public Optional<Product> findByName(String name) {
        return product_store.values().stream()
                .filter(member -> member.getItemName().equals(name))
                .findAny();
    }

}
