<%-- 
    Document   : EntryDataForAutenticateClientWeb.jsp
    Created on : 14-dic-2019, 14:02:24
    Author     : Francesc Ferré and Aleix Sancho
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <title>CESC FACTORY - Login</title>
        <link rel="stylesheet" type="text/css" href="Styles/rooms.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="bootstrap-show-password.min.js"></script>
        <script type="text/javascript">
            var req;
            var target;
            var isIE;
            var message;
            var target2;
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
                    target = document.getElementById("userid");
                if (!target2)
                    target2 = document.getElementById("passwdId");
                var url = "validate?id=" + escape(target.value);
                url += "&passwd=" + escape(target2.value);
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
                        message = req.responseXML.getElementsByTagName("valid")[0].childNodes[0].nodeValue;


                        // Si l'usuari introdueix un valor invàlid, no permet a l'usuari
                        // clicar el botó del formulari.
                        var userId = document.getElementById("userid").value;
                        var passId = document.getElementById("passwdId").value;
                        var submitBtn = document.getElementById("submit_btn");
                        if (userId === "" || passId === "") {
                            submitBtn.disabled = true;
                        } else {
                            submitBtn.disabled = false;
                        }
                    }
                }
            }



            function functionModifyValues() {
                setMessageUsingDOM(message);
                if (message == "true") {
                    var nomUsuari = document.getElementById("userid").value;

                    var contrassenyaUsuari = document.getElementById("passwdId").value;
                    $("#nomUsuariReal").val(nomUsuari);
                    $("#contrassenyaUsuariReal").val(contrassenyaUsuari);
                    $("#paginaAnterior").val(document.referrer);
                    document.getElementById("form1").submit();
                    //window.location = 'http://localhost:8080/Pract2_SistemesOberts/authentication.do?username='+nomUsuari+'&password='+contrassenyaUsuari;
                }

            }

            function setMessageUsingDOM(message) {
                var userMessageElement = document.getElementById("userIdMessage");
                var messageText = "";
                if (message == "false") {
                    userMessageElement.style.color = "red";
                    messageText = "Usuari o contrasenya incorrectes.";
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
    </head>
    <body class="bodyLogin">
        <div class="container mt-4">
            <div class="row">
                <div class="col-md-5 offset-md-3">
                    <div class="form-inline"><jsp:include page="loginBotons.jsp" /></div>
                    <div class="form-group">
                        <div class="row form-row">
                            <jsp:include page="back.jsp" />
                            <h3 id="putData">Introdueix les dades:</h3>
                        </div>
                        <div id="userIdMessage"></div>
                        <form name="updateAccount" action="validate" method="post">
                            <div class="form-group">
                                <input type="text" name="id" id="userid" onkeyup="validateUserId()" placeholder="Username" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input type="password" name="passwd" id="passwdId" onkeyup="validateUserId()" placeholder="Password" class="form-control" data-toggle="password"/>
                                    <div class="input-group-append">
                                        <div class="input-group-text"><i class="fa fa-eye"></i></div>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <form id="form1" action="authentication.do" method="post">
                            <input type="hidden" id="nomUsuariReal" name="username" value="">
                            <input type="hidden" id="contrassenyaUsuariReal" name="password" value="">
                            <input type="hidden" id="paginaAnterior" name="anterior" value="">
                            <input type="button" id="submit_btn" disabled class="btn btn-success form-group" value="Send Request" onclick="functionModifyValues()">
                        </form>
                    </div>
                </div>
            </div>  
        </div>
    </body>
</html>
