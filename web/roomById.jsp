<%@ page import = "ModelEntities.*" %>
<% Object o = request.getAttribute("roomById");
    %>

<!DOCTYPE html>
<html>
    <head>
        <style>
            
            * { box-sizing: border-box; }
    
            .wrapper {
                width: 100vw;
                margin: 10px;      
                padding-right: 10px;
            }
            .row {
                align-items: center;
                width: auto;
                clear: both;
            }
            .col {
                float: left;
                width: 10%;
                background: rgb(255,150,150);
            }
            
            .col.span { width: 100%; }
            .col.span2 { width: 50%; }
            .col.span3 { width: 41.6%; }
            .col.span4 { width: 8.3%; }
        </style>
    </head>
    <body>
        <div class="wrapper">
            <div class="row">
              <div class="col span2">Info Habitació</div>   
              <div class="col span3">Requeriments</div>
              <div class="col span4">Llogater</div>
            </div>
            <div class="row">
              <div class="col">ID</div>
              <div class="col">Descripcio</div>
              <div class="col">3</div>
              <div class="col">4</div>
              <div class="col">5</div>
              <div class="col">6</div>
              <div class="col">7</div>
              <div class="col">8</div>
              <div class="col">9</div>
              <div class="col">10</div>
              <div class="col">11</div>
              <div class="col">12</div>
            </div>
            <div class="row">
              <div class="col span">13</div>   
            </div>
        </div>
    </body>
    <form action="http://localhost:8080/Pract2_SistemesOberts/index.html">
         <button type="submit">return to main page.</button>
    </form>
</html>