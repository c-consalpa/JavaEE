import java.io.IOException;
import java.io.PrintWriter;
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
public class SQLExecuteServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Class dbUtilsClz = DBUtils.class;
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/sqlPage.jsp");
        String queryResultMessage = "";
        
        String sqlText = (String) request.getParameter("sqlText");
        if (sqlText == null || sqlText.isEmpty()) {
            return;
        }

        // get operation
        String operation = sqlText.split(" ")[0].toUpperCase();
        switch (operation) {
            case "SELECT": {
            try {
                queryResultMessage = DBUtils.getData(sqlText);
            } catch (SQLException ex) {
                Logger.getLogger(SQLExecuteServlet.class.getName()).log(Level.SEVERE, null, ex);
                queryResultMessage = "SQL query failed: <br> " + ex.getMessage();   
            }
                request.setAttribute("resultData", queryResultMessage);
                requestDispatcher.forward(request, response);
                break;
            }
            case "UPDATE": {
                int affectedRowsCnt = 0;
                try {
                    affectedRowsCnt = DBUtils.updateData(sqlText);
                    queryResultMessage = "Query Executed. Affected rows: \r\n: " + affectedRowsCnt;
            } catch (SQLException ex) {
                Logger.getLogger(SQLExecuteServlet.class.getName()).log(Level.SEVERE, null, ex);
                queryResultMessage = "SQL query failed: \r\n" + ex.getMessage();
            }
                request.setAttribute("resultData", queryResultMessage);
                requestDispatcher.forward(request, response);
                break;
            }
            case "INSERT": {
                int affectedRowsCnt = 0;
            try {
                affectedRowsCnt = DBUtils.insertData(sqlText);
                queryResultMessage = "Inserted Rows: \r\n: " + affectedRowsCnt;
            } catch (SQLException ex) {
                Logger.getLogger(SQLExecuteServlet.class.getName()).log(Level.SEVERE, null, ex);
                queryResultMessage = "Insert operation failed: \r\n" + ex.getMessage();
            }
               
                request.setAttribute("resultData", queryResultMessage);
                requestDispatcher.forward(request, response);
                break;
            }
            case "DELETE": {
                int removedRowsCnt = DBUtils.removeData(sqlText);
                queryResultMessage = "Query Executed. Removed rows: \r\n: " + removedRowsCnt;
                request.setAttribute("resultData", queryResultMessage);
                requestDispatcher.forward(request, response);
                break;
            }
            default: {
                System.out.println("bad operation");
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
