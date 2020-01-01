<%-- 
    Document   : header
    Created on : 18-dic-2019, 10:57:14
    Author     : Sancho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <body>
        <p class="form-inline font-weight-bold">Encara no has iniciat sessio?</p>
        <div class="row form-row">
            
            <form method="post" action="login.do" class="form-inline">
                <button class="btn btn-link font-weight-bold" style="margin-left: 30px" type="submit">Login</button>
            </form>
            <form method="post" action="createUser.do" class="form-inline">
                <button class="btn btn-link font-weight-bold" type="submit">New User</button>
            </form>
        </div>
    </body>
</html>
