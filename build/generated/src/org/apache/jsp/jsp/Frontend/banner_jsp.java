package org.apache.jsp.jsp.Frontend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class banner_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Shoes-Fashion</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <aside id=\"colorlib-hero\">\n");
      out.write("            <div class=\"flexslider\">\n");
      out.write("                <ul class=\"slides\">\n");
      out.write("                    <li style=\"background-image: url(/ShopFashion/jsp/Admin/images/banner1.jpg&quot;); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 1; display: block; z-index: 2;\" class=\"flex-active-slide\" data-thumb-alt=\"\">\n");
      out.write("                        <div class=\"overlay\"></div>\n");
      out.write("                        <div class=\"container-fluid\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-sm-6 offset-sm-3 text-center slider-text animated fadeInUp\">\n");
      out.write("                                    <div class=\"slider-text-inner\">\n");
      out.write("                                        <div class=\"desc\">\n");
      out.write("                                            <h1 class=\"head-1\">Men's</h1>\n");
      out.write("                                            <h2 class=\"head-2\">Shoes</h2>\n");
      out.write("                                            <h2 class=\"head-3\">Collection</h2>\n");
      out.write("                                            <p class=\"category\"><span>New trending shoes</span></p>\n");
      out.write("                                            <p><a href=\"#\" class=\"btn btn-primary\">Shop Collection</a></p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li style=\"background-image: url(/ShopFashion/jsp/Frontend/images/banner2.jpg&quot;); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1;\" data-thumb-alt=\"\" class=\"\">\n");
      out.write("                        <div class=\"overlay\"></div>\n");
      out.write("                        <div class=\"container-fluid\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-sm-6 offset-sm-3 text-center slider-text\">\n");
      out.write("                                    <div class=\"slider-text-inner\">\n");
      out.write("                                        <div class=\"desc\">\n");
      out.write("                                            <h1 class=\"head-1\">Huge</h1>\n");
      out.write("                                            <h2 class=\"head-2\">Sale</h2>\n");
      out.write("                                            <h2 class=\"head-3\"><strong class=\"font-weight-bold\">50%</strong> Off</h2>\n");
      out.write("                                            <p class=\"category\"><span>Big sale sandals</span></p>\n");
      out.write("                                            <p><a href=\"#\" class=\"btn btn-primary\">Shop Collection</a></p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li style=\"background-image: url(/ShopFashion/jsp/Frontend/images/banner3.jpg&quot;); width: 100%; float: left; margin-right: -100%; position: relative; opacity: 0; display: block; z-index: 1;\" data-thumb-alt=\"\" class=\"\">\n");
      out.write("                        <div class=\"overlay\"></div>\n");
      out.write("                        <div class=\"container-fluid\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-sm-6 offset-sm-3 text-center slider-text\">\n");
      out.write("                                    <div class=\"slider-text-inner\">\n");
      out.write("                                        <div class=\"desc\">\n");
      out.write("                                            <h1 class=\"head-1\">New</h1>\n");
      out.write("                                            <h2 class=\"head-2\">Arrival</h2>\n");
      out.write("                                            <h2 class=\"head-3\">up to <strong class=\"font-weight-bold\">30%</strong> off</h2>\n");
      out.write("                                            <p class=\"category\"><span>New stylish shoes for men</span></p>\n");
      out.write("                                            <p><a href=\"#\" class=\"btn btn-primary\">Shop Collection</a></p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <ol class=\"flex-control-nav flex-control-paging\"><li><a href=\"#\" class=\"flex-active\">1</a></li><li><a href=\"#\" class=\"\">2</a></li><li><a href=\"#\" class=\"\">3</a></li></ol><ul class=\"flex-direction-nav\"><li class=\"flex-nav-prev\"><a class=\"flex-prev\" href=\"#\">Previous</a></li><li class=\"flex-nav-next\"><a class=\"flex-next\" href=\"#\">Next</a></li></ul></div>\n");
      out.write("        </aside>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
