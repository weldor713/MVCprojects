<%-- 
    Document   : Add
    Created on : Oct 16, 2015, 2:13:51 PM
    Author     : apprentice
--%>



<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix = "s" uri="http://www.springframework.org/tags"  %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>-->
        <style type="text/css">
            h1{
                /*background-color:lightcoral;*/
                text-align: center;
                border-radius: 25px;
                padding-top: 10px;
                padding-bottom: 10px;
            }
            #topbar {
                margin-top: 20px;
                padding-top: 10px;
            }
        </style>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Book</title>

        <!--Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">

        <!-- SWC Icon -->
        <link rel ="shortcut icon"
              href="${pageContext.request.contextPath}img/icon.png">


    </head>
     <body>
        <div class="container">
            <h1 class = "col-md-offset-3 col-md-6">Address Book</h1>
            <br><br>
            
            <div id="topbar">
                <%@include file="addressheader.jsp" %>
            </div>
        </div>

        <div class="container">
            <div class="row col-md-offset-2 col-md-8">
                <div>
                    <h2>Add New Address</h2>
                    <form class="form-horizontal" role="form">
                        <div class ="form-group">
                            <label for ="add-first-name" class="col-md-4 control-label">
                                First Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="add-first-name"
                                       placeholder ="First Name"/>
                            </div>
                        </div>
                        <div class ="form-group">
                            <label for ="add-last-name" class="col-md-4 control-label">
                                Last Name:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="add-last-name"
                                       placeholder ="Last Name"/>
                            </div>
                        </div>
                        <div class ="form-group">
                            <label for ="add-address" class="col-md-4 control-label">
                                Address:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="add-address"
                                       placeholder ="Address"/>
                            </div>
                        </div>
                        <div class ="form-group">
                            <label for ="add-city" class="col-md-4 control-label">
                                City:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="add-city"
                                       placeholder ="City"/>
                            </div>
                        </div>
                        <div class ="form-group">
                            <label for ="add-state" class="col-md-4 control-label">
                                State:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="add-state"
                                       placeholder ="State"/>
                            </div>
                        </div>
                        <div class ="form-group">
                            <label for ="add-zip" class="col-md-4 control-label">
                                Zip:
                            </label>
                            <div class="col-md-8">
                                <input type="text"
                                       class="form-control"
                                       id ="add-zip"
                                       placeholder ="Zip"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit"
                                        id ="add-button"
                                        class="btn btn-default">
                                    Create Contact
                                </button>
                            </div>

                        </div>
                    </form>
                </div> 

            </div>
        </div>

        <!-- placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/addressList.js"></script>
    </body>
</html>
