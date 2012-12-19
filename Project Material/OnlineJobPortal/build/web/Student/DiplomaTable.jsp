<%--
    Document   : StudentHigh
    Created on : May 26, 2011, 11:59:52 AM
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
          <jsp:useBean class="Beans.DiplomaTableBean" id="dtb" scope="session" />
          <%
           String regId =  session.getAttribute("regId").toString();
           dtb.setRegId(regId);
           dtb.setData();
           int N=dtb.getRowCount();
        if (N !=0 &&  N != -1){
           String degree[]=dtb.getDiplomaDegree();
           String field[]=dtb.getField();
           String coll[]=dtb.getOrganisation();
           for(int i=0;i<degree.length;i++)
           {
          %>
          <h3> <%=degree[i]%>   (<%=field[i]%>) <%=coll[i]%><a href="../DiplomaRemove?Degree=<%=degree[i]%>&Field=<%=field[i]%>&Coll=<%=coll[i]%>">Remove</a></h3>
            <%
            }//end of for loop
           }//end of if
           %>
                    <form action="DiplomaAddNew.jsp"  method ="POST">
                        <center><input type="submit" value="ADD NEW " /></center>
           </form>
         </body>
</html>
