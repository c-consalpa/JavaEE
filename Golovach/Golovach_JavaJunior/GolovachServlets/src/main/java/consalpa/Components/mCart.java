package consalpa.Components;

import consalpa.Model.Product;

import java.util.Map;

public class mCart {
    private Map<Product, Integer> cartItems;

    public mCart() {
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
}
