<%-- 
    Document   : InterestCalculator
    Created on : Oct 14, 2015, 1:59:33 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calc</title>
    </head>
    <body>
            <FORM METHOD=POST ACTION="NextInterest.jsp">
                Enter annual interest rate:<input type=NUMBER MIN=1 NAME=rate size=10><br>
                Enter principal:<input type=NUMBER MIN=1 NAME=principal size=10><br>
                Enter number of years:<input type=NUMBER MIN=1 NAME=years size=10><br>
            <P><input type=SUBMIT>
        </form>
    </body>
</html>
