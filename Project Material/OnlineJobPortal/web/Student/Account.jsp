<%-- 
    Document   : StudentAccount
    Created on : May 24, 2011, 11:05:37 AM
    Author     : RAGHU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../_css/mainContent.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <div class ="mainContent">
        <a href="ChangePassword.jsp">Change Password</a><br>
        <a href="Email.jsp">Student Email</a><br>
         <a href="../RemoveAcademic">Remove Academic Information</a><br>
         <a href="../RemoveAccount">Remove My Account</a><br>

        </div>
        <jsp:include page="Footer.jsp" />
    </body>
</html>
