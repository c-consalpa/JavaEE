package consalpa.Model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private Long id;
    private String productName;

    public Product() {

    }

    public Product(Long id, String name) {
        this.id = id;
        this.productName = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Long getId() {
        return id;
    }
    public String getProductName() {
        return productName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }
}
