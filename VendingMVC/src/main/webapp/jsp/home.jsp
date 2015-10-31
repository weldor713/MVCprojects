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
        <style>
            #padded {
                margin:20px;
            }
            #show-bank {
                color: blue;
                font-size: 20px;
                margin-bottom: 20px;
            }
            #messagewindow {
                color: red;
                font-style: italic;
                font-weight: bolder;
                text-decoration: underline;
            }
            #changerow {
                color: blue;
                font-size: 20px;
            }
            .btn-default {
                margin-bottom: 20px;

            }
            .clickme {
                height: 110px;
                width: 120px;
            }
            #change {
                color:blue;
                border-style: solid;
                border-color: #cc6868;
                border-radius: 30%;
                padding:15px;
            }
            #columnone {
                background-color: lightcyan;
                border-radius: 25px;
            }
            #columnthree {
                background-color: lightpink;
                border-radius: 25px;
            }
            .btn-group-lg {
                margin-top: 30px;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <h2>Vending Machine</h2>
            <br>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li role ="presentation"> <a href="${pageContext.request.contextPath}/inventorymanager">Inventory Manager</a>
                    </li>
                </ul>    
            </div>
            <div class="row">
                <div id = "columnone" class = "col-md-3">
                    <div class ="text-center">
                        <h3>Insert Money Here</h3>
                        <div class ="btn-group-lg btn-group-vertical">
                            <button type="button"
                                    id ="add-one"
                                    class="btn btn-default">
                                Add $1
                            </button>
                            <button type="button"
                                    id ="add-five"
                                    class="btn btn-default">
                                Add $5
                            </button>
                            <button type="button"
                                    id ="add-ten"
                                    class="btn btn-default">
                                Add $10
                            </button>
                        </div>
                        <br>
                    </div>
                </div>



                <div id = "columntwo" class = "col-md-6 text-center">
                    <h3>Items Available</h3>
                    <table align="center">
                        <tbody id="itemdisplay">
                            <!--Items are built here-->
                        </tbody>
                    </table>
                    <br><hr>
                    <h3 id="messagewindow"></h3>
                </div>


                <div id = "columnthree" class = "col-md-3">
                    <div class="text-center">
                        <div class = "text-center">
                            <br>
                            <p id="show-bank">Available Money: $ 0.00</p>
                             <button type="button"
                                    id ="cashout"
                                    class="btn btn-default"
                                    style="color:red">
                                Press here to cash out your change
                            </button>
                            <h4 id="change">Change Slot</h4>
                        </div>
                    </div>
                </div>
            </div>


            <!-- Placed at the end of the document so the pages load faster -->

            <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/vending.js"></script>
    </body>
</html>