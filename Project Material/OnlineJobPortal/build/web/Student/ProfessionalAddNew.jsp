<%-- 
    Document   : ProfessionalEdit
    Created on : May 31, 2011, 10:17:58 PM
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
          <h1 align="center">Professional Information</h1>
      <form id="form3" action="../ProfessionalAddNew" method="post">
 <table align="center"  width="730">
			<tr >
			<td align="center"  height="35">
			Experience Field:
			</td>
			<td align="center" height="35">
			<input type="text" name="ExpField">
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Experience Years:
			</td>
			<td align="center" height="35">
			<input type="text" name="ExpYear">
			</td>
			</tr>
                        <tr>
                        <td align="center" height="35">
			Company Name:
			</td>
			<td align="center" height="35">
			<input type="text" name="CompName">
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Designation:
			</td>
			<td align="center" height="35">
			<input type="text" name="Desgn">
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Work Profile:
			</td>
			<td align="center" height="35">
			<input type="text" name="wp">
			</td>
			</tr>

</table>
<br>

<table align="center" width="730">
<tr >
			<td align="center"  height="35">
			<input type="submit" name="Submit" value="Submit">
			</td>
</tr>
</table>
</form>
    </body>
</html>
    