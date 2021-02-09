package consalpa.dao;

import consalpa.model.Product;

import java.util.List;

public interface mDao {

    public List<Product> getAllProducts();

    public Product getProductByID(long id) throws NoSuchEntityException;
}
