<%-- 
    Document   : Error
    Created on : Feb 14, 2012, 10:12:23 PM
    Author     : LALIT-TOLANI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is error page 1</h1>
        <%
            String str=request.getParameter("ErrorDet");
        %>
        <h2>Your error message is<%=str%> </h2>
        <a href="Student/Home.jsp">Your Home Page!</a>
    </body>
</html>
