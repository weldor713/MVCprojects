<%-- 
    Document   : TipCalc
    Created on : Oct 14, 2015, 3:47:32 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <FORM METHOD=POST ACTION="NextTip.jsp">
                Enter amount of bill:<input type=NUMBER MIN=1 NAME=bill size=10><br>
                Enter tip percentage:<input type=NUMBER MIN=1 NAME=percent size=10><br>
            <P><input type=SUBMIT>
        </form>
    </body>
</html>
