package DAO;

import DAO.Exceptions.EntityNotFoundException;
import Models.Product;

import java.util.Map;

public interface ProductDAO {
     public Product selectById(int id) throws EntityNotFoundException;

     public Map<Integer, String> selectAll();
}
