<%-- 
    Document   : CreateResume.jsp
    Created on : Jun 1, 2011, 4:23:53 PM
    Author     : RAGHU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
    </head>
    <body>
         <jsp:include page="Header.jsp" />
        <jsp:useBean class="CreateResume.Resume" id="resume" scope="session" />
        <%
            String regId=session.getAttribute("regId").toString();
            String status=resume.createResume(regId);
            if(status.equals("true"))
                response.sendRedirect("ShowAllDocs.jsp");
            else
                out.println(status);
        %>
        
    </body>
</html>
