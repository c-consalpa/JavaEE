package consalpa.Data.DAO;

import consalpa.Model.Product;
import consalpa.Exceptions.NoSuchEntityException;


import java.util.Set;

public interface mDAO {
    public Product getProductByID(long id) throws NoSuchEntityException;

    public Set<Product> getAllProducts();
}
