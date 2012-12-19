<%-- 
    Document   : AcademicInfo
    Created on : May 30, 2011, 3:28:06 AM
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
             <jsp:useBean class="Beans.AcademicBean" id="acadBean" scope="session" />
           <%

           String regId=session.getAttribute("regId").toString();
           acadBean.setRegId(regId);
          
        %>
   <h1>Secondary Education Information</h1>
<table width="580" height="340" border="1">
  <tr>
    <th width="300" scope="row">Secondary Board </th>
    <td width="344"><jsp:getProperty name="acadBean" property="secBoard" /></td>
  </tr>
  <tr>
    <th scope="row">Year Of Passing </th>
    <td><jsp:getProperty name="acadBean" property="secYOP" /></td>
  </tr>
  <tr>
    <th scope="row">Score Type </th>
     <td><jsp:getProperty name="acadBean" property="secScoreType" /></td>
  </tr>
  <tr>
    <th scope="row">Score Value </th>
    <td><jsp:getProperty name="acadBean" property="secValue" /></td>
  </tr>
</table>
        <br><br>
<h1>Senior Secondary Education Information</h1>
<table width="580" height="340" border="1">
  <tr>
    <th width="300" scope="row">Senior Secondary Board </th>
    <td width="344"><jsp:getProperty name="acadBean" property="senSecBoard" /></td>
  </tr>
  <tr>
    <th scope="row">Year Of Passing </th>
    <td><jsp:getProperty name="acadBean" property="senSecYOP" /></td>
  </tr>
  <tr>
    <th scope="row">Score Type </th>
    <td><jsp:getProperty name="acadBean" property="senSecScoreType" /></td>
  </tr>
  <tr>
    <th scope="row">Score Value </th>
    <td><jsp:getProperty name="acadBean" property="senSecValue" /></td>
  </tr>
</table>
    </body>
</html>
