<%@ page import = "AuthenticationModule.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> //https://www.tutorialspoint.com/jsp/jstl_core_if_tag.htm i https://stackoverflow.com/questions/7578420/jstl-continue-break-inside-foreach
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>Main Page</title>
    </head>
    <style>
        body{
            background-image: url("Images/mijas2.jpg");
            background-color: #cccccc;
            height: 500px;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
        }
        p{
            margin-top: 17px;
        }
    </style>
    <body onload="setMessageUsingDOM()">
        <div class="container mt-3">
            <div class="col-md-6 offset-md-3">
                <div class="row">
                    <div class="form-inline" id="botons"><jsp:include page="loginBotons.jsp" /></div>
                    <div class="form-inline" id="text" hidden><jsp:include page="textLogin.jsp" /></div>
                    <form method="post" action="roomsResult.do" class="form-inline">
                        <div class="card card-body">
                            <div class="form-group">
                                <input style="width: 430px" name="location" class="form-control mr-sm-2" type="search" placeholder="Search by city" aria-label="Search">
                                <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
                    
    </body>
    <script type="text/javascript">
        
        function setMessageUsingDOM() {
            var usuariLogin = document.getElementById("botons");
            var textLogin = document.getElementById("text");
            var trobat = 0;
            var c=0;
            
            console.log(c);
            console.log(${clientsWeb[0].autenticat});
            console.log(${clientsWeb[1].autenticat});
            for(c=0; c<${numElems}; c++)
            {
                console.log(c);
                console.log("pero pq..."+${clientsWeb[c].username});
                
                    
            }
            console.log(trobat);
            
            if(trobat){
                usuariLogin.hidden = true;
                textLogin.hidden = false;
            }else{
                usuariLogin.hidden = false;
                textLogin.hidden = true;
            }
            
        }

    </script>
</html>
