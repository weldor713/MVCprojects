<%-- 
    Document   : NextInterest
    Created on : Oct 14, 2015, 2:09:57 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="intclass" class="dto.Interest" scope="session"/> 
<jsp:useBean id="beanCalc" class="dto.CalcAmt" scope="session"/>
<jsp:setProperty name="intclass" property="*"/>
<jsp:setProperty name="beanCalc" property="*"/>

<html>
<body>
    <%= intclass.main(beanCalc.getRate(), beanCalc.getPrincipal(), beanCalc.getYears()) %>
        <br><br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>