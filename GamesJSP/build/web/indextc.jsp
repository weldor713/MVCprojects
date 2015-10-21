<%-- 
    Document   : index
    Created on : Oct 15, 2015, 9:55:59 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
    footer {  
        position: absolute;
        width: 100%;
        height: 100px; /* height of footer */
        bottom: 20px;
        margin-top: -100px; /* height of footer */
    }
    .jumbotron {
        height: 250px;
    }
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%@ include file="header.html"%>

        <div class="jumbotron col-md-8 col-md-offset-2" style="border-style:solid">

            <br>
            <%@ include file="TipCalc.jsp"%>
        </div>
    </body>
    <footer>
        <%@ include file="footer.html"%>
    </footer>
</html>
