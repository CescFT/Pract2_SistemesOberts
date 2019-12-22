<%@ page import = "ModelEntities.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <style>
        button{
            margin-top: 20px;
            margin-left: 15px;
            width: 200px;
        }
    </style>

    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card card-body">
                        <form name="updateAccount" action="validate" method="post">
                            <h3>Introdueix les dades:</h3>
                            <div class="form-group">
                                <label class="font-weight-bold">Nom d'usuari</label>
                                <input type="text" name="id" id="userid" onkeyup="validateUserId()" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label class="font-weight-bold">Contrasenya</label>
                                <div class="input-group">
                                    <input type="password" name="passwd"  class="form-control" data-toggle="password"/>
                                    <div class="input-group-append">
                                        <div class="input-group-text"><i class="fa fa-eye"></i></div>
                                    </div>
                                </div>
                            </div>
                            <input type="submit" id="submit_btn" class="btn btn-success" value="Send Request">
                            <div id="userIdMessage"></div>
                        </form>
                    </div>
                </div>
                <jsp:include page="back.jsp" />
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="bootstrap-show-password.min.js"></script>
        <!-- JavaScript code starts from here -->
        
    </body>

</html>
