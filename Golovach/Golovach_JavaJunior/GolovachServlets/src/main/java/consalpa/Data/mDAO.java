package consalpa.Data;

import consalpa.Exceptions.NoSuchEntityException;

import java.util.List;

public interface mDAO {
    public Product getProductByID(long id) throws NoSuchEntityException;

    public List<Product> getAllProducts();
}
