<%-- 
    Document   : New_Registration
    Created on : May 24, 2011, 9:29:36 AM
    Author     : Navin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            var reqObj;
             chosen = "";
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
                        document.getElementById('availid').innerHTML="Please Fill Entry...";
                        alert("regId field cannot be empty");
                        return false;
                    }
                getReqObject();
                
                if(reqObj==null )
                    {
                        alert("Browser Does not Supports Ajax!!!");
                        return false;
                    }
                    getSelectedItem();
                try
                {
                    reqObj.onreadystatechange=recFun;
                    reqObj.open("POST","../AdminAddAjax?regId=" + str+"&selected="+chosen,true);
                    reqObj.send();

                }
                catch(e)
                {
                    alert("Could Not Connect To Server!!!");
                    return false;
                }
            }
    
         function getSelectedItem() {

           
            len = document.f1.newreg.length

            for (i = 0; i <len; i++) {
                if (document.f1.newreg[i].checked) {
                    chosen = document.f1.newreg[i].value
                }
            }

            if (chosen == "") {
                alert("No Location Chosen")
            }
        }

    </script>
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <form id="f1" name="f1" action="../NewRegServ" method="POST">
            <pre>
                Select Registration Type

                <input type="radio" name="newreg" value="Company"  />Company
                <input type="radio" name="newreg" value="College" checked="checked" />College

                Enter Registration Id  <input type="text" name="regId" value="" onblur="askForValidity(this.value)" />   <div id="availid">Please Fill Entry</div>
                Enter Password         <input type="password" name="password" value="" />
                Confirm Password       <input type="password" name="cpassword" value="" />

                <input type="submit" value="Submit" name="Submit" />
            </pre>
        </form>
    </body>
</html>
