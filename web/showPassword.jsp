<%@ page import = "ModelEntities.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

    <body>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card card-body">
                        <form>
                            <div class="form-group">
                                <h3>Informació de l'usuari:</h3>
                                <label class="font-weight-bold">Nom d'usuari</label>
                                <p class="text-left">${authorizedClient.username}</p>
                            </div>
                            <div class="form-group">
                                <label class="font-weight-bold">Contrasenya</label>
                                <div class="input-group">
                                    <p class="text-left">${authorizedClient.password}</p>
                                </div>
                            </div>
                        </form>
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