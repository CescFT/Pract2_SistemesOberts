package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModelEntities.*;

public final class EntryDataForAutenticateClientWeb_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <style>\r\n");
      out.write("        button{\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            margin-left: 15px;\r\n");
      out.write("            width: 200px;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container mt-5\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-6 offset-md-3\">\r\n");
      out.write("                    <div class=\"card card-body\">\r\n");
      out.write("                        <form>\r\n");
      out.write("                            <h3>Introdueix les dades:</h3>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"font-weight-bold\">Nom d'usuari</label>\r\n");
      out.write("                                <input type=\"text\" name=\"username\" class=\"form-control\"/>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"font-weight-bold\">Correu electrònic</label>\r\n");
      out.write("                                <input type=\"text\" name=\"email\" class=\"form-control\"/>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"font-weight-bold\">Contrasenya</label>\r\n");
      out.write("                                <div class=\"input-group\">\r\n");
      out.write("                                    <input type=\"password\" name=\"passwd\" class=\"form-control\" data-toggle=\"password\"/>\r\n");
      out.write("                                    <div class=\"input-group-append\">\r\n");
      out.write("                                        <div class=\"input-group-text\"><i class=\"fa fa-eye\"></i></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("    <form action=\"http://localhost:8080/Pract2_SistemesOberts/index.html\">\r\n");
      out.write("        <div style=\"margin-left: 675px\">\r\n");
      out.write("         <button type=\"submit\" class=\"btn btn-secondary\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"You will be return to the main page.\">Return</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("</html>\r\n");
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
