<%-- 
    Document   : index.jsp
    Created on : 18-dic-2019, 10:58:14
    Author     : Francesc Ferré and Aleix Sancho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>CESC FACTORY - Main Page</title>
        <script type="text/javascript">
            function setMessageUsingDOM() {
                var botonsLogin = document.getElementById("botons");
                var textLogin = document.getElementById("text");
                var trobat = false;
                var messageText = "";
                var userLogin = document.getElementById("usuariLogin");
                var mUsername = document.getElementById("modalUsername");
                var mEmail = document.getElementById("modalEmail");
                for (var c of ${clientsWeb})
                {
                    if (c.autenticat) {
                        trobat = true;
                        messageText = "Welcome " + c.username;
                        mUsername.textContent = c.username;
                        mEmail.textContent = c.email;
                    }
                }
                if (trobat) {
                    botonsLogin.hidden = true;
                    textLogin.hidden = false;
                } else {
                    botonsLogin.hidden = false;
                    textLogin.hidden = true;
                }
                userLogin.textContent = messageText;
            }
        </script>
    </head>
    <body class="bodyLogin" onload="setMessageUsingDOM()">
        <div class="container mt-3">
            <div class="col-md-6 offset-md-3">
                <div class="row">
                    <div class="form-inline" id="botons"><jsp:include page="loginBotons.jsp" /></div>
                    <div class="form-inline" id="text" hidden><jsp:include page="textLogin.jsp" /></div>
                    <form method="post" action="roomsResult.do" class="form-inline">
                        <div class="card card-body">
                            <div class="form-group">
                                <input id="searchCity" name="location" class="form-control mr-sm-2" type="search" placeholder="Search by city" aria-label="Search">
                                <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
                            </div>
                            <div id="sugerimentIndex"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
