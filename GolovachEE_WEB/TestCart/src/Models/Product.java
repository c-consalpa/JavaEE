package Models;

import java.util.Objects;

public class Product {
     private int id;
     private String value;

    public Product() {
        id=-1;
        value="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
       if (this.value.equals(((Product) o).value)) {
           return true;
       } else {
           return false;
       }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
