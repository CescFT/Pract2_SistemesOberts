<%-- 
    Document   : header
    Created on : 18-dic-2019, 10:57:14
    Author     : Sancho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <style>
        button.btn-success{
            width: 180px;
        }
        button.btn-light{
            width: 50px;
            height: 30px;
        }
        p.white{
            color : white;
        }
    </style>
    <body>
        <div class="form-group sticky-top col-sm" style="background-color: darkred; height: 70px">
            <div class="form-row">
                <form method="post" action="welcome.do">
                    <button style="margin-left: 50px; color: white; font-size: x-large" type="submit" class="btn btn-link font-weight-bold" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">Cesc Factory</button>
                </form>
                <div style="margin-top: 10px">
                    <form method="post" action="roomsResult.do" class="form-inline">
                        <input id="cityEntryData" onkeyup="validateUserId()" style="width: 430px; margin-left: 20px" name="location" class="form-control mr-sm-2" type="search" placeholder="Search by city" aria-label="Search">
                        <button class="btn btn-success" type="submit">Search</button>
                    </form>
                    <div id="suggerenciesCiutats"></div>
                </div>
                <div class="form-inline" style="position: absolute; right: 0; margin-top: 10px; margin-right: 130px">
                    <div class="form-inline" id="botons"><jsp:include page="loginBotons.jsp" /></div>
                    <div class="form-inline" id="text" hidden><jsp:include page="textLogin.jsp" /></div>
                </div>                
            </div>
        </div>

    </body>
    <script text="text/javascript">
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
                target = document.getElementById("cityEntryData");
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
            var userMessageElement = document.getElementById("suggerenciesCiutats");
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
        
    </script>
</html>
