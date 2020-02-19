package Models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> itemsInCart = new HashMap<>();


    public Cart(Product product) {
        itemsInCart = new HashMap<>();
        itemsInCart.put(product, 1);
    }

    public boolean add(Product product) {
        if (itemsInCart.containsKey(product)) {
            itemsInCart.put(product, itemsInCart.get(product)  + 1);
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "itemsInCart=" + itemsInCart +
                '}';
    }
}
