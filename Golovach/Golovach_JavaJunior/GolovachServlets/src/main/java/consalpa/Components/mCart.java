package consalpa.Components;

import consalpa.Model.Product;

import java.util.HashMap;
import java.util.Map;

public class mCart {
    private Map<Product, Integer> cartItems;

    public mCart() {
        cartItems = new HashMap<>();
    }

    public mCart(Map<Product, Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public void setCartItems(Map<Product, Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public Map<Product, Integer> getCartItems() {
        return cartItems;
    }

    public boolean add2Cart(Product product) {
        if (cartItems.containsKey(product)) {
            cartItems.put(product, cartItems.get(product) + 1);
        } else {
            cartItems.put(product, 1);
        }
        System.out.println("added item to cart: " + this);
        return false;
    }

    @Override
    public String toString() {
        return "mCart{" +
                "cartItems=" + cartItems +
                '}';
    }

    public mCart removeItemFromCart(Product product) {
        if (!cartItems.containsKey(product)) {
            return this;
        }
         int currentProductsCount = cartItems.get(product);

        if (currentProductsCount > 1) {
            cartItems.put(product, cartItems.get(product) - 1);
            System.out.println("cart product--: " + product + "; Left: " + cartItems.get(product));
        } else if (currentProductsCount == 1) {
            cartItems.remove(product);
            System.out.println("removed product from cart");

        }

        return this;
    }
}
