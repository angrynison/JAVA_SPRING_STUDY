package hello.core.domain;

import hello.core.exception.NotEnoughStocksException;
import hello.core.exception.WrongStocksInsertionException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int itemPrice;
    private int productCount;

    public Product(Long id,String productName, int itemPrice) {
        this.id = id;
        this.productName = productName;
        this.itemPrice = itemPrice;
    }
    public Product() {}

    public void addStocks(int quantity) {
        if (quantity < 0) {
            throw new WrongStocksInsertionException("wrong insert stocks");
        }
        this.productCount += quantity;
    }

    public void removeStocks(int count) {
        int remain = this.productCount - count;
        if (remain < 0) {
            throw new NotEnoughStocksException("Need more stocks");
        }
        this.productCount = remain;
    }


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
    public int getProductCount() {
        return productCount;
    }
    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
