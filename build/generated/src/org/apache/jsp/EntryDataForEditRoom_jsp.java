package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModelEntities.*;

public final class EntryDataForEditRoom_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <style>\r\n");
      out.write("        h1{\r\n");
      out.write("            margin-left: 15px;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        button{\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            margin-left: 15px;\r\n");
      out.write("            width: 200px;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <form>\r\n");
      out.write("            <div class=\"container mt-5\">\r\n");
      out.write("                <div class=\"col-md-6 offset-md-3\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"card card-body\">\r\n");
      out.write("                            <h3>Introdueix l'informació de l'habitació</h3>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"font-weight-bold\" for=\"inputDescription\">Descripció</label>\r\n");
      out.write("                                <textarea class=\"form-control\" id=\"inputDescription\" rows=\"3\"></textarea>\r\n");
      out.write("                            </div>    \r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"font-weight-bold\" for=\"inputAddress\">Adreça</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"inputAddress\" placeholder=\"1234 Main St\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-row\">\r\n");
      out.write("                                <div style=\"margin-left: 5.4px\" class=\"form-group\">\r\n");
      out.write("                                    <label class=\"font-weight-bold\" for=\"inputCity\">Ciutat</label>\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"inputCity\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div style=\"margin-left: 8px; margin-right: 8px; width: 30%\" class=\"form-group\">\r\n");
      out.write("                                    <label class=\"font-weight-bold\" for=\"inputType\">Tipus habitació</label>\r\n");
      out.write("                                    <select id=\"inputType\" class=\"form-control\">\r\n");
      out.write("                                    <option selected>Escull...</option>\r\n");
      out.write("                                    <option value=\"1\">Simple</option>\r\n");
      out.write("                                    <option value=\"2\">Doble</option>\r\n");
      out.write("                                    <option value=\"3\">Exterior</option>\r\n");
      out.write("                                    <option value=\"4\">Interior</option>\r\n");
      out.write("                                    <option value=\"5\">Moblada</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div style=\"width: 27%\" class=\"form-group\">\r\n");
      out.write("                                    <label class=\"font-weight-bold\" for=\"inputPreuMes\">Preu mensual</label>\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"inputPreuMes\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-row\">\r\n");
      out.write("                                <div style=\"margin-left: 5.4px; margin-right: 8px; width: 150px\" class=\"form-group\">\r\n");
      out.write("                                    <label class=\"font-weight-bold\" for=\"inputPreuMin\">Preu mínim</label>\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"inputPreuMin\" placeholder=\"\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div style=\"width: 150px\" class=\"form-group\">\r\n");
      out.write("                                    <label class=\"font-weight-bold\" for=\"inputPreuMax\">Preu màxim</label>\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"inputPreuMax\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div  style=\"margin-left: 8px\" class=\"form-group\">\r\n");
      out.write("                                    <label class=\"font-weight-bold\" for=\"inputSexe\">Sexe llogater</label>\r\n");
      out.write("                                    <select style=\"width: 200px\" id=\"inputSexe\" class=\"form-control\">\r\n");
      out.write("                                    <option selected>Escull...</option>\r\n");
      out.write("                                    <option value=\"1\">Home</option>\r\n");
      out.write("                                    <option value=\"2\">Dona</option>\r\n");
      out.write("                                    <option value=\"3\">Unisex</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div style=\"margin-left: 5.4px\" class=\"form-group\">\r\n");
      out.write("                                    <label class=\"font-weight-bold\" for=\"inputLlogater\">ID llogater</label>\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"inputLlogater\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div style=\"margin-left: 8px\" class=\"form-group\">\r\n");
      out.write("                                    <div class=\"card card-body\">    \r\n");
      out.write("                                        <label class=\"font-weight-bold\" for=\"inputRequeriment\">S'accepten?</label>\r\n");
      out.write("                                        <div class=\"form-check\">\r\n");
      out.write("                                            <input type=\"checkbox\" class=\"form-check-input\" id=\"fumador\">\r\n");
      out.write("                                            <label class=\"form-check-label\" for=\"fumador\">Fumador</label>\r\n");
      out.write("                                            <input style=\"margin-left: 10px\" type=\"checkbox\" class=\"form-check-input\" id=\"mascotes\">\r\n");
      out.write("                                            <label style=\"margin-left: 30px\" class=\"form-check-label\" for=\"mascotes\">Mascotes</label>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("    <form action=\"http://localhost:8080/Pract2_SistemesOberts/index.html\">\r\n");
      out.write("        <div style=\"margin-left: 670px\">\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-success\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"You will be return to the main page.\">Registrar Habitació</button>\r\n");
      out.write("                \r\n");
      out.write("            <button style=\"margin-left: 150px\" type=\"submit\" class=\"btn btn-secondary\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"You will be return to the main page.\">Return</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("</html>");
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
