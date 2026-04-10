package hello.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String itemName;
    private int itemPrice;
    private Long productCount;

    public Product(Long productId,String itemName, int itemPrice) {
        this.productId = productId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    public Product() {}

    public int getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getProductCount() {
        return productCount;
    }
    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }
}
