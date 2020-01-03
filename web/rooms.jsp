<%@ page import = "ModelEntities.*" %>
<%@ page import = "AuthenticationModule.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <!-- Link Bootstrap JS and JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <style>
        body {
            background-image: url('Images/landscape.jpg');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
        }
        .currency::after {
            content:' \20AC/mes'; 
        }

        .replaced:not(:empty) {
            visibility: hidden;
            position: relative;
        }

        .replaced:not(:empty):after {
            visibility: visible;
            position: absolute;
            top: 0;
            left: 0;
            content: "Llogada";
            color: red;
        }

        .replaced:empty:after{
            content: "Disponible";
            color: green;
        }
    </style>
    <body onload="setMessageUsingDOM()">
        <jsp:include page="header.jsp" />
        <div class="container mt-3">
            <div class="row">
                <c:choose>
                    <c:when test = "${rooms != null}">
                        <c:forEach items="${rooms}" var="elem">
                            <div class="col-md-6 mb-3">
                                <div class="card card-body">
                                    <h2>${elem.nomHabitacio}</h2>
                                    <img src="${elem.urlImatge}" class="rounded mx-auto d-block" alt="Responsive image" width="500" height="300"/> 
                                    <h2 class="currency" style="margin-top: 10px">${elem.preuMes}</h2>
                                    <div class="row-form"> 
                                        <h5>${elem.tipusHabitacio}. ${elem.adresa}, ${elem.ciutat}</h5>
                                        <h5 class="replaced">${elem.llogater.id}</h5>
                                    </div>
                                    <p class="text-muted" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;"> ${elem.descripcio}</p>

                                    <form id="formRoom" method="post" action="roomById.do" class="form-inline">
                                        <input type="hidden" id="roomId" name="room" value="">
                                        <button class="btn btn-success my-2 my-sm-0" id="habId" type="submit" name="idRoom" onclick="saveID()" value="${elem.idHabitacio}">More details</button>
                                    </form>
                                </div>
                            </div>
                        </c:forEach> 
                    </c:when>
                    <c:otherwise> <div class="card card-body"><div class="col" style="text-align: center"><h2> No s'han trobat habitacions. </h2> </div></div></c:otherwise>
                </c:choose>
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
                    messageText = "Heu iniciat sessió com: " + c.username;
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

        function saveId() {
            var idHab = document.getElementById("habId").value;
            $("#roomId").val(idHab);
            document.getElementById("formRoom").submit();
        }
    </script>
</html>

