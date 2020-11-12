package Models;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    public Map<Product, Integer> itemsInCart = new HashMap<>();

    public Map<Product, Integer> getItemsInCart() {
        return itemsInCart;
    }

    public Cart add(Product product, HttpSession session) {
        int currentProductCount = 0;
        if (itemsInCart.containsKey(product)) {
            currentProductCount = itemsInCart.get(product);
            itemsInCart.put(product, ++currentProductCount);
        } else {
            itemsInCart.put(product, ++currentProductCount);
        }
        return this;
    }


    public Map<Product, Integer> getCurrentItems() {
        return this.itemsInCart;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "itemsInCart=" + itemsInCart +
                '}';
    }
}
