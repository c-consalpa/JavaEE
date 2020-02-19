
package c_consalpa.business;

public class mProduct {
     private int id;
     private String value;

    public mProduct() {
        id=0;
        value="";
    }

    @Override
    public boolean equals(Object obj) {
       if (this.value.equals(((mProduct) obj).value)) {
           return true;
       } else {
           return false;
       }
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
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "mProduct{" + "id=" + id + ", value=" + value + '}';
    }
    
   
}