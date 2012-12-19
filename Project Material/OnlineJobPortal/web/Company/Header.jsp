<%--
    Document   : StHeader
    Created on : May 21, 2011, 4:10:19 PM
    Author     : INFOSYS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

          <link href="../_css/Company_Header.css" rel="stylesheet" type="text/css" />
          
    </head>
    <body >
        <div class="myheader">
       <table width="100%" cellspacing="0" cellpadding="0" align="center">
            	<tr valign="top">
                	<td colspan="2"  height="45" >
                            <pre><a href="Home.jsp" >Home Page</a>   <a href="index.jsp" >Registered Colleges</a> <a href="Profile.jsp" >Company Profile</a>    <a href="Account.jsp" >Company Account</a>    <a href="JobPosting.jsp" >Job Posting</a> <a href="StudentSearch.jsp" >Student Search</a> <a href="../Logout" >Logout</a></pre></td>
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
          if(!role.equals("Company"))
              {
                if(role.equals("College"))
                    response.sendRedirect("College/Home.jsp");
                else
                    if(role.equals("Student"))
                        response.sendRedirect("Student/Home.jsp");
              }
          String regId=obj.toString();
          String query="select  NameOfCompany from CompanyProfile where CompanyId='" + regId + "'";
          java.sql.ResultSet rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query, "JOBDSN");
          rs.next();

        %>
        <%
        
        %>
        <h2>Hello,<%=rs.getString(1)%></h2>
        
      
    </body>
</html>
