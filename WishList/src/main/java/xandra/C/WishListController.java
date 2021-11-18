package xandra.C;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xandra.Data.ConnectionPool;
import xandra.M.Product;


import java.sql.SQLException;
import java.util.List;

import static xandra.Data.DBUtils.read;

@Controller
public class WishListController {

    @RequestMapping("/home")
    public String home() {

        getList();

        ConnectionPool cp = ConnectionPool.getInstance();
        try {
            System.out.println(cp.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return "home";
    }

    private List<Product> getList() {


        return null;
    }


}
