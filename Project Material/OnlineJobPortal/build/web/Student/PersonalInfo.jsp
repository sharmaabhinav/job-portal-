<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">



<head>
<title>Student Personal Information</title>
</head>

<body>
      <jsp:include page="Header.jsp" />
        <jsp:useBean class="StudentSignUp.ExtraList" id="List" scope="page" />
        <jsp:useBean class="Beans.PersonalBean" id="pb" scope="session" />
       <%-- <jsp:useBean class="Beans.AcademicBean" id="acadBean" scope="session" />--%>
        <h1 align="center">Student Personal Information Form</h1>
        <%
      
        String regId=session.getAttribute("regId").toString();
       pb.setData(regId);


        
        %>
<form id="form4" action="../PersonalAddNew" method="post">
<table align="center"  width="730">
			<tr >
			<td align="center"  height="35">
			First Name:
			</td>
			<td align="center" height="35">
                            <input type="text"  name="firstName" value="<jsp:getProperty name="pb" property="firstName" />">
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Middle Name:
			</td>
			<td align="center" height="35">
			<input type="text"  name="middleName" value="<jsp:getProperty name="pb" property="middleName" />">
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Last Name:
			</td>
			<td align="center" height="35">
			<input type="text"  name="lastName" value="<jsp:getProperty name="pb" property="lastName" />">
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Gender:
			</td>
                        <td align="center" height="35">
                         <%
                        if(pb.getGender().equalsIgnoreCase("MALE")){
                          %>
			    <input type="radio" name="gender" value="MALE" checked="checked" />MALE
                            <input type="radio" name="gender" value="FEMALE"  />FEMALE
                        <%
                        }else{
                        %>
                            <input type="radio" name="gender" value="MALE"  />MALE
                            <input type="radio" name="gender" value="FEMALE" checked="checked"  />FEMALE
                         <%
                        }
                        %>
                        </td>
                       
			</tr>
			<tr >
			<td align="center" height="35">
			Date Of Birth:
			</td>
			<td align="center" height="35">
			<input type="text"  name="dob" value="<jsp:getProperty name="pb" property="dob" />" >
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Nationality:
			</td>
                        <td align="center" height="35">
                            <select name="nationality">
                                <option><jsp:getProperty name="pb" property="nationality" /></option>
                                  <%
                                  String nations[]=List.getNationalityName();
                            for(int i=0;i<nations.length;i++)
                                {
                            %>
                                <option><%=nations[i]%></option>
                           <%
                            }
                           %>
                            </select>
			
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Country of Residence:
			</td>
			<td align="center" height="35">
                            <select name="country">
                                 <option><jsp:getProperty name="pb" property="country" /></option>
                                  <%
                                  String countries[]=List.getCountryName();
                            for(int i=0;i<countries.length;i++)
                                {
                            %>
                                <option><%=countries[i]%></option>
                           <%
                            }
                           %>
                            </select>
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Contact No.:
			</td>
			<td align="center" height="35">
			<input type="text"  name="cdetails" value="<jsp:getProperty name="pb" property="cdetails" />">
			</td>
			</tr>
			<tr >
			<td align="center" height="35">
			Email Id:
			</td>
			<td align="center" height="35">
			<input type="text"  name="emailId" value="<jsp:getProperty name="pb" property="emailId" />">
			</td>
			</tr>
</table>
<br>

<table align="center" width="730">
<tr >
			<td align="center"  height="35">
			<input type="submit" name="Submit" value="Submit">
			</td>
</tr>
</table>
</form>
       
</body>

</html>
