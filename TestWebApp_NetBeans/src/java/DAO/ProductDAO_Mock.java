/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Exceptions.EntityNotFoundException;
import c_consalpa.business.MockStorage;
import c_consalpa.business.mProduct;
import java.util.Map;

/**
 *
 * @author c-consalpa
 */
public class ProductDAO_Mock implements ProductDAO {
    @Override
    public mProduct selectById(int id) throws EntityNotFoundException {
        mProduct product = new mProduct();
        product.setId(id);
        if (MockStorage.mockStorage.containsKey(id)) {
            product.setValue(MockStorage.mockStorage.get(id));
        } else {
            throw new EntityNotFoundException("No products exist with ID: " + id);
        }
        return product;
    }

    @Override
    public Map<Integer, String> selectAll() {
        return MockStorage.mockStorage;
    }
}
