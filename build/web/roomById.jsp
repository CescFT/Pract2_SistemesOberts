<%@ page import = "ModelEntities.*" %>
    
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <style>
        .table td {
            text-align: center;   
        }
        .table th {
            text-align: center;   
        }
    </style>

    <body>
        <table class="table table-bordered">
            <thead>
                <tr>
                  <th scope="col"></th>
                  <th colspan="5">Informacio Habitacio</th>
                  <th colspan="5">Requeriments</th>
                  <th scope="col">Llogater</th>
                </tr>
            </thead>
            <thead>
                <tr>
                    <td></td>
                    <td>Descripcio</td>
                    <td>Adresa</td>
                    <td>Ciutat</td>
                    <td>Tipus Habitacio</td>
                    <td>Preu mes</td>
                    <td>Sexe Llogater</td>
                    <td>Preu min</td>
                    <td>Preu max</td>
                    <td>Fumador</td>
                    <td>Mascotes</td>
                    <td>Nom llogater</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>Habitació 1</th>
                    <td>Descripcio</td>
                    <td>Adresa</td>
                    <td>Ciutat</td>
                    <td>Tipus Habitacio</td>
                    <td>Preu mes</td>
                    <td>Sexe Llogater</td>
                    <td>Preu min</td>
                    <td>Preu max</td>
                    <td>Fumador</td>
                    <td>Mascotes</td>
                    <td>Nom llogater</td>
                </tr>
            </tbody>
        </table>
    </body>
    <form action="http://localhost:8080/Pract2_SistemesOberts/index.html">
         <button type="submit">return to main page.</button>
    </form>
</html>