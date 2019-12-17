<%@ page import = "ModelEntities.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
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
        h4:not(:empty)::after{
            content: 'holaaaaa';    
        }
    </style>
    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card card-body">     
                        <c:forEach items="${rooms}" var="elem">
                            <img src="habitacio_triple_5_182.jpg" class="rounded mx-auto d-block" alt="Responsive image" width="500" height="300"/> 
                            <h2 class="currency" style="margin-top: 10px">${elem.preuMes}</h2>
                            <h5>${elem.tipusHabitacio}. ${elem.adresa}</h5>
                            <h4>${elem.llogater}</h4>
                            <h6>${elem.ciutat}</h6>
                            <p class="text-muted"> ${elem.descripcio}.</p>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

