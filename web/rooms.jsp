<%@ page import = "ModelEntities.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <!-- Link Bootstrap JS and JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    </head>
    <style>
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
    <body>
        <jsp:include page="header.jsp" />
        <form method="post" action="roomById.do" class="form-inline">
            <div class="container mt-3">
                <div class="row">
                    <c:forEach items="${rooms}" var="elem">
                        <div class="col-md-6 mb-3">
                            <div class="card card-body">
                                <img src="${elem.urlImatge}" class="rounded mx-auto d-block" alt="Responsive image" width="500" height="300"/> 
                                <h2 class="currency" style="margin-top: 10px">${elem.preuMes}</h2>
                                <div class="row-form"> 
                                    <h5>${elem.tipusHabitacio}. ${elem.adresa}, ${elem.ciutat}</h5>
                                    <h5 class="replaced">${elem.llogater.id}</h5>
                                </div>
                                <p class="text-muted" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;"> ${elem.descripcio}</p>
                                <button class="btn btn-success my-2 my-sm-0" type="submit" name="idRoom" value="${elem.idHabitacio}">More details</button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </form>
    </body>
</html>

