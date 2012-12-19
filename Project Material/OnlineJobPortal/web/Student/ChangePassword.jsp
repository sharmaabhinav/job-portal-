<%-- 
    Document   : ChangePassword
    Created on : May 25, 2011, 5:32:31 PM
    Author     : RAGHU
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
           <jsp:include page="Header.jsp" />
           <%
           session.setAttribute("pageInfo","StudentChangePassword");
           %>
        <form action="../AllChangePassword" method="POST">
        <pre>
        Old Password: <input type="password" name="oldPass" value="" />

        New Password:<input type="password" name="newPass" value="" />

        Confirm Password:<input type="password" name="cnewPass" value="" />

        <input type="submit" value="Change Password" name="sb" />
        </pre>
        </form>
    </body>
</html>
