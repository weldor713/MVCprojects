<%-- 
    Document   : NextLuck
    Created on : Oct 14, 2015, 11:33:07 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="seven" class="dto.Factorizer" scope="session"/> 
<jsp:useBean id="dollars" class="dto.Amount" scope="session"/>
<jsp:setProperty name="seven" property="*"/>
<jsp:setProperty name="dollars" property="*"/>


<body>
    <hr>
    <%= seven.main(dollars.getAmount()) %>
    <br><br>
    <a href="index.jsp">Back to Home</a>
    <hr>
    
</body>
