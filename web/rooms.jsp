<%@ page import = "ModelEntities.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <style>
        h1{
            margin-left: 15px;
        }
        
        th {
            background-color: gray;
            color: white;
            text-align: center;
        }
        
        td {
            background-color: darkgrey;
            text-align: center;
            vertical-align: middle;
        }
       
        button{
            margin-top: 20px;
            margin-left: 15px;
            width: 200px;
        }
    </style>

    <body>
        <h1> El resultat de la petició és: </h1>
        <div class="container-fluid">
            <table class="table table-bordered">
                <thead>
                    <tr>
                      <th rowspan="2">#</th>
                      <th colspan="5">Informació Habitació</th>
                      <th colspan="5">Requeriments</th>
                      <th scope="col">Llogater</th>
                    </tr>
                    
                    <tr>
                        <td>Descripció</td>
                        <td>Adreça</td>
                        <td>Ciutat</td>
                        <td>Tipus Habitació</td>
                        <td>Preu mes</td>
                        <td>Sexe llogater</td>
                        <td>Preu min</td>
                        <td>Preu max</td>
                        <td>Fumador</td>
                        <td>Mascotes</td>
                        <td>Nom llogater</td>
                    </tr>
                
                </thead>
                <tbody>
                    <c:forEach items="${rooms}" var="elem">
                        <tr>
                            <th class="bg-dark">Habitació 1</th>
                            <td class="table-info">${elem.descripcio}</td>
                            <td class="table-info">${elem.adresa}</td>
                            <td class="table-info">${elem.ciutat}</td>
                            <td class="table-info">${elem.tipusHabitacio}</td>
                            <td class="table-info">${elem.preuMes}</td>
                            <td class="table-warning">${elem.requeriment.sexe}</td>
                            <td class="table-warning">${elem.requeriment.rangEdatMin}</td>
                            <td class="table-warning">${elem.requeriment.rangEdatMax}</td>
                            <td class="table-warning">${elem.requeriment.fumador}</td>
                            <td class="table-warning">${elem.requeriment.mascotes}</td>
                            <td class="table-danger">${elem.llogater.info.nom}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    

    <form action="http://localhost:8080/Pract2_SistemesOberts/index.html">
         <button type="submit" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">Return</button>
    </form>
</html>

