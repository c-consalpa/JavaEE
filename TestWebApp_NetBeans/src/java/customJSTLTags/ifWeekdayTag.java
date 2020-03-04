  
package customJSTLTags;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ifWeekdayTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        if (isWorkingDay()) {
            return EVAL_BODY_INCLUDE;    
        } else {
            return SKIP_BODY;
        }
    }

    private boolean isWorkingDay() {
      LocalDate localDate = LocalDate.now();
//      localDate = LocalDate.of(2020, 02, 29);
      int dayOfWeek = localDate.getDayOfWeek().getValue();
     
     
       
        return (dayOfWeek > 0 && dayOfWeek < 6);
    }
    
    
}
