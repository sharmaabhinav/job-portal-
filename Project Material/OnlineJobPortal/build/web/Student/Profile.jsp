<%-- 
    Document   : StudentProfile
    Created on : May 21, 2011, 6:09:06 PM
    Author     : INFOSYS
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
     <%--  <jsp:setProperty name="acadBean" property="*" /> --%>
        <jsp:setProperty name="pb" property="*" />
            <div class ="mainContent">
            <pre>
                <a href="PersonalInfo.jsp">Personal Info</a>
                <a href="GraduationTable.jsp">Graduation Info</a>
                <a href="PGTable.jsp">Post-Graduation Info</a>
                <a href="../AcademicDec">Sec/Senior Sec Info</a>
                <a href="DiplomaTable.jsp">Diploma Info</a>
                <a href="ProfessionalTable.jsp">Professional Info</a>
                </pre>
            </div>
       <jsp:include page="Footer.jsp" />
    </body>
</html>