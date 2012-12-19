<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <title>

    </title>
    <head>
         
        <script type="text/javascript">
             var reqObj;
            function getReqObject()
            {
                try
                {
                    reqObj=new xmlReqObject();
                }
                catch(e)
                {
                    try
                    {
                        reqObj=new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    catch(e)
                    {
                       try{
                        reqObj=new XMLHttpRequest();
                        //alert("FIREFOX Supporting AJAX ");
                       }catch(e){
                           try{
                        reqObj=new  ActiveXObject("Msxml2.XMLHTTP");
                       }catch(e){
                           reqObj=null;
                       }

                       }
                    }
                }
            }

            function recFun()
            {
                 if(reqObj.readystate<4)
                 {
                     document.getElementById('availid').innerHTML="Waiting..."
                    
                 }else 
                 if(reqObj.readystate==4 || reqObj.readystate=="completed");
                   {
                      document.getElementById('availid').innerHTML=reqObj.responseText;
                     //  if( typeof XMLHttpRequest == 'undefined')
                       //  alert("Bowser response error");
                      
                   } 
                  
            }

            function askForValidity(str)
            {
                if(str.length==0)
                    {
                        document.getElementById('availid').innerHTML="Please Fill";
                        alert("regId field cannot be empty");
                        return false;
                    }
                getReqObject();
                if(reqObj==null )
                    {
                        alert("Browser Does not Supports Ajax!!!");
                        return false;
                    }
                try
                {
                    reqObj.onreadystatechange=recFun;
                    reqObj.open("POST","../RegistryAjaxCheck?regId=" + str,true);
                    reqObj.send();
                   
                }
                catch(e)
                {
                    alert("Could Not Connect To Server!!!");
                    return false;
                }
            }
    </script>
    <link href="../_css/signup.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class ="myheader">

             <div class="logo" > <h1>
			<a href="SignUp.jsp">JobHub<br />
			<small >where you get your dream job...</small></a>
                 </h1></div></div>
      <jsp:useBean class="StudentSignUp.StudentSignUp" id="collegeList" scope="page" />
       <h2><center>Student Registration Form</center> </h2>
       <%
       String content=request.getParameter("content");
       if(content.equals("captchawrong"))
           out.println("<h4><center>Your word verification is wrong .Please try again</center></h4> ");
       %>
	<form id="StSignUp" action="../SignUpEntry?content=none" method="POST">
		<table width="704" height="700" border="1" align="center" cellpadding="2" cellspacing="0" bordercolor="#3366FF">
  <tr>
  <td width="696" height="1127">
  <table width="655" height="933"  align="center" cellpadding="2" cellspacing="0" >
  <tr>
      <td width="198"><h4>Registration Id:</h4> </td>
    <td width="407" ><input name="regId" type="text" tabindex="1" size="30"  onblur="askForValidity(this.value)"/></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td><div id="availid">Please Fill Entry</div></td>
    </tr>
  <tr>
    <td><h4>Enter a password:</h4> </td>
    <td><input name="password" type="password" tabindex="2" size="30" /></td>
    </tr>
  <tr>
      <td><h4>Re-enter password:</h4> </td>
    <td><input name="cpassword" type="password" tabindex="2" size="30" /></td>
    </tr>
  <tr>
    <td><h4>First Name: </h4></td>
    <td><input name="fname" type="text" size="30" /></td>
    </tr>
  <tr>
    <td><h4>Middle Name: </h4></td>
    <td><input name="mname" type="text" size="30" /></td>
    </tr>
  <tr>
      <td ><h4>Last Name:</h4> </td>
    <td><input name="lname" type="text" size="30" /></td>
    </tr>
   <tr>
    <td ><h4>College/Institution Name:</h4> </td>
	 <%
         	String str[]=collegeList.getCollegeName();
      %>
    <td><select name="collegeList" size="1" class="pqr">
      <option selected="selected">Select College</option>
	  <%
            	for(int i=0;i<str.length;i++){
            %>
	  <option><%=str[i]%></option>
	   <%
               }
             %>
    </select>    </td>
    </tr>
  <tr>
    <td ><h4>Enroll Number:</h4> </td>
    <td><input name="enroll" type="text" size="30" />       
    </tr>
  <tr>
    <td >&nbsp;</td>
    <td>This enroll number is unique number given by your institution/college during enrollment</td>
  </tr>
  <tr>
    <td ><h4>Email Id: </h4></td>
    <td><input name="email" type="text" size="30" /></td>
    </tr>
  <tr>
    <td><h4>Security question:</h4> </td>
    <td><p>
        <input name="secQuest" type="text" value="Enter a question..." size="30" />
      </p>     </tr>
  <tr>
    <td>&nbsp;</td>
    <td>if u forget your password we will ask this question <a href="#">Read More</a></td>
  </tr>
  <tr>
    <td ><h4>Answer:</h4> </td>
    <td><input name="secAns" type="text" value="Enter you answers" size="30" /></td>
    </tr>
 <tr>
   <td ><h4>Word verification</h4> </td>
   <td>Type the characters you see in the picture below </td>
 </tr>
 <tr>
   <td >&nbsp;</td>
   <td><img src="Cap.jsp" alt="can't load from server"></td>
 </tr>
 <tr>
   <td >&nbsp;</td>
   <td><input name="code" type="text" size="30"></td>
 </tr>
 <tr>
   <td >&nbsp;</td>
   <td>Letters are case-sensitive </td>
 </tr>
 <tr>
   <td ><h4>Terms of Services:</h4></td>
   <td><textarea name="textarea" cols="40">Job Portal
Welcome to Job Portal!
Terms of Service
1. Your relationship with Job Portal 1.1 Your use of Job Portal&rsquo;s products,
software, services and web sites (referred to collectively as the
&quot;
 </textarea></td>
 </tr>
 <tr>
   <td height="57">&nbsp;</td>
   <td>By clicking 'I accept my account' button below you are agreeing our <a href="#">Terms &amp; Policies</a> </td>
 </tr>
 <tr>
   <td height="57">&nbsp;</td>
   <td><input type="submit" value="I Accept Create My Account" name="sb"  /></td>
 </tr>
</table>  </td>

  
  </tr>
</table>

	</form>
     <div class ="footer">

    </div>
     	</body>
</html>