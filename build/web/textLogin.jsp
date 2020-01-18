<%-- 
    Document   : textLogin.jsp
    Created on : 18-dic-2019, 10:57:14
    Author     : Francesc Ferré and Aleix Sancho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html
    <head>
        <link rel="stylesheet" type="text/css" href="Styles/rooms.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <script type="text/javascript">
            function logoutFunc(){
                var button = document.getElementById("logoutForm");
                button.submit();
            }
        </script>   
    </head>
    <body>
        <div class="row form-row">
            <!-- Button trigger modal -->
            <form id="logoutForm" method="post" action="logout.do" class="form-inline">
                <button id="usuariLogin" type="button" class="btn btn-link font-weight-bold" data-toggle="modal" data-target="#exampleModal3"></button>
                <button id="logOut" class="btn btn-link font-weight-bold" type="button" onclick="logoutFunc()">Log out</button>
            </form>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal3" data-backdrop="false" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">User information</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="col col-sm">
                                <div class="row row-form">
                                    <div class="form-group col-sm offset-md-1">
                                        <label class="font-weight-bold col-md-2">Username</label>
                                        <label id="modalUsername" class="offset-md-1"></label>
                                    </div>
                                </div>
                                <div class="row row-form">
                                    <div class="form-group col-sm offset-md-1">
                                        <label class="font-weight-bold col-md-2">Email</label>
                                        <label id="modalEmail" class="offset-md-1"></label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>