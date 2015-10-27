<%-- 
    Document   : home
    Created on : Oct 25, 2015, 7:39:06 PM
    Author     : apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

              <!-- SWC Icon -->
              <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>

        <div class="container">
            <h1>Vending Machine/Spring MVC Application from Archetype</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                     <li role ="presentation"> <a href="${pageContext.request.contextPath}/inventorymanager">Inventory Manager</a>
                    </li>
                </ul>    
            </div>
        </div>
        <h2>Vending Machine</h2>
        <br>

        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="user-money" class="col-md-2 control-label">
                    Enter Your $ Amount:
                </label>
                <div class="col-md-2">
                    <input type="text"
                           class="form-control"
                           id="user-money"
                           placeholder="$"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-8">
                    <button type="submit"
                            id ="add-button"
                            class="btn btn-default">
                        Enter Money
                    </button>
                </div>

            </div>
        </form>


        <div class="container">
            <form role="form">
                <div class="radio">
                    <label><input type="radio" name="item" value="twix" id="twix">Twix $ 1.00</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="item" value="snickers" id="snickers">Snickers $1.50</label>
                </div>
                <div class="radio disabled">
                    <label><input type="radio" name="item" value="raisins" id="raisins" >Raisins $0.75</label>
                </div>
                <input id="foodchoice" type="submit">
            </form>
        </div>
        <br>
        <br>

        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="change" class="col-md-2 control-label">
                    Your Change:
                </label>
                <div class="col-md-2">
                    <input type="text"
                           class="form-control"
                           id="change"
                           placeholder="$"/>
                </div>
            </div>
            <div class="form-group">

            </div>
        </form>


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
