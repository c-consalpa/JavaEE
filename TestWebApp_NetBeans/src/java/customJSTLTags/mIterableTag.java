
package customJSTLTags;

import c_consalpa.business.mProduct;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class mIterableTag extends BodyTagSupport {
    private ArrayList<mProduct> dataList;
    private Iterator iterator;
    private mProduct prod;

    @Override
    public int doStartTag() throws JspException {
        dataList = (ArrayList<mProduct>) pageContext.findAttribute("dataList");
        
        
        if (dataList.size() == 0) {
            return SKIP_BODY;
        } else {
            return EVAL_BODY_BUFFERED;
        }
    }

    @Override
    public void doInitBody() throws JspException {
        iterator = dataList.iterator();
        if (iterator.hasNext()) {
            mProduct dataListItem = (mProduct) iterator.next();
            pageContext.setAttribute("productId", dataListItem.getId());
            pageContext.setAttribute("productValue", dataListItem.getValue());
        }
    }

    @Override
    public int doAfterBody() throws JspException {
    try {
            if (iterator.hasNext()) {
                prod = (mProduct) iterator.next();
                pageContext.setAttribute("productId", prod.getId());
                pageContext.setAttribute("productValue", prod.getValue());
                return EVAL_BODY_AGAIN;
            } else {
                JspWriter writer = bodyContent.getEnclosingWriter();
                bodyContent.writeOut(writer);
                return SKIP_BODY;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return SKIP_BODY;
        }
    }

}
