<%-- 
    Document   : PGTable
    Created on : May 30, 2011, 7:40:23 PM
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
           <jsp:useBean class="Beans.PGTableBean" id="pgtb" scope="session" />
         <%
            String regId =  session.getAttribute("regId").toString();

              pgtb.setRegId(regId);
           pgtb.setData();
           int N=pgtb.getRowCount();
        if (N !=0 &&  N != -1){
           String degree[]=pgtb.getDegree();
           String field[]=pgtb.getBranch();
           String coll[]=pgtb.getCollegeName();
           for(int i=0;i<degree.length;i++)
           {
          %>
          <h3> <%=degree[i]%>   (<%=field[i]%>) <%=coll[i]%><a href="../PGRemove?Degree=<%=degree[i]%>&Branch=<%=field[i]%>">Remove</a></h3>
            <%
            }//end of for loop
           }//end of if
           %>
                    <form action="PGAddNew.jsp"  method="POST">
                        <center><input type="submit" value="ADD NEW " /></center>
                    </form>
          
          
    </body>
</html>
    </body>
</html>
