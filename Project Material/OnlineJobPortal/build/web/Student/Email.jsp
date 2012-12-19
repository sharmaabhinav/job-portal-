<%-- 
    Document   : StudentEmail
    Created on : May 25, 2011, 5:33:58 PM
    Author     : RAGHU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <style type="text/css">
	 .txtar{
		 width:100%;
		 height:100%
	 }
	 .lst{
		width:50%;
		 height:100%
	  
		 
	 }
	 </style>
    </head>
    <body>
         <jsp:include page="Header.jsp" />
         <form action="$$$$$$$$$" method="POST">
    <table width="868" height="540" border="0" cellpadding="2" cellspacing="0" align="center">
      <tr>
          <th width="145" height="38" scope="row"><h3>To:</h3></th>
        <td width="709"><input name="textfield2" type="text" size="100"></td>
      </tr>
      <tr>
        <th height="38" scope="row"><h3>Cc:</h3></th>
        <td><input name="textfield2" type="text" size="100"></td>
      </tr>
      <tr>
        <th height="38" scope="row"> <h3>BCc:</h3></th>
        <td><input name="textfield3" type="text" size="100"></td>
      </tr>
      <tr>
        <th height="38" scope="row"><h3>Subject:</h3></th>
        <td><input name="textfield4" type="text" size="100"></td>
      </tr>
      <tr>
        <th height="146" scope="row"><a href="EmailFileBrowse.jsp">Attach Files</a></th>
        <td><table width="714" height="139" border="0">
          <tr>
            <td width="332">&nbsp;</td>
            <td width="361"><table width="218" height="125" border="0">
              <tr>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><center><input  type="hidden" name="button" id="button" value="Remove" ></center></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
       <tr>
        <th height="199" colspan="2" scope="row"><textarea name="textarea" cols="100" rows="10" class="txtar"></textarea></th>
       </tr>
<tr>
          <th height="38" scope="row">&nbsp;</th>
        <td><center><input name="SEND MAIL" type="button" value="SEND MAIL" ></center></td>
      </tr>
    
    </table>
         </form>
    </body>
</html>
