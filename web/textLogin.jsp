<%-- 
    Document   : header
    Created on : 18-dic-2019, 10:57:14
    Author     : Sancho
--%>
<%@ page import = "AuthenticationModule.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<!DOCTYPE html>
<html>
    <body>
        <p id="usuariLogin" class="form-inline font-weight-bold">ei</p>

        <div class="row form-row">

            <form method="post" action="logout.do" class="form-inline">
                <button class="btn btn-link font-weight-bold" style="margin-left: 30px" type="submit">Log out</button>
            </form>

        </div>
    </body>
</html>

