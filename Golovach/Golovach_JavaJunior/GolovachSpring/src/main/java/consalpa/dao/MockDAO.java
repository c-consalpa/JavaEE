package consalpa.dao;

import consalpa.dao.NoSuchEntityException;
import consalpa.dao.mDao;
import consalpa.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockDAO implements mDao {
    private Map<Long, String> mockProductsStorage = new HashMap<>();

    public MockDAO() {
        mockProductsStorage.put(123L, "bread");
        mockProductsStorage.put(456L, "oil");
        mockProductsStorage.put(111L, "sugar");
    }


    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for (Map.Entry entry: mockProductsStorage.entrySet()) {
            products.add(
                    new Product((Long) entry.getKey(), (String) entry.getValue())
            );
        }
        return products;
    }

    @Override
    public Product getProductByID(long id) throws NoSuchEntityException {
        if (mockProductsStorage.containsKey(id)) {
            return new Product(id, mockProductsStorage.get(id));
        } else {
            throw new NoSuchEntityException("No product with ID: " + id);
        }

    }
}
