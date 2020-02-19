
package DAO;

import DAO.Exceptions.EntityNotFoundException;
import c_consalpa.business.mProduct;
import java.util.Map;

/**
 *
 * @author c-consalpa
 */
public interface ProductDAO {
     
    public mProduct selectById(int id) throws EntityNotFoundException;

    public Map<Integer, String> selectAll();
}