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

    <body>
        <jsp:include page="header.jsp" />
        <div class="container mt-5">
            <div class="form-row">
                <div class="col-md-6">
                    <div class="card card-body">
                        <h1 style="margin-top: 10px; margin-bottom: 25px; margin-left: 131px">Habitació 1</h1>
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
                        <div class="row">
                            <div class="form-group col-sm offset-md-1">
                                <form method="post" action="index.html" class="form-inline">
                                    <button style="background-color: darkred; color: white" type="submit" class="btn ${roomById.ocupada}" data-toggle="tooltip" data-placement="top">Rent</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col offset-md-1">
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
    </body>
</html>