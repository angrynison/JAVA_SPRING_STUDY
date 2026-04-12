package hello.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
d    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int itemPrice;
    private Long productCount;

    public Product(Long id,String productName, int itemPrice) {
        this.id = id;
        this.productName = productName;
        this.itemPrice = itemPrice;
    }
    public Product() {}



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
    public Long getProductId() {
        return id;
    }
    public void setProductId(Long id) {
        this.id = id;
    }
    public Long getProductCount() {
        return productCount;
    }
    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }
}
