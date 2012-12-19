<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Home Page</title>
       
         
    </head>
    <body>
           <jsp:include page="Header.jsp" />
            <jsp:useBean class="Beans.StudDocBean" id="docLinks" scope="page" />
           <%
             String regId=session.getAttribute("regId").toString();
             String str=docLinks.getDocLink(regId);
           %>
           <div class="mainContent" >
           <table align="center" width="100%">
               <tr>
                   <td width="400">
                       <img src="<%=str%>"  alt="image not found: <%=str%>" class="imgcss"><br>
                       <a href="ImageUpload.jsp">Edit Image</a>
                   </td>
                   <td width="400">
                       
                   </td>

                   
               </tr>
           </table>
           
           </div>
                       <pre>









                       </pre>
            <jsp:include page="Footer.jsp" />
    </body>
</html>
