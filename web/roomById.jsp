<%@ page import = "ModelEntities.*" %>
    
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
                    <tr>
                        <th class="bg-dark">Habitació 1</th>
                        <td class="table-info">${roomById.descripcio}</td>
                        <td class="table-info">${roomById.adresa}</td>
                        <td class="table-info">${roomById.ciutat}</td>
                        <td class="table-info">${roomById.tipusHabitacio}</td>
                        <td class="table-info">${roomById.preuMes}</td>
                        <td class="table-warning">${roomById.requeriment.sexe}</td>
                        <td class="table-warning">${roomById.requeriment.rangEdatMin}</td>
                        <td class="table-warning">${roomById.requeriment.rangEdatMax}</td>
                        <td class="table-warning">${roomById.requeriment.fumador}</td>
                        <td class="table-warning">${roomById.requeriment.mascotes}</td>
                        <td class="table-danger">${roomById.llogater.info.nom}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
    <form action="http://localhost:8080/Pract2_SistemesOberts/index.html">
         <button type="submit" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">Return</button>
    </form>
</html>