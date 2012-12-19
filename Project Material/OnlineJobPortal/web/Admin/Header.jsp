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
          <table width="100%" cellspacing="0" cellpadding="0" align="center">
            	<tr valign="top">
                	<td colspan="2"  height="45" >
                            <pre><a href="Home.jsp" >Home Page</a>    <a href="Account.jsp" >My Account</a>   <a href="Registration.jsp">New Registration</a>      <a href="../Logout" >Logout</a></pre></td>
                </tr>
        </table>
        
    </head>
    <body>
         <%
          Object obj=session.getAttribute("regId");
          if(obj==null)
          {
                response.sendRedirect("UnAuth.jsp");
          }
          String role=session.getAttribute("role").toString();
          if(!role.equals("admin"))
           {
                if(role.equals("College"))
                    response.sendRedirect("/College/Home.jsp");
                else
                    if(role.equals("Company"))
                        response.sendRedirect("/Company/Home.jsp");
                    else
                        if(role.equals("Student"))
                            response.sendRedirect("/Student/Home.jsp");

            }
             %>
       
        <h2>Hello,Admin </h2>
       

      

      
    </body>
</html>
