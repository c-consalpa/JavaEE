
package customJSTLTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author c-consalpa
 */
public class AttributeTag extends TagSupport {
    private String count;
    
    public AttributeTag() {
        this.count = "";
    }
    
    public void setCount(String count) {
        this.count = count;
    }

    public String getCount() {
        return count;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter writer = pageContext.getOut();
            if (count.equals("2")) writer.print("ASDASDASDASD");
            if (count == null || count.length() == 0) {
                writer.print("TESTATTR");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return SKIP_BODY;
    }
    
     
}