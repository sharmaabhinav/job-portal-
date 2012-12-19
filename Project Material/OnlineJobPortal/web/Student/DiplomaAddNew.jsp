<%-- 
    Document   : DiplomaAddNew
    Created on : May 30, 2011, 1:26:50 AM
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

<h1 align="center">Diploma Information</h1>
<form id="form3" action="../DiplomaAddNew" method="post">
 <table align="center"  width="730">
			<tr >
			<td align="center"  height="35">
			Diploma Degree/Certification:
			</td>
			<td align="center" height="35">
			<input type="text"  name="degree">
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Field:
			</td>
			<td align="center" height="35">
			<input type="text"  name="field">
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Organization:
			</td>
			<td align="center" height="35">
			<input type="text" name="org">
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
		        Year Of Pass
			</td>
			<td align="center" height="35">
			<input type="text" name="yop" >
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Description:
			</td>
			<td align="center" height="35">
			<input type="text" name="desc" >
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
