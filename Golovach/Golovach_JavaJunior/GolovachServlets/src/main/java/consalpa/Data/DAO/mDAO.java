package consalpa.Data.DAO;

import consalpa.Model.Product;
import consalpa.Exceptions.NoSuchEntityException;

import java.util.List;

public interface mDAO {
    public Product getProductByID(long id) throws NoSuchEntityException;

    public List<Product> getAllProducts();
}
