<%-- 
    Document   : error.jsp
    Created on : 28-dic-2019, 22:02:50
    Author     : Francesc Ferré and Aleix Sancho
--%>

<%@ page language="java" isErrorPage="true" import="java.io.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Error page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <h1>Error page</h1>
        <p><b>Error code:</b> ${pageContext.errorData.statusCode}</p>
        <p><b>Request URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
        <% if (response.getStatus() == 500) {%>
        <p><b>Cause:</b> <%=exception.getMessage()%></p>
        <p><b>Cause:</b><br /><%
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            exception.printStackTrace(printWriter);
            out.println(stringWriter);
            printWriter.close();
            stringWriter.close();
            %></p><%}%><br />
        <button onclick="history.back()">Go back</button>

    </body>
</html>