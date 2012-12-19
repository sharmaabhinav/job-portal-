<%-- 
    Document   : ProfessionalTable
    Created on : May 31, 2011, 11:17:42 PM
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
     <%
          try{
            String regId =  session.getAttribute("regId").toString();
            String Query = "select ExpField,ExpYear,CompanyName from Professional where StudentID = '" + regId+"'";
            java.sql.ResultSet rs = ConnPack.ConnectionFactory.getInstance().getResultSet(Query,"JOBDSN");
            %>

        <table align ="centre" >


        <% while(rs.next()){

                String ExpField=rs.getString(1);
                String ExpYear=rs.getString(2);
                String CompName=rs.getString(3);
                
            %>

            <tr>
               <td>

                   <h3> <%=ExpField%>   (<%=ExpYear%>) <%=CompName%><a href="../ProfessionalRemove?ef=<%=ExpField%>&ey=<%=ExpYear%>&cn=<%=CompName%>">Remove</a></h3>
               </td>

            </tr>
            <%
            }

            rs.close();
            }
          catch(Exception e)
               {
              out.println(e);
              e.printStackTrace();
              }
            %>
            <tr>
                <td>
                    <form action="ProfessionalAddNew.jsp" >
                        <center><input type="submit" value="ADD NEW " /></center>
                    </form>
                </td>
            </tr>
          </table>
    </body>
</html>
  
