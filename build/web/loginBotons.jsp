<%-- 
    Document   : loginBotons.jsp
    Created on : 18-dic-2019, 10:57:14
    Author     : Francesc Ferré and Aleix Sancho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Styles/rooms.css">
    </head>
    <body>
        <p id="indexP" class="font-weight-bold white">Encara no has iniciat sessio?</p>
        <div class="row form-row">
            <form method="post" action="login.do" class="form-inline">
                <button id="loginButton" class="btn btn-link font-weight-bold" type="submit">Login</button>
            </form>
            <form method="post" action="createUser.do" class="form-inline">
                <button class="btn btn-link font-weight-bold" type="submit">New User</button>
            </form>
        </div>
    </body>
</html>
