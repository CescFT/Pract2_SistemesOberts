<%@ page import = "AuthenticationModule.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>Main Page</title>
    </head>
    <style>
        body{
            background-image: url("Images/mijas2.jpg");
            background-color: #cccccc;
            height: 500px;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
        }
        p{
            margin-top: 17px;
        }
    </style>
    <body onload="setMessageUsingDOM()">
        <div class="container mt-3">
            <div class="col-md-6 offset-md-3">
                <div class="row">
                    <div class="form-inline" id="botons"><jsp:include page="loginBotons.jsp" /></div>
                    <div class="form-inline" id="text" hidden><jsp:include page="textLogin.jsp" /></div>
                    <form method="post" action="roomsResult.do" class="form-inline">
                        <div class="card card-body">
                            <div class="form-group">
                                <input style="width: 430px" name="location" class="form-control mr-sm-2" type="search" placeholder="Search by city" aria-label="Search">
                                <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
                            </div>
                            <div id="sugerimentIndex"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </body>
    <script type="text/javascript">
        function setMessageUsingDOM() {
            var botonsLogin = document.getElementById("botons");
            var textLogin = document.getElementById("text");
            var trobat = false;
            var messageText = "";
            var usuariLogin = document.getElementById("usuariLogin");
            for (var c of ${clientsWeb})
            {
                if (c.autenticat) {
                    trobat = true;
                    messageText = "Heu iniciat sessió com: "+c.username;
                }
            }
            if (trobat) {
                botonsLogin.hidden = true;
                textLogin.hidden = false;
            } else {
                botonsLogin.hidden = false;
                textLogin.hidden = true;
            }
            usuariLogin.textContent = messageText;
            
            
        }
    </script>
</html>
