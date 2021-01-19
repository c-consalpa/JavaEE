package consalpa.Data.DAO;

import consalpa.Data.MockStorage;
import consalpa.Model.Product;
import consalpa.Exceptions.NoSuchEntityException;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_SG;


import java.util.*;

public class MockStorageDAOImpl implements mDAO {
    Map<Long, String> storage;

    public MockStorageDAOImpl(MockStorage mockStorage) {
        storage = mockStorage.getStorage();
    }

    @Override
    public Product getProductByID(long id) throws NoSuchEntityException {
        if (!storage.containsKey(id)) {
            throw new NoSuchEntityException("No item in storage with id: " + id);
        } else {
            Product tmpPrd  = new Product();
            tmpPrd.setId(id);
            tmpPrd.setProductName(storage.get(id));
            return tmpPrd;
        }
    }

    @Override
    public HashSet<Product> getAllProducts() {
        HashSet<Product> products = new HashSet<>();

        for (long id: storage.keySet()) {
            Product tmpPrd = new Product();
            tmpPrd.setId(id);
            tmpPrd.setProductName(storage.get(id));
            products.add(tmpPrd);
        }
        return products;
    }
}
