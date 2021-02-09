package consalpa.model;

import java.io.Serializable;

public class Product implements Serializable {
    private Long id;
    private String productName;

    public Product(Long key, String value) {
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
