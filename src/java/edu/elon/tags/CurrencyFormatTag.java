/* Lane Peeler & Jasmine Jones */
package edu.elon.tags;

import java.io.IOException;
import java.text.NumberFormat;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import javax.servlet.jsp.tagext.TagSupport;

public class CurrencyFormatTag extends TagSupport {

    private double value;

    @Override
    public int doStartTag() throws JspException {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String s = nf.format(value);
        try {
            JspWriter out = pageContext.getOut();
            out.print(s);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return SKIP_BODY;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

}
