

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
           <link href="../_css/Student_Header.css" rel="stylesheet" type="text/css" />
     
        
    </head>
    <body class="myheader">
           <jsp:useBean class="Beans.HeaderBean" id="headerBean" scope="page" />
       <table width="100%" cellspacing="0" cellpadding="0" align="center" class="tableclass">
            	<tr valign="top">
                	<td colspan="2"  height="45" >
                         <div class="logo" > <h1>
			<a href="Home.jsp">JobHub<br />
			<small >where you get your dream job...</small></a>
	  </h1></div>
                            <pre class="menu">                    <a href="Home.jsp" >Home Page</a>    <a href="Profile.jsp" >My Profile</a>    <a href="Account.jsp" >My Account</a>    <a href="JobSearch.jsp" >Job Search</a>    <a href="DocsUpload.jsp">Upload  My Document</a>  <a href="ShowAllDocs.jsp?flag=false" >Show All My Document</a>         <a href="CreateResume.jsp" >Create My Resume</a>        <a href="../Logout" >Logout</a></pre></td>

                </tr>
        </table>
 
         <%
         
          Object obj=session.getAttribute("regId");
          if(obj==null)
              {
                response.sendRedirect("UnAuth.jsp");
              }
          String role=session.getAttribute("role").toString();
          if(!role.equals("Student"))
              {
                if(role.equals("College"))
                    response.sendRedirect("College/CollegeHome.jsp");
                else
                    if(role.equals("Company"))
                        response.sendRedirect("Company/CompanyHome.jsp");
              }
          %>
          <%
          String regId=obj.toString();
          headerBean.setValues(regId);
         String firstName=headerBean.getFirstName();
         String middleName=headerBean.getMiddleName();
         String lastName=headerBean.getLastName();
         String collegeName=headerBean.getCollegeName();
        %>
        
            <br/>
       
        <h2>Hello,<%=firstName%> <%=middleName%> <%=lastName%> </h2>
        <h2>Regd College : <%=collegeName%></h2>
  
    </body>
</html>
