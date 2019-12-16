<%@ page import = "ModelEntities.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%//MODIFICAR PERQUE ES PUGUI RECUPERAR LES DADES I MODIFICAR PERQUE ENS SURTI EL TOKEN %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <style>
        h1{
            margin-left: 15px;
        }
              
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
                        <form method="post" action="roomsResult.do">
                            <h3> Introdueix les dades:</h3>
                            <div class="form-group">
                                <label class="font-weight-bold">Ciutat</label>
                                <input type="text" class="form-control" placeholder="Per exemple: Valls"/>
                            </div>
                            <div class="form-group">
                                <label class="font-weight-bold">Ordenació</label>
                                <select id="inputType" class="form-control">
                                <option value="NO">Cap</option>
                                <option value="ASC">Ascendent</option>
                                <option value="DESC">Descendent</option>
                                </select>
                            </div>
                            <input type="submit" class="btn btn-success" value="OK">
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
