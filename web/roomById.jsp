<%@ page import = "ModelEntities.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
    </head>
    <style>
        p.popup{
            margin-left: 5px;
        }
        label.rent{
            background-color: darkred;
            color: white;
        }
        body {
            background-image: url('Images/landscape.jpg');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
        }
        h1{
            margin-top: 10px; 
            margin-bottom: 25px;
            text-align: center;
        }
        button.rent, button.tenant{
            margin-top: 10px;
            width: 200px;
        }
        p.true::after{
            content:  "Si";
        }        
        p.false::after{
            content: "No";
        }
        #myCarousel .list-inline {
            white-space:nowrap;
            overflow-x:auto;
        }
        #myCarousel .carousel-indicators {
            position: static;
            left: initial;
            width: initial;
            margin-left: initial;
        }
        #myCarousel .carousel-indicators > li {
            width: initial;
            height: initial;
            text-indent: initial;
        }
        #myCarousel .carousel-indicators > li.active img {
            opacity: 0.7;
        }
    </style>

    <body onload="setMessageUsingDOM()">
        <jsp:include page="header.jsp" />
        <div class="container mt-4">
            <div class="row">
                <div class="col-md-6">
                    <div class="card card-body">
                        <form id="form1" action="rentingRoom.do" method="post">
                            <h1>${roomById.nomHabitacio}</h1>
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
                                <div class="form-group col-sm">
                                    <label class="font-weight-bold">Tipus habitació</label>
                                    <p>${roomById.tipusHabitacio}</p>
                                </div>
                                <div class="form-group col-sm">
                                    <label class="font-weight-bold">Preu mensual</label>
                                    <p>${roomById.preuMes}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm offset-md-1">
                                    <label class="font-weight-bold">Edat mínim</label>
                                    <p>${roomById.requeriment.rangEdatMin}</p>
                                </div>
                                <div class="form-group col-sm">
                                    <label class="font-weight-bold">Edat màxim</label>
                                    <p>${roomById.requeriment.rangEdatMax}</p>
                                </div>
                                <div class="form-group col-sm">
                                    <label class="font-weight-bold">Sexe llogater</label>
                                    <p>${roomById.requeriment.sexe}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-sm offset-md-1">
                                    <label class="font-weight-bold">Mascotes</label>
                                    <p class="${roomById.requeriment.mascotes}"></p>
                                </div>
                                <div class="form-group col-sm">
                                    <label class="font-weight-bold">Fumadors</label>
                                    <p class="${roomById.requeriment.fumador}"></p>
                                </div>
                                <div class="form-group col-sm">
                                    <p></p>
                                </div>
                            </div>
                        </form>
                        <div class="row">
                            <div class="form-group col-sm offset-md-1">
                                <form id="rent" action="rentingRoom.do" method="post">
                                    <input type="hidden" name="id" value="${roomById.idHabitacio}">
                                    <input type="hidden" name="nom" value="${roomById.nomHabitacio}">
                                    <input type="hidden" name="des" value="${roomById.descripcio}">
                                    <input type="hidden" name="adre" value="${roomById.adresa}">
                                    <input type="hidden" name="ciutat" value="${roomById.ciutat}">
                                    <input type="hidden" name="tipu" value="${roomById.tipusHabitacio}">
                                    <input type="hidden" name="preu" value="${roomById.preuMes}">
                                    <input type="hidden" name="min" value="${roomById.requeriment.rangEdatMin}">
                                    <input type="hidden" name="max" value="${roomById.requeriment.rangEdatMax}">
                                    <input type="hidden" name="sexe" value="${roomById.requeriment.sexe}">
                                    <input type="hidden" name="masco" value="${roomById.requeriment.mascotes}">
                                    <input type="hidden" name="fuma" value="${roomById.requeriment.fumador}">
                                    <div class="row form-row form-group">
                                        <div class="input-group" id="divTen" hidden>
                                            <div class="input-group-prepend">
                                                <label class="input-group-text rent">Llogater</label>
                                            </div>
                                            <select class="custom-select" style="margin-right: 35px" name="tenant" id="showTenants">
                                                <option value="null" selected>Choose...</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row form-row">
                                        <button id="rentBtn" style="background-color: darkred; color: white" type="button" disabled class="btn rent" data-toggle="modal" data-placement="top" data-target="#exampleModal">Rent</button>
                                    </div>
                                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Vols confirmar el lloguer?</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="col col-sm">
                                                        <div class="row row-form">
                                                            <h3 class="font-weight-bold">${roomById.nomHabitacio}</h3>
                                                        </div>
                                                        <div class="row row-form">
                                                            <label class="font-weight-bold">Descripció</label>
                                                            <p>${roomById.descripcio}</p>
                                                        </div>
                                                        <div class="row row-form">
                                                            <label class="font-weight-bold">Adreça:</label>
                                                            <p class="popup">${roomById.adresa}</p>
                                                        </div>

                                                        <div class="row row-form">
                                                            <label class="font-weight-bold">Ciutat:</label>
                                                            <p class="popup">${roomById.ciutat}</p>
                                                        </div>
                                                        <div class="row row-form">
                                                            <label class="font-weight-bold">Tipus habitació:</label>
                                                            <p class="popup">${roomById.tipusHabitacio}</p>
                                                        </div>
                                                        <div class="row row-form">
                                                            <label class="font-weight-bold">Preu mensual:</label>
                                                            <p class="popup">${roomById.preuMes}</p>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        <button type="button" class="btn btn-success" onclick="showOk()">Confirm</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <jsp:include page="back.jsp" />
                </div>
                <div class="col-md-5 offset-md-1">

                    <div class="card card-body">
                        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

                        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="5"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img class="d-block w-100" src="${roomById.urlImatge}" alt="First slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="${roomById.urlImatge}" alt="Second slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="${roomById.urlImatge}" alt="Third slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="${roomById.urlImatge}" alt="Fourth slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="${roomById.urlImatge}" alt="Fifth slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="${roomById.urlImatge}" alt="Sixth slide">
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                        <div class="row">
                            <div class="col-sm">
                                <div class="row no-margin mt-5">

                                    <figure class="col">
                                        <a href="${roomById.urlImatge}" data-size="1600x1067">
                                            <img alt="picture" src="${roomById.urlImatge}"
                                                 class="img-fluid">
                                        </a>
                                    </figure>

                                    <figure class="col">
                                        <a href="${roomById.urlImatge}" data-size="1600x1067">
                                            <img alt="picture" src="${roomById.urlImatge}"
                                                 class="img-fluid" />
                                        </a>
                                    </figure>

                                    <figure class="col">
                                        <a href="${roomById.urlImatge}" data-size="1600x1067">
                                            <img alt="picture" src="${roomById.urlImatge}"
                                                 class="img-fluid" />
                                        </a>
                                    </figure>
                                </div>
                                <div class="row no-margin mt-2">
                                    <figure class="col">
                                        <a href="${roomById.urlImatge}" data-size="1600x1067">
                                            <img alt="picture" src="${roomById.urlImatge}"
                                                 class="img-fluid" />
                                        </a>
                                    </figure>

                                    <figure class="col">
                                        <a href="${roomById.urlImatge}" data-size="1600x1067">
                                            <img alt="picture" src="${roomById.urlImatge}"
                                                 class="img-fluid" />
                                        </a>
                                    </figure>

                                    <figure class="col">
                                        <a href="${roomById.urlImatge}" data-size="1600x1067">
                                            <img alt="picture" src="${roomById.urlImatge}"
                                                 class="img-fluid" />
                                        </a>
                                    </figure>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        function setMessageUsingDOM() {
            var botonsLogin = document.getElementById("botons");
            var textLogin = document.getElementById("text");
            var tenant = document.getElementById("divTen")
            var dropdown = document.getElementById("showTenants");
            var trobat = false;
            var messageText = "";
            var usuariLogin = document.getElementById("usuariLogin");
            for (var c of ${clientsWeb})
            {
                if (c.autenticat) {
                    trobat = true;
                    messageText = "Heu iniciat sessió com: " + c.username;
                }
            }
            if (trobat) {
                botonsLogin.hidden = true;
                textLogin.hidden = false;
            } else {
                botonsLogin.hidden = false;
                textLogin.hidden = true;
            }
            usuariLogin.textContent = messageText;

            var rent = document.getElementById("rentBtn");

            if (!${roomById.ocupada} && (trobat)) {
                rent.disabled = false;
                tenant.hidden = false;
                for (var t of ${tenants}) {
                    dropdown.innerHTML += `<option value=` + t.id + `>` + t.info.nom + `</option>`;
                }
            } else {
                rent.disabled = true;
                tenant.hidden = true;
            }
        }
        function showOk() {
            if (document.getElementById("showTenants").value !== "null") {
                document.getElementById("rent").submit();
            }
        }
    </script>
</html>