<%-- 
    Document   : header.jsp
    Created on : 18-dic-2019, 10:57:14
    Author     : Francesc Ferré and Aleix Sancho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="Styles/rooms.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
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
    <body onload="setMessageUsingDOM()">
        <div id="headerRed" class="form-group sticky-top col-sm"s>
            <div class="form-row">
                <form method="post" action="welcome.do">
                    <button id="returnMain" type="submit" class="btn btn-link font-weight-bold" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">Cesc Factory</button>
                </form>
                <div id="searchInput">
                    <form method="post" action="roomsResult.do" class="form-inline">
                        <input id="searchText" name="location" class="form-control mr-sm-2" type="search" placeholder="Search by city" aria-label="Search">
                        <button id="searchCity2" class="btn btn-success" type="submit">Search</button>
                    </form>
                    <div id="suggerenciesCiutats"></div>
                </div>
                <div id="buttonsUser">
                    <div class="form-inline" id="botons"><jsp:include page="loginBotons.jsp" /></div>
                    <div class="form-inline" id="text" hidden><jsp:include page="textLogin.jsp" /></div>
                </div>                
            </div>
        </div>
    </body>
</html>
