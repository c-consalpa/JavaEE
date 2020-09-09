import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/SQLExecuteServlet"})
public class SQLServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");

        Class dbUtilsClz = DBUtils.class;
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/sqlPage.jsp");
        String queryResultMessage = "";
        String sqlText = (String) request.getParameter("sqlText");
        System.out.println(sqlText);
        if (sqlText == null || sqlText.isEmpty()) {
            sqlText = "SELECT * FROM test_table;";
        }

        // get operation
        String operation = sqlText.split(" ")[0].toUpperCase();
                
        
        
        switch (operation) {
            case "SELECT": {
                request.setAttribute("query", sqlText);
            try {
                queryResultMessage = DBUtils.getData(sqlText);
            } catch (SQLException ex) {
                Logger.getLogger(SQLServlet.class.getName()).log(Level.SEVERE, null, ex);
                queryResultMessage = "SQL query failed: <br> " + ex.getMessage();   
            }
                request.setAttribute("resultData", queryResultMessage);
                requestDispatcher.forward(request, response);
                break;
            }
            case "UPDATE": {
                request.setAttribute("query", sqlText);
                int affectedRowsCnt = 0;
                try {
                    affectedRowsCnt = DBUtils.modifyData(sqlText);
                    queryResultMessage = "Update Executed. Updated rows: \r\n: " + affectedRowsCnt;
            } catch (SQLException ex) {
                Logger.getLogger(SQLServlet.class.getName()).log(Level.SEVERE, null, ex);
                queryResultMessage = "SQL query failed: \r\n" + ex.getMessage();
            }
                request.setAttribute("resultData", queryResultMessage);
                requestDispatcher.forward(request, response);
                break;
            }
            case "INSERT": {
                request.setAttribute("query", sqlText);
                int affectedRowsCnt = 0;
            try {
                affectedRowsCnt = DBUtils.modifyData(sqlText);
                queryResultMessage = "Inserted Rows: \r\n: " + affectedRowsCnt;
            } catch (SQLException ex) {
                Logger.getLogger(SQLServlet.class.getName()).log(Level.SEVERE, null, ex);
                queryResultMessage = "Insert operation failed: \r\n" + ex.getMessage();
            }
               
                request.setAttribute("resultData", queryResultMessage);
                requestDispatcher.forward(request, response);
                break;
            }
            case "DELETE": {
                request.setAttribute("query", sqlText);
                int removedRowsCnt = 0;
            try {
                removedRowsCnt = DBUtils.modifyData(sqlText);
            } catch (SQLException ex) {
                Logger.getLogger(SQLServlet.class.getName()).log(Level.SEVERE, null, ex);
                queryResultMessage = "DELETE operation failed: <br/>: " + ex.getMessage();
            }
                queryResultMessage = "Query Executed. Removed rows: \r\n: " + removedRowsCnt;
                request.setAttribute("resultData", queryResultMessage);
                requestDispatcher.forward(request, response);
                break;
            }
            default: {
                System.out.println("Bad operation type");
            }   
        }        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
