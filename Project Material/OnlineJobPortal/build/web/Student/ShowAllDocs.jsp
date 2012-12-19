<%-- 
    Document   : ShowAllDocs
    Created on : May 28, 2011, 2:00:50 AM
    Author     : RAGHU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="../_css/mainContent.css" rel="stylesheet" type="text/css" />
            <link href="../_css/Student_Footer.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
         <jsp:include page="Header.jsp" />
         <div class ="maincontent">
        <%
         String desc=null;
         String link=null;
         java.sql.ResultSet rs=null;
          try{
        String regId=session.getAttribute("regId").toString();
        String query="select * from Documents where StudentID='"+regId+"' and DocDesc not in ('Image') ";
        rs=ConnPack.ConnectionFactory.getInstance().getResultSet(query, "JOBDSN");
        int num=0;
        while(rs.next()){
            num++;

        }
        rs.beforeFirst();
       

         %>
         
   
    <h1> Links to Documents </h1>
    
       <%
       if(num != 0){

       while(rs.next())
       {
        %>
         <a href="<%=rs.getString(3)%>"><%=rs.getString(4)%></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../RemoveDocs?name=<%=rs.getString(2)%>">Remove</a> <br><br>

    
    <%
     }//end of while
   }//end of if

    %>
    <%
       }catch(Exception e){

        out.println(e+"<br>"+e.getMessage());
        }
%>
         </div>
         <pre>














         </pre>
         <jsp:include page="Footer.jsp" />
 </body>
</html>
