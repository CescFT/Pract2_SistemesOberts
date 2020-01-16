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
                                <input id="inputCiutatIndex" onkeyup="validateUserId()" style="width: 430px" name="location" class="form-control mr-sm-2" type="search" placeholder="Search by city" aria-label="Search">
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
        
        var req;
        var target;
        var isIE;
        var message;

// (3) Creació de l'objecte XMLHttpRequest.
        function initRequest(url) {
            if (window.XMLHttpRequest) {
                req = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                isIE = true;
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }

// (2) Manegador d'events que s'executa cada vegada que l'usuari escriu un caràcter
// en el camp del formulari identificat com a "userid".  El manegador
// invoca a "initRequest(url)" per instanciar l'objecte XMLHttpRequest
        function validateUserId() {
            if (!target)
                target = document.getElementById("inputCiutatIndex");
            var url = "validateCiutat?ciutat=" + escape(target.value);

            // Invoca a initRequest(url) per crear l'objecte XMLHttpRequest
            initRequest(url);

            // La funció "processRequest" actua com a funció de callback
            req.onreadystatechange = processRequest;
            req.open("GET", url, true);
            req.send(null);
        }

// (4) Funció callback que s'invoca de forma asíncrona pel navegador
// Quan les dades han estat correctament retornades pel servidor.
// (En realitat aquesta funció es crida cada vegada que el valor
// del camp "readyState" de l'objecte XMLHttpRequest canvia.)
// Aquesta funció callback s'ha d'especificar al camp "onreadystatechange"
// de l'objecte XMLHttpRequest.
        function processRequest() {
            if (req.readyState == 4) {
                if (req.status == 200) {

                    // Extreu "true" or "false" de les dades retornades pel servidor.
                    message = req.responseXML.getElementsByTagName("valid")[0].childNodes[0].nodeValue;
                    // Crida la funció "setMessageUsingDOM(message)" per mostrar o bé
                    // "Valid User Id" o bé "Invalid User Id".
                    
                        setMessageUsingDOMCerca(message);
                    
                }
            }
        }


// (5) Funció que mostra si l'usuari és vàlid o invàlid
// per mitjà de l'element "userIdMessage".
        function setMessageUsingDOMCerca(message) {
            var userMessageElement = document.getElementById("sugerimentIndex");
            var messageText;
            if (message != "false") {
                userMessageElement.style.color = "green";
                messageText = "Potser voldras dir: "+message;
            }else if(message === " "){
                messageText= "";
            }else{
                userMessageElement.style.color="red";
                messageText = "No hi ha suggerencies.";
            }
            
            var messageBody = document.createTextNode(messageText);
            // if the messageBody element has been created simple replace it otherwise
            // append the new element
            if (userMessageElement.childNodes[0]) {
                userMessageElement.replaceChild(messageBody, userMessageElement.childNodes[0]);
            } else {
                userMessageElement.appendChild(messageBody);
            }
        }
        
         
        
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
