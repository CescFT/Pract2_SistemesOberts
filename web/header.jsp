<%-- 
    Document   : header
    Created on : 18-dic-2019, 10:57:14
    Author     : Sancho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <form method="post" action="roomsResult.do" class="form-inline">
            <div class="container mt-5">
                <div class="col-md-6 offset-md-3">
                    <div class="row">
                        <div class="card card-body">
                            <div class="form-group">
                                <input style="width: 430px" name="location" class="form-control mr-sm-2" type="search" placeholder="Search by city" aria-label="Search">
                                <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
