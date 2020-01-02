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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <style>\r\n");
      out.write("        button.btn-light{\r\n");
      out.write("            width: 150px;\r\n");
      out.write("        }\r\n");
      out.write("        body{\r\n");
      out.write("            background-image: url(\"Images/mijas2.jpg\");\r\n");
      out.write("            background-color: #cccccc;\r\n");
      out.write("            height: 500px;\r\n");
      out.write("            background-position: center;\r\n");
      out.write("            background-repeat: no-repeat;\r\n");
      out.write("            background-size: cover;\r\n");
      out.write("            position: relative;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <head>\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container mt-5\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-6 offset-md-3\">\r\n");
      out.write("                    <div class=\"card card-body\">\r\n");
      out.write("\r\n");
      out.write("                        <h3>Introdueix les dades:</h3>\r\n");
      out.write("                        <div id=\"userIdMessage\"></div>\r\n");
      out.write("                        <form name=\"updateAccount\" action=\"validate\" method=\"post\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"font-weight-bold\">Nom d'usuari</label>\r\n");
      out.write("                                <input type=\"text\" name=\"id\" id=\"userid\" onkeyup=\"validateUserId()\" class=\"form-control\"/>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"font-weight-bold\">Contrasenya</label>\r\n");
      out.write("                                <div class=\"input-group\">\r\n");
      out.write("                                    <input type=\"password\" name=\"passwd\" id=\"passwdId\" onkeyup=\"validateUserId()\" class=\"form-control\" data-toggle=\"password\"/>\r\n");
      out.write("                                    <div class=\"input-group-append\">\r\n");
      out.write("                                        <div class=\"input-group-text\"><i class=\"fa fa-eye\"></i></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                        <form id=\"form1\" action=\"authentication.do\" method=\"post\">\r\n");
      out.write("                            <input type=\"hidden\" id=\"nomUsuariReal\" name=\"username\" value=\"\">\r\n");
      out.write("                            <input type=\"hidden\" id=\"contrassenyaUsuariReal\" name=\"password\" value=\"\">\r\n");
      out.write("                            <input type=\"hidden\" id=\"paginaAnterior\" name=\"anterior\" value=\"\">\r\n");
      out.write("                            <input type=\"button\" id=\"submit_btn\" disabled class=\"btn btn-success form-group\" value=\"Send Request\" onclick=\"functionModifyValues()\">\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "back.jsp", out, false);
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("        <script src=\"bootstrap-show-password.min.js\"></script>\r\n");
      out.write("        <!-- JavaScript code starts from here -->\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("                                var req;\r\n");
      out.write("                                var target;\r\n");
      out.write("                                var isIE;\r\n");
      out.write("                                var message;\r\n");
      out.write("                                var target2;\r\n");
      out.write("                                // (3) Creació de l'objecte XMLHttpRequest.\r\n");
      out.write("                                function initRequest(url) {\r\n");
      out.write("                                    if (window.XMLHttpRequest) {\r\n");
      out.write("                                        req = new XMLHttpRequest();\r\n");
      out.write("                                    } else if (window.ActiveXObject) {\r\n");
      out.write("                                        isIE = true;\r\n");
      out.write("                                        req = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("                                // (2) Manegador d'events que s'executa cada vegada que l'usuari escriu un caràcter\r\n");
      out.write("                                // en el camp del formulari identificat com a \"userid\".  El manegador\r\n");
      out.write("                                // invoca a \"initRequest(url)\" per instanciar l'objecte XMLHttpRequest\r\n");
      out.write("                                function validateUserId() {\r\n");
      out.write("                                    if (!target)\r\n");
      out.write("                                        target = document.getElementById(\"userid\");\r\n");
      out.write("                                    if (!target2)\r\n");
      out.write("                                        target2 = document.getElementById(\"passwdId\");\r\n");
      out.write("                                    var url = \"validate?id=\" + escape(target.value);\r\n");
      out.write("                                    url += \"&passwd=\" + escape(target2.value);\r\n");
      out.write("                                    // Invoca a initRequest(url) per crear l'objecte XMLHttpRequest\r\n");
      out.write("                                    initRequest(url);\r\n");
      out.write("                                    // La funció \"processRequest\" actua com a funció de callback\r\n");
      out.write("                                    req.onreadystatechange = processRequest;\r\n");
      out.write("                                    req.open(\"GET\", url, true);\r\n");
      out.write("                                    req.send(null);\r\n");
      out.write("                                }\r\n");
      out.write("                                // (4) Funció callback que s'invoca de forma asíncrona pel navegador\r\n");
      out.write("                                // Quan les dades han estat correctament retornades pel servidor.\r\n");
      out.write("                                // (En realitat aquesta funció es crida cada vegada que el valor\r\n");
      out.write("                                // del camp \"readyState\" de l'objecte XMLHttpRequest canvia.)\r\n");
      out.write("                                // Aquesta funció callback s'ha d'especificar al camp \"onreadystatechange\"\r\n");
      out.write("                                // de l'objecte XMLHttpRequest.\r\n");
      out.write("                                function processRequest() {\r\n");
      out.write("                                    if (req.readyState == 4) {\r\n");
      out.write("                                        if (req.status == 200) {\r\n");
      out.write("                                            message = req.responseXML.getElementsByTagName(\"valid\")[0].childNodes[0].nodeValue;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                            // Si l'usuari introdueix un valor invàlid, no permet a l'usuari\r\n");
      out.write("                                            // clicar el botó del formulari.\r\n");
      out.write("                                            var userId = document.getElementById(\"userid\").value;\r\n");
      out.write("                                            var passId = document.getElementById(\"passwdId\").value;\r\n");
      out.write("                                            var submitBtn = document.getElementById(\"submit_btn\");\r\n");
      out.write("                                            if (userId === \"\" || passId === \"\") {\r\n");
      out.write("                                                submitBtn.disabled = true;\r\n");
      out.write("                                            } else {\r\n");
      out.write("                                                submitBtn.disabled = false;\r\n");
      out.write("                                            }\r\n");
      out.write("                                        }\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                function functionModifyValues() {\r\n");
      out.write("                                    setMessageUsingDOM(message);\r\n");
      out.write("                                    if (message == \"true\") {\r\n");
      out.write("                                        var nomUsuari = document.getElementById(\"userid\").value;\r\n");
      out.write("\r\n");
      out.write("                                        var contrassenyaUsuari = document.getElementById(\"passwdId\").value;\r\n");
      out.write("                                        $(\"#nomUsuariReal\").val(nomUsuari);\r\n");
      out.write("                                        $(\"#contrassenyaUsuariReal\").val(contrassenyaUsuari);\r\n");
      out.write("                                        $(\"#paginaAnterior\").val(document.referrer);\r\n");
      out.write("                                        document.getElementById(\"form1\").submit();\r\n");
      out.write("                                        //window.location = 'http://localhost:8080/Pract2_SistemesOberts/authentication.do?username='+nomUsuari+'&password='+contrassenyaUsuari;\r\n");
      out.write("                                    }\r\n");
      out.write("\r\n");
      out.write("                                }\r\n");
      out.write("\r\n");
      out.write("                                function setMessageUsingDOM(message) {\r\n");
      out.write("                                    var userMessageElement = document.getElementById(\"userIdMessage\");\r\n");
      out.write("                                    var messageText = \"\";\r\n");
      out.write("                                    if (message == \"false\") {\r\n");
      out.write("                                        userMessageElement.style.color = \"red\";\r\n");
      out.write("                                        messageText = \"Usuari o contrasenya incorrectes.\";\r\n");
      out.write("                                    }\r\n");
      out.write("                                    var messageBody = document.createTextNode(messageText);\r\n");
      out.write("                                    // if the messageBody element has been created simple replace it otherwise\r\n");
      out.write("                                    // append the new element\r\n");
      out.write("                                    if (userMessageElement.childNodes[0]) {\r\n");
      out.write("                                        userMessageElement.replaceChild(messageBody, userMessageElement.childNodes[0]);\r\n");
      out.write("                                    } else {\r\n");
      out.write("                                        userMessageElement.appendChild(messageBody);\r\n");
      out.write("                                    }\r\n");
      out.write("                                }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
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
