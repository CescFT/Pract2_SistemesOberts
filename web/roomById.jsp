<%@ page import = "ModelEntities.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    </head>
    <style>
        button{
            margin-top: 10px;
            width: 200px;
        }
        p.true::after{
            content:  "Si";
        }        
        p.false::after{
            content: "No";
        }
        button.true{
            cursor: not-allowed;
            pointer-events: none;
        }
    </style>

    <body>
        <jsp:include page="header.jsp" />
        <div class="container mt-5">
            <div class="row">
                <div class="col-sm-12">
                    <div class="card card-body">
                        <h1 style="margin-top: 10px; margin-bottom: 25px; margin-left: 131px">Habitació 1</h1>
                        <img src="${roomById.urlImatge}" class="rounded mx-auto d-block" alt="Responsive image" width="800" height="400"/> 
                        <div class="row">
                            <div class="form-group col-sm-10 offset-md-1">
                                <label class="font-weight-bold" style="margin-top: 30px">Descripció</label>
                                <p>${roomById.descripcio}</p>
                            </div>
                        </div>    
                        <div class="row">
                            <div class="form-group col-sm-10 offset-md-1">
                                <label class="font-weight-bold">Adreça</label>
                                <p>${roomById.adresa}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm offset-md-1">
                                <label class="font-weight-bold">Ciutat</label>
                                <p>${roomById.ciutat}</p>
                            </div>
                            <div class="form-group col-sm offset-md-1">
                                <label class="font-weight-bold">Tipus habitació</label>
                                <p>${roomById.tipusHabitacio}</p>
                            </div>
                            <div class="form-group col-sm offset-md-1">
                                <label class="font-weight-bold">Preu mensual</label>
                                <p>${roomById.preuMes}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm offset-md-1">
                                <label class="font-weight-bold">Edat mínim</label>
                                <p>${roomById.requeriment.rangEdatMin}</p>
                            </div>
                            <div class="form-group col-sm offset-md-1">
                                <label class="font-weight-bold">Edat màxim</label>
                                <p>${roomById.requeriment.rangEdatMax}</p>
                            </div>
                            <div class="form-group col-sm offset-md-1">
                                <label class="font-weight-bold">Sexe llogater</label>
                                <p>${roomById.requeriment.sexe}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm offset-md-1">
                                <label class="font-weight-bold">Mascotes</label>
                                <p class="${roomById.requeriment.mascotes}"></p>
                            </div>
                            <div class="form-group col-sm offset-md-1">
                                <label class="font-weight-bold">Fumadors</label>
                                <p class="${roomById.requeriment.fumador}"></p>
                            </div>
                            <div class="form-group col-sm offset-md-1">
                                <form method="post" action="index.html" class="form-inline">
                                    <button style="background-color: darkred; color: white" type="submit" class="btn ${roomById.ocupada}" data-toggle="tooltip" data-placement="top">Rent</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>