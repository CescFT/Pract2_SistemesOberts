<%@ page import = "ModelEntities.*" %>
    
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
        .currency::before {
            content:'\20AC';
        }
        
    </style>

    <body>
        <form>
            <div class="form-group">
                <div class="form-group col-md-6">
                    <label for="inputDescription">Descripció</label>
                    <input type="text" class="form-control" id="inputDescription">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="inputAddress">Adreça</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
            </div>
            <div class="form-row col-md-6">
                <div class="form-group col-md-6">
                    <label for="inputCity">Ciutat</label>
                    <input type="text" class="form-control" id="inputCity">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputType">Tipus habitació</label>
                    <select id="inputType" class="form-control">
                    <option selected>Escull...</option>
                    <option value="1">Simple</option>
                    <option value="2">Doble</option>
                    <option value="3">Exterior</option>
                    <option value="4">Interior</option>
                    <option value="5">Moblada</option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputZip">Preu mensual</label>
                    <input type="text" class="form-control" id="inputPreu">
                </div>
            </div>
            <div class="form-group">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                    Check me out
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Sign in</button>
        </form>
    </body>
    <form action="http://localhost:8080/Pract2_SistemesOberts/index.html">
         <button type="submit" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">Return</button>
    </form>
</html>