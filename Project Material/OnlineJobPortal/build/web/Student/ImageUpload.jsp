<%-- 
    Document   : EditImage
    Created on : May 25, 2011, 9:04:32 PM
    Author     : RAGHU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:include page="Header.jsp" />
               <h1>Upload Image</h1>
         <form id="frm" enctype="multipart/form-data" action="../ImageUpload" method="POST"  >
            <input type="file" name="fileup" value="" />&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="Upload" name="Submit" />
            
        </form>
                <form id="frm"  action="../SetDefaultImage" method="POST"  >
                 <input type="submit" value="Set Default Image " />
                </form>
    </body>
</html>
