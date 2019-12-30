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
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card card-body">
                        <form name="updateAccount" action="validateNewUser" method="post">
                            <h3>Introdueix les dades:</h3>
                            <div class="form-group">

                                <label class="font-weight-bold">Nom d'usuari</label>
                                <div id="userIdMessage"></div>
                                <input type="text" name="id" id="userid" onkeyup="validateUserId()" class="form-control"/>

                            </div>
                            <div class="form-group">

                                <label class="font-weight-bold">Correu electrònic</label>
                                <div id="userMailMessage"></div>
                                <input type="text" name="email" id="mailid" onkeyup="validateUserId()" class="form-control"/>

                            </div>
                            <div class="form-group">
                                <label class="font-weight-bold">Contrasenya</label>
                                <div class="input-group">
                                    <input type="password" name="passwd" id="passnewUserId" onkeyup="validateUserId()" class="form-control" data-toggle="password"/>
                                    <div class="input-group-append">
                                        <div class="input-group-text"><i class="fa fa-eye"></i></div>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <form id="form2" name="enviaDadesReal" action="newUserWeb.do" method="post">
                            <input type="hidden" id="usrNomReal" name="username" value="">
                            <input type="hidden" id="usrMailReal" name="mail" value="">
                            <input type="hidden" id="usrPasswordReal" name="password" value="">
                            <input type="button" id="submit_btn" disabled class="btn btn-success" value="Send Request" onclick="functionModifyValues()">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="bootstrap-show-password.min.js"></script>
    </body>
    <form action="http://localhost:8080/Pract2_SistemesOberts/index.html">
        <div style="margin-left: 675px">
            <button type="submit" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">Return</button>
        </div>
    </form>

    <script type="text/javascript">
                                var req;
                                var target;
                                var targetMail;
                                var isIE;
                                var messageUsername;

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
                                    if (!targetMail)
                                        targetMail = document.getElementById("mailid");
                                    var url = "validateNewUser?id=" + escape(target.value);
                                    url += "&email=" + escape(targetMail.value);
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
                                            messageUsername = req.responseXML.getElementsByTagName("valid")[0].childNodes[0].nodeValue;
                                            // Crida la funció "setMessageUsingDOM(message)" per mostrar o bé
                                            // "Valid User Id" o bé "Invalid User Id".

                                            // Si l'usuari introdueix un valor invàlid, no permet a l'usuari
                                            // clicar el botó del formulari.
                                            var submitBtn = document.getElementById("submit_btn");
                                            var mail = document.getElementById("malid").value;
                                            var username = document.getElementById("userid").value;
                                            var passwd = document.getElementById("passnewUserId").value;
                                            if (mail === "" || username === "" || passwd==="") {
                                                submitBtn.disabled = true;
                                            } else {
                                                submitBtn.disabled = false;
                                            }
                                        }
                                    }
                                }

                                function functionModifyValues() {
                                    setMessageUsingDOM(messageUsername);

                                    if (messageUsername == "true") {
                                        var nomUsuari = document.getElementById("userid").value;
                                        var contrassenyaUsuari = document.getElementById("passnewUserId").value;
                                        var email = document.getElementById("mailid").value;
                                        $("#usrNomReal").val(nomUsuari);
                                        $("#usrMailReal").val(email);
                                        $("#usrPasswordReal").val(contrassenyaUsuari);
                                        document.getElementById("form2").submit();
                                    }

                                }

                                // (5) Funció que mostra si l'usuari és vàlid o invàlid
                                // per mitjà de l'element "userIdMessage".
                                function setMessageUsingDOM(messageUsername) {
                                    var userMessageElement = document.getElementById("userIdMessage");
                                    var messageText;
                                    if (messageUsername == "false") {
                                        userMessageElement.style.color = "red";
                                        messageText = "No s'ha pogut crear un usuari amb aquestes caracteristiques";
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
                                function disableSubmitBtn() {
                                    var submitBtn = document.getElementById("submit_btn");
                                    submitBtn.disabled = true;
                                }
    </script>
</html>