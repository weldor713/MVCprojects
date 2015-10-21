<%-- 
    Document   : bylastname
    Created on : Oct 16, 2015, 2:14:22 PM
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

        <!-- placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/addressList.js"></script>
    </body>
</html>