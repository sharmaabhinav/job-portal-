
<%-- 
    Document   : AcademicAddNew
    Created on : May 30, 2011, 3:25:05 AM
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
            %>
        <h1 align="center">Secondary Education Information</h1>
<form id="form2" action="../AcademicAddNew" method="post">
    <input type="hidden" name="regId" value="<%=regId%>">
<table align="center"  width="730">
			<tr  >
			<td align="center"  height="35">
			Secondary Board:
			</td>
			<td align="center" height="35">
                            <%
                            String board[]={"CBSE","ICSE","State Boad","Other"};
                            %>
                                <select name="secBoard">

                                <%
                                for(int i=0;i<board.length;i++){

                                %>
                                <option><%=board[i]%></option>
                                <%
                                }
                            %>
                            </select>

			</td>
			</tr>
			<tr  >
			<td align="center" height="35">
			Year Of Passing:
			</td>
			<td align="center" height="35">
                            <select name="secYOP">
                                <%
                                for(int i=1987;i<2008;i++)
                                    {
                                %>
                                <option><%=i%></option>
                                <%
                                        }
                                        %>
                            </select>
			</td>
			</tr>
        		<tr  >
			<td align="center" height="35">
                            <pre>                                   Choose Score Type:      <input type="radio" name="secScoreType" value="Percentage" checked="checked" />Percentage   <input type="radio" name="secScoreType" value="Grade" />Grade</pre>
                            <br>
                            <pre>                                   Value:                     <input type="text" name="secValue" value=""  /></pre>

			</td>
			</tr>


</table>
<br>
<h1 align="center">Senior Secondary Education Information</h1>
<table align="center"  width="730">
			<tr  >
			<td align="center"  height="35">
			Senior Secondary Board:
			</td>
			<td align="center" height="35">
                             <select name="senSecBoard">
                                <%
                                   for(int i=0;i<board.length;i++){

                                %>

                                <option><%=board[i]%></option>
                                 <%
                                }
                            %>
                            </select>

                        </td>
			</tr>
			<tr  >
			<td align="center" height="35">
			Year Of Passing:
			</td>
			<td align="center" height="35">
                            <select name="senSecYOP">
                                <%
                                for(int i=1987;i<2008;i++)
                                    {
                                %>
                                <option><%=i%></option>
                                <%
                                        }
                                        %>
                            </select>
			</td>
			</tr>
                            <tr  >
			<td align="center" height="35">
                            <pre>                                   Choose Score Type:      <input type="radio" name="senSecScoreType" value="Percentage" checked="checked" />Percentage   <input type="radio" name="senSecScoreType" value="Grade" />Grade</pre>
                            <br>
                            <pre>                                   Value:                     <input type="text" name="senSecValue" value=""  /></pre>

			</td>
			</tr>


</table>
<br>

<br>
<table align="center" width="730">
<tr  >
			<td align="center"  height="35">
			<input type="submit" name="Submit" value="Submit">
			</td>
</tr>
</table>

</form>
    </body>
</html>
