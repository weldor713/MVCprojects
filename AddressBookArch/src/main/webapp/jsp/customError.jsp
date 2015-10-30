<%-- 
    Document   : customError
    Created on : Oct 29, 2015, 6:51:28 PM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Address Book</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon"
              href="${pageContext.request.contextPath}/img/icon.png">

        <style type="text/css">
            h1{
                background-color:lightcoral;
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
    </head>
    <body>
        <div class="container">
            <h1 class = "col-md-offset-3 col-md-6">Address Book</h1>
            <br><br>

            <div id="topbar">
                <%@include file="addressheader.jsp" %>
            </div>

        </div>
        <div>
            <h2 style = "text-align: center;">An error has occurred...</h2>
            <h3 style = "text-align: center;">${errorMessage}</h3>
        </div>
        <!--        <div class="container">
                    <h1>Address Book</h1>
                    <hr/>
                    <div class="navbar">
                        <ul class="nav nav-tabs">
                            <li role="presentation" class="active">
                                <a href="${pageContext.request.contextPath}/home">Home</a>
                            </li>
                        </ul>
                    </div>
                    <div>
                        <h1>An error has occurred...</h1>
                        <h3>${errorMessage}</h3>
                    </div>
                </div>-->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    </body>
</html>