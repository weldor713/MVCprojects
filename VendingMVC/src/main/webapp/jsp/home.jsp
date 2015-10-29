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
            #show-bank {
                color: blue;
                font-size: 20px;
            }
            #changerow {
                color: blue;
                font-size: 20px;
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
                <div class ="text-center">

                    <div class="col-md-offset-2 col-md-8">
                        <div class ="btn-group-lg">
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
                        <div class = "text-center" id="show-bank">Total Money: $ 0.00</div>
                    </div>
                </div>
            </div>
                    <br><hr>
            <div class ="row">
                <div>                
                    <table align="center">
                        <tbody id="itemdisplay">
                            
                            <!--Items are built here-->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <br>
        <br>
        <div class ="row col-md-offset-2" id="changerow">
            <p class="col-md-2"></p>
            <div id="change">
            </div>
        </div>



        <!-- Placed at the end of the document so the pages load faster -->

        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script>
            var money = 0;
            $('#add-one').click(function () {
                var adder = 1;
                money = parseFloat(money) + parseFloat(adder);
                var moneyTwoDec = parseFloat(money).toFixed(2);
                var total = "Total Money: $ " + moneyTwoDec;
                document.getElementById("show-bank").innerHTML = total;
            });
            $('#add-five').click(function () {
                var adder = 5;
                money = parseFloat(money) + parseFloat(adder);
                var moneyTwoDec = parseFloat(money).toFixed(2);
                var total = "Total Money: $ " + moneyTwoDec;
                document.getElementById("show-bank").innerHTML = total;
            });
            $('#add-ten').click(function () {
                var adder = 10;
                money = parseFloat(money) + parseFloat(adder);
                var moneyTwoDec = parseFloat(money).toFixed(2);
                var total = "Total Money: $ " + moneyTwoDec;
                document.getElementById("show-bank").innerHTML = total;
            });
            $('#foodchoice').click(function (e) {
                e.preventDefault();
                e.stopPropagation();
                var moneyTwoDec = parseFloat(money).toFixed(2);
                var total = "Total Change: $ " + moneyTwoDec;
                document.getElementById("change").innerHTML = total;
                money = 0;
                moneyTwoDec = parseFloat(money).toFixed(2);
                total = "Total Money: $ " + moneyTwoDec;
                document.getElementById("show-bank").innerHTML = total;
                return false;
            })
        </script>
    </body>
</html>