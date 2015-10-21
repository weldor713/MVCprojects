<%-- 
    Document   : FloorCalc
    Created on : Oct 14, 2015, 3:26:32 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FloorCalc</title>
    </head>
    <body>
            <FORM METHOD=POST ACTION="NextFloor.jsp">
                Enter width of room:<input type=NUMBER MIN=1 NAME=width size=10><br>
                Enter length of room:<input type=NUMBER MIN=1 NAME=length size=10><br>
                Enter cost per Sqft to install:<input type=NUMBER MIN=1 NAME=cost size=10><br>
            <P><input type=SUBMIT>
        </form>
    </body>
</html>
