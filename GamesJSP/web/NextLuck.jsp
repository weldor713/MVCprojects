<%-- 
    Document   : NextLuck
    Created on : Oct 14, 2015, 11:33:07 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="sevenClass" class="dto.LuckeySevens" scope="session"/> 
<jsp:useBean id="hollars" class="dto.Amount" scope="session"/>
<jsp:setProperty name="sevenClass" property="*"/>
<jsp:setProperty name="hollars" property="*"/>


<body>
    <%= sevenClass.main(hollars.getAmount()) %>
        <br><br>
    <a href="index.jsp">Back to Home</a>
</body>