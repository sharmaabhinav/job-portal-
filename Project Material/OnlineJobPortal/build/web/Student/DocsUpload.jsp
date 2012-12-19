<%-- 
    Document   : StudentDocsUpload
    Created on : May 28, 2011, 1:28:33 AM
    Author     : RAGHU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../_css/mainContent.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
          <jsp:include page="Header.jsp" />
          <div class ="mainContent">
        <form id="frm1" enctype="multipart/form-data" action="../DocsUpload" method="POST"  >
          Upload any document (all file format supported )<br><br>
            <input type="text" name="desc" value="Enter Description of this file...."  size="100"/><br><br>
            <input type="file" name="DocUp"  /><br><br>
        
            <input type="submit" value="Upload" name="Submit" />
        </form>
          </div>
           <jsp:include page="Footer.jsp" />
     </body>
</html>

