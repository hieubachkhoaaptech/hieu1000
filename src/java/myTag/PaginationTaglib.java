/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTag;

import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Administrator
 */
public class PaginationTaglib extends SimpleTagSupport{
    private String uri;
    private int offset;
    private int count;
    private int max = 8;
    private int steps = 8;
    private String previous = "Previous";
    private String next = "Next";
    
    
    private Writer getWrite() {
        JspWriter out = getJspContext().getOut();
        return out;
    }

    private String constructLink(int page, String text, String className, boolean disabled) {
        StringBuilder link = new StringBuilder("<li");
        if (className != null) {
            link.append(" class=\"");
            link.append(className);
            link.append("\"");
        }
        if (disabled) {
            link.append(">").append("<a href=\"#\">" + text + "</a></li>");
        } else {
            link.append(">").append("<a href=\"" + uri + "?offset=" + page + "\">" + text
                    + "</a></li>");
        }
        return link.toString();
    }

    @Override
    public void doTag() throws JspException {
        Writer out = getWrite();
        try {
            out.write("<nav>");
            out.write("<ul class=\"pagination\">");
            if (offset < steps) {
                out.write(constructLink(1, previous, "disable", true));
            } else {
                out.write(constructLink(offset - steps, previous, null, false));
            }
            for (int ipage = 0; ipage < count; ipage += steps) {
                if (offset == ipage) {
                    out.write(constructLink((ipage / 8 + 1) - 1 * steps, String.valueOf(ipage /8 + 1), "active", true));
                } else {
                    out.write(constructLink(ipage / 8 * steps, String.valueOf(ipage / 8 + 1), null, false));
                }
            }
            if (offset + steps >= count) {
                out.write(constructLink(offset + steps, next, "disable", true));
            } else {
                out.write(constructLink(offset + steps, next, null, false));
            }
            out.write("</ul>");
            out.write("</nav>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in PaginationTaglib tag", ex);
        }

    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
