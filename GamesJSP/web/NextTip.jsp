<%-- 
    Document   : NextTip
    Created on : Oct 14, 2015, 3:49:25 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="tipClass" class="dto.TipCalculator" scope="session"/> 
<jsp:useBean id="beanTip" class="dto.TipAmount" scope="session"/>
<jsp:setProperty name="tipClass" property="*"/>
<jsp:setProperty name="beanTip" property="*"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NextTip</title>
    </head>
    <body>
    <%= tipClass.main(beanTip.getTab(), beanTip.getTip()) %>
        <br><br>
    <a href="index.jsp">Back to Home</a>
    </body>
</html>
