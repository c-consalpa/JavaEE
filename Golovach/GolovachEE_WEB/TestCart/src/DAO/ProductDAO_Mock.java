package DAO;

import DAO.Exceptions.EntityNotFoundException;
import Models.MockStorage;
import Models.Product;

import java.util.Map;

public class ProductDAO_Mock implements ProductDAO {

    public ProductDAO_Mock() {
        new MockStorage();
    }

    @Override
    public Product selectById(int id) throws EntityNotFoundException {
        Product product = new Product();
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
