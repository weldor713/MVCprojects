<%-- 
    Document   : NextFloor
    Created on : Oct 14, 2015, 3:29:23 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="flrClass" class="dto.FlooringCalculator" scope="session"/> 
<jsp:useBean id="beanFloor" class="dto.FlrAmount" scope="session"/>
<jsp:setProperty name="flrClass" property="*"/>
<jsp:setProperty name="beanFloor" property="*"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NextFloor</title>
    </head>
    <body>
    <%= flrClass.main(beanFloor.getWidth(), beanFloor.getLength(), beanFloor.getCost()) %>
        <br><br>
    <a href="index.jsp">Back to Home</a>
    </body>
</html>
