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
            <jsp:useBean class="Beans.GraduationTableBean" id="gtb" scope="session" />
          <%
            String regId =  session.getAttribute("regId").toString();
            gtb.setRegId(regId);
           gtb.setData();
           int N=gtb.getRowCount();
        if (N !=0 &&  N != -1){
           String degree[]=gtb.getDegree();
           String field[]=gtb.getBranch();
           String coll[]=gtb.getCollegeName();
           for(int i=0;i<degree.length;i++)
           {
          %>
          <h3> <%=degree[i]%>   (<%=field[i]%>) <%=coll[i]%><a href="../GraduationRemove?Degree=<%=degree[i]%>&Branch=<%=field[i]%>">Remove</a></h3>
            <%
            }//end of for loop
           }//end of if
           %>
                    <form action="GraduationAddNew.jsp"  method="POST">
                        <center><input type="submit" value="ADD NEW " /></center>
                    </form>
          
    </body>
</html>
