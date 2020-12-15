package consalpa.Data;

import consalpa.Exceptions.NoSuchEntityException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageDAOImpl implements mDAO {
    Map<Long, String> storage;

    public StorageDAOImpl() {
        storage = new MockStorage().getStorage();
    }



    @Override
    public Product getProductByID(long id) throws NoSuchEntityException {
        if (!storage.containsKey(id)) {
            throw new NoSuchEntityException("No item in storage with id: " + id);
        } else {
            return new Product(id, storage.get(id));
        }


    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<Product>();
        for (long id: storage.keySet()) {
            products.add(new Product(id, storage.get(id)));
        }
        return products;
    }
}
