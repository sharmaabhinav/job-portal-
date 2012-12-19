<%-- 
    Document   : CgDesignHeader
    Created on : May 23, 2011, 6:59:28 PM
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

        <link href="../_css/Company_Header.css" rel="stylesheet" type="text/css" />
        <div class ="myheader">
       <table width="100%" cellspacing="0" cellpadding="0" align="center">
            	<tr valign="top">
                	<td colspan="2"  height="45" >
                            <pre><a href="Home.jsp" >Home Page</a>  <a href="index.jsp" >Registered Companies</a>    <a href="Profile.jsp" >College Profile</a>       <a href="Account.jsp" >Account Setting</a>       <a href="../Logout" >Logout</a>  </pre></td>
                </tr>
        </table>
        </div>
       <%
        Object obj=session.getAttribute("regId");
          if(obj==null)
              {
                response.sendRedirect("UnAuth.jsp");
              }
          String role=session.getAttribute("role").toString();
          if(!role.equals("College"))
              {
                if(role.equals("Company"))
                    response.sendRedirect("Company/Home.jsp");
                else
                    if(role.equals("Student"))
                        response.sendRedirect("Student/Home.jsp");
              }
          String regId=obj.toString();
          String query="select  NameOfCollege from CollegeProfile where CollegeId='" + regId + "'";
          java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query, "JOBDSN");
          rs.next();

        %>

        <h2>Hello,<%=rs.getString(1)%></h2>
        
        
    </body>
</html>
