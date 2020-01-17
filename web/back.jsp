<%-- 
    Document   : header
    Created on : 18-dic-2019, 10:57:14
    Author     : Sancho
--%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <button type="submit" style="margin-top: 5px" onclick="reloadWeb()" class="btn btn-light" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">
            <span class="fa fa-chevron-left" style="margin-right: 5px"></span>
        </button>
    </body>
    <script text="text/javascript">
        function reloadWeb() {
            if (((document.referrer === 'http://localhost:8080/Pract2_SistemesOberts/login.do') || (document.referrer === 'http://localhost:8080/Pract2_SistemesOberts/createUser.do')) && (window.location.href === 'http://localhost:8080/Pract2_SistemesOberts/roomById.do')) {
                window.location.href = 'http://localhost:8080/Pract2_SistemesOberts/roomsResult.do';
            } else if ((document.referrer === 'http://localhost:8080/Pract2_SistemesOberts/rentingRoom.do') && (window.location.href === 'http://localhost:8080/Pract2_SistemesOberts/roomById.do')) {
                window.location.href = 'http://localhost:8080/Pract2_SistemesOberts/roomsResult.do';
            } else if ((window.location.href === 'http://localhost:8080/Pract2_SistemesOberts/login.do') || (window.location.href === 'http://localhost:8080/Pract2_SistemesOberts/createUser.do')){
                history.back(window.location.reload());
            } else {
                location.replace(document.referrer);
            }
            
        }
    </script>
</html>
