<%-- 
    Document   : header
    Created on : 18-dic-2019, 10:57:14
    Author     : Sancho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        button{
            margin-top: 10px;
            width: 200px;
        }
    </style>
    <body>
        <div class="form-group sticky-top col-sm" style="background-color: darkred; height: 100px">
            <div class="form-row">
                <form method="post" action="index.html">
                    <button style="margin-left: 50px; color: white; font-size: x-large" type="submit" class="btn btn-link font-weight-bold" data-toggle="tooltip" data-placement="top" title="You will be return to the main page.">Cesc Factory</button>
                </form>
                <div style="margin-top: 10px">
                    <form method="post" action="roomsResult.do" class="form-inline">
                        <input style="width: 430px; margin-top: 10px" name="location" class="form-control mr-sm-2" type="search" placeholder="Search by city" aria-label="Search">
                        <button class="btn btn-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </div>        
    </body>
</html>
