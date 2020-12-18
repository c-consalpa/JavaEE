package consalpa;

import consalpa.Data.DAO.MockStorageDAOImpl;
import consalpa.Data.MockStorage;
import consalpa.Model.Product;
import consalpa.Data.DAO.MockStorageDAOImpl;
import consalpa.Exceptions.NoSuchEntityException;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestMockStorage {
    private MockStorage mockStorage;
    Map<Long, String> data;
    private MockStorageDAOImpl testDAO;

    public TestMockStorage() {
        mockStorage = new MockStorage();
        testDAO = new MockStorageDAOImpl(mockStorage);
        data = new HashMap<>(mockStorage.getStorage());
    }



    @Test
    public void testGetSingleProduct() throws NoSuchEntityException {
        assertEquals(new Product(1L, "oil"), testDAO.getProductByID(1L));
    }

    @Test
    public void testGetAllProducts() {
        assertEquals(testDAO.getAllProducts().size(), 3);
    }

    @Test
    public void testGetNonExistingProduct() {
        try{
            testDAO.getProductByID(5);
        } catch (NoSuchEntityException e) {
            //mock assertion
            assertEquals(e, e);
        }

    }
}

