package Models;

public class Product {
     private int id;
     private String value;

    public Product() {
        id=0;
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
}
