/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_consalpa.business;

import DAO.Exceptions.EntityNotFoundException;
import DAO.ProductDAO_Mock;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author c-consalpa
 */
public class mCart {

    public Map<mProduct, Integer> getItemsInCart() {
        return itemsInCart;
    }
    
    MockStorage mockStorage = new MockStorage();
    ProductDAO_Mock mock_dao = new ProductDAO_Mock();
    
    private Map<mProduct, Integer> itemsInCart;
    
    public mCart() {
        this.itemsInCart = new HashMap();
    }

    public void addProduct(int productID) {
        try {
            mProduct product = mock_dao.selectById(productID);
            Integer c = itemsInCart.get(product);
            if (c == null) {
                itemsInCart.put(product, 1);
            } else {
                itemsInCart.put(product, ++c);                
            }
        } catch (EntityNotFoundException ex) {
            System.out.println("cannot add item to cart");
            ex.printStackTrace();
        }
       
    }
    
        public void removeProduct(Integer productID) {
        try {
            mProduct product = mock_dao.selectById(productID);
            if (itemsInCart.containsKey(product)) {
                itemsInCart.remove(product);
            }
        } catch (EntityNotFoundException ex) {
            Logger.getLogger(mCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        
        return "Cart " + 
                super.toString() + 
                " : " + 
                itemsInCart.toString();
    }


    
   
    
}
