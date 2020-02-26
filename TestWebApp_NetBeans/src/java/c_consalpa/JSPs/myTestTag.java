package c_consalpa.JSPs;

import java.text.DateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class myTestTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        Date currentDate = new Date();
        DateFormat shortDate = DateFormat.getDateInstance(DateFormat.SHORT);
        String currentDateFormatted = shortDate.format(currentDate);
        
        try {
            JspWriter jspWriter = pageContext.getOut();
            jspWriter.println(currentDateFormatted);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return SKIP_BODY;
    }
    
}
