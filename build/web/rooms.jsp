<%-- 
    Document   : roomById.jsp
    Created on : 30-nov-2019, 10:04:38
    Author     : Francesc Ferré and Aleix Sancho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <title>CESC FACTORY - Rooms</title>
        <script type="text/javascript">
            function saveId() {
                var idHab = document.getElementById("habId").value;
                $("#roomId").val(idHab);
                document.getElementById("formRoom").submit();
            }
        </script>
    </head>
    <body id="rooms">
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
                                    <h2 id="preuMes" class="currency">${elem.preuMes}</h2>
                                    <div class="row-form"> 
                                        <h5>${elem.tipusHabitacio}. ${elem.adresa}, ${elem.ciutat}</h5>
                                        <h5 class="replaced">${elem.llogater.id}</h5>
                                    </div>
                                    <p id="descripcio" class="text-muted"> ${elem.descripcio}</p>

                                    <form id="formRoom" method="post" action="roomById.do" class="form-inline">
                                        <input type="hidden" id="roomId" name="room" value="">
                                        <button class="btn btn-success my-2 my-sm-0" id="habId" type="submit" name="idRoom" onclick="saveID()" value="${elem.idHabitacio}">More details</button>
                                    </form>
                                </div>
                            </div>
                        </c:forEach> 
                    </c:when>
                    <c:otherwise> <div id="noHab" class="card card-body"><div class="col"><h2> No s'han trobat habitacions. </h2> </div></div></c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>

