import java.io.IOException;
import java.io.PrintWriter;
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
        String resultMessage = "";
        
        String sqlText = (String) request.getParameter("sqlText");
        if (sqlText == null || sqlText.isEmpty()) {
            return;
        }

        // get operation
        String operation = sqlText.split(" ")[0].toUpperCase();
        switch (operation) {
            case "SELECT": {
                String tableData = DBUtils.getData();
                resultMessage = "Query Executed: \r\n";
                request.setAttribute("resultData", tableData);
                requestDispatcher.forward(request, response);
                break;
            }
            case "UPDATE": {
                int affectedRowsCnt = DBUtils.updateData(sqlText);
                resultMessage = "Query Executed. Affected rows: \r\n: " + affectedRowsCnt;
                request.setAttribute("resultData", resultMessage);
                requestDispatcher.forward(request, response);
                break;
            }
            case "INSERT": {
                int affectedRowsCnt = DBUtils.insertData(sqlText);
                resultMessage = "Query Executed. Affected rows: \r\n: " + affectedRowsCnt;
                request.setAttribute("resultData", resultMessage);
                requestDispatcher.forward(request, response);
                break;
            }
            case "DELETE": {
                int removedRowsCnt = DBUtils.removeData(sqlText);
                resultMessage = "Query Executed. Removed rows: \r\n: " + removedRowsCnt;
                request.setAttribute("resultData", resultMessage);
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
