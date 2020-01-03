<%-- 
    Document   : header
    Created on : 18-dic-2019, 10:57:14
    Author     : Sancho
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <style>
        button.btn-success{
            width: 180px;
        }
        button.btn-light{
            width: 50px;
            height: 30px;
        }
        p.white{
            color : white;
        }
    </style>
    <body>
        <div class="form-group sticky-top col-sm" style="background-color: darkred; height: 70px">
            <div class="form-row">
                <form method="post" action="welcome.do">
                    <button style="margin-left: 50px; color: white; font-size: x-large" type="submit" class="btn btn-link font-weight-bold" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">Cesc Factory</button>
                </form>
                <div style="margin-top: 10px">
                    <form method="post" action="roomsResult.do" class="form-inline">
                        <input style="width: 430px; margin-left: 20px" name="location" class="form-control mr-sm-2" type="search" placeholder="Search by city" aria-label="Search">
                        <button class="btn btn-success" type="submit">Search</button>
                    </form>
                </div>
                <div class="form-inline" style="position: absolute; right: 0; margin-top: 10px; margin-right: 130px">
                    <div class="form-inline" id="botons"><jsp:include page="loginBotons.jsp" /></div>
                    <div class="form-inline" id="text" hidden><jsp:include page="textLogin.jsp" /></div>
                </div>                
            </div>
        </div>
        
    </body>
</html>
