package consalpa;

import consalpa.Data.MockStorage;
import consalpa.Data.Product;
import consalpa.Data.StorageDAOImpl;
import consalpa.Exceptions.NoSuchEntityException;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMockStorage {
    MockStorage mockStorage = new MockStorage();
    Map<Long, String> data = new HashMap<>(mockStorage.getStorage());

    @Test
    public void testStorageDAOImpl() throws NoSuchEntityException {
        StorageDAOImpl testDAO = new StorageDAOImpl();
        assertEquals(new Product(1, "oil"), testDAO.getProductByID(1L));

        assertEquals(testDAO.getAllProducts().size(), 3);

    }
}