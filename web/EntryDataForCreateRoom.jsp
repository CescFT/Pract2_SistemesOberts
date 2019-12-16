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
        
    </style>

    <body>
        <form>
            <div class="container mt-5">
                <div class="col-md-6 offset-md-3">
                    <div class="row">
                        <div class="card card-body">
                            <h3>Introdueix l'informació de l'habitació</h3>
                            <div class="form-group">
                                <label class="font-weight-bold" for="inputDescription">Descripció</label>
                                <textarea class="form-control" id="inputDescription" rows="3"></textarea>
                            </div>    
                            <div class="form-group">
                                <label class="font-weight-bold" for="inputAddress">Adreça</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
                            </div>
                            <div class="form-row">
                                <div style="margin-left: 5.4px" class="form-group">
                                    <label class="font-weight-bold" for="inputCity">Ciutat</label>
                                    <input type="text" class="form-control" id="inputCity">
                                </div>
                                <div style="margin-left: 8px; margin-right: 8px; width: 30%" class="form-group">
                                    <label class="font-weight-bold" for="inputType">Tipus habitació</label>
                                    <select id="inputType" class="form-control">
                                    <option value="1">Simple</option>
                                    <option value="2">Doble</option>
                                    <option value="3">Exterior</option>
                                    <option value="4">Interior</option>
                                    <option value="5">Moblada</option>
                                    </select>
                                </div>
                                <div style="width: 27%" class="form-group">
                                    <label class="font-weight-bold" for="inputPreuMes">Preu mensual</label>
                                    <input type="text" class="form-control" id="inputPreuMes">
                                </div>
                            </div>
                            <div class="form-row">
                                <div style="margin-left: 5.4px; margin-right: 8px; width: 150px" class="form-group">
                                    <label class="font-weight-bold" for="inputPreuMin">Preu mínim</label>
                                    <input type="text" class="form-control" id="inputPreuMin" placeholder="">
                                </div>
                                <div style="width: 150px" class="form-group">
                                    <label class="font-weight-bold" for="inputPreuMax">Preu màxim</label>
                                    <input type="text" class="form-control" id="inputPreuMax">
                                </div>
                                <div  style="margin-left: 8px" class="form-group">
                                    <label class="font-weight-bold" for="inputSexe">Sexe llogater</label>
                                    <select style="width: 200px" id="inputSexe" class="form-control">
                                    <option selected>Escull...</option>
                                    <option value="1">Home</option>
                                    <option value="2">Dona</option>
                                    <option value="3">Unisex</option>
                                    </select>
                                </div>
                                <div style="margin-left: 5.4px" class="form-group">
                                    <label class="font-weight-bold" for="inputLlogater">ID llogater</label>
                                    <input type="text" class="form-control" id="inputLlogater">
                                </div>
                                <div style="margin-left: 8px" class="form-group">
                                    <div class="card card-body">    
                                        <label class="font-weight-bold" for="inputRequeriment">S'accepten?</label>
                                        <div class="form-check">
                                            <input type="checkbox" class="form-check-input" id="fumador">
                                            <label class="form-check-label" for="fumador">Fumador</label>
                                            <input style="margin-left: 10px" type="checkbox" class="form-check-input" id="mascotes">
                                            <label style="margin-left: 30px" class="form-check-label" for="mascotes">Mascotes</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
    <form action="http://localhost:8080/Pract2_SistemesOberts/index.html">
        <div style="margin-left: 670px">
            <button type="submit" class="btn btn-success" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">Registrar Habitació</button>
                
            <button style="margin-left: 150px" type="submit" class="btn btn-secondary" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">Return</button>
        </div>
    </form>
</html>