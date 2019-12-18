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
            margin-top: 20px;
            margin-left: 7px;
            width: 200px;
        }
    </style>

    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card card-body">
                        <img src="habitacio_triple_5_182.jpg" class="rounded mx-auto d-block" alt="Responsive image" width="500" height="300"/> 
                        <div class="form-group">
                            <label class="font-weight-bold" style="margin-top: 10px">Descripció</label>
                            <p <input type="text" name="username" class="form-control"/>${roomById.descripcio}</p>
                        </div>    
                        <div class="form-group">
                            <label class="font-weight-bold">Adreça</label>
                            <p <input type="text" name="username" class="form-control"/>${roomById.adresa}</p>
                        </div>
                        <div class="form-row">
                            <div class="col col-md-3">
                                <div class="form-group">
                                    <label class="font-weight-bold">Ciutat</label>
                                    <p <input type="text" name="username" class="form-control"/>${roomById.ciutat}</p>
                                </div>
                            </div>
                            <div class="col col-md-4">
                                <div style="margin-left: 8px; margin-right: 8px;" class="form-group">
                                    <label class="font-weight-bold">Tipus habitació</label>
                                    <p <input type="text" name="username" class="form-control"/>${roomById.tipusHabitacio}</p>
                                </div>
                            </div>
                            <div class="col col-md-5">
                                <div class="form-group">
                                    <label class="font-weight-bold">Preu mensual</label>
                                    <p <input type="text" name="username" class="form-control"/>${roomById.preuMes}</p>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col col-md-3">
                                <div class="form-group">
                                    <label class="font-weight-bold">Edat mínim</label>
                                    <p <input type="text" name="username" class="form-control"/>${roomById.requeriment.rangEdatMin}</p>
                                </div>
                            </div>
                            <div class="col col-md-4">
                                <div style="margin-left: 8px; margin-right: 8px;" class="form-group">
                                    <label class="font-weight-bold">Edat màxim</label>
                                    <p <input type="text" name="username" class="form-control"/>${roomById.requeriment.rangEdatMax}</p>
                                </div>
                            </div>
                            <div class="col col-md-5">
                                <div class="form-group">
                                    <label class="font-weight-bold">Sexe llogater</label>
                                    <p <input type="text" name="username" class="form-control"/>${roomById.requeriment.sexe}</p>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col col-md-3">
                                <div class="form-group">
                                    <label class="font-weight-bold" for="inputLlogater">ID llogater</label>
                                    <p <input type="text" name="username" class="form-control"/>ID</p>
                                </div>
                            </div>
                            <div class="col col-md-4">
                                <div style="margin-left: 8px;  margin-right: 8px;" class="form-group">
                                    <label class="font-weight-bold">Mascotes</label>
                                    <p <input type="text" name="username" class="form-control"/>${roomById.requeriment.mascotes}</p>
                                </div>
                            </div>
                            <div class="col col-md-4">
                                <div class="form-group">
                                    <label class="font-weight-bold">Fumadors</label>
                                    <p <input type="text" name="username" class="form-control"/>${roomById.requeriment.fumador}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <form action="http://localhost:8080/Pract2_SistemesOberts/index.html">
        <div style="margin-left: 675px">
         <button type="submit" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">Return</button>
        </div>
    </form>
</html>