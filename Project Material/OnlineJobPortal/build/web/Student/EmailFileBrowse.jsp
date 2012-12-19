<%-- 
    Document   : EmailFileBrowse
    Created on : May 29, 2011, 8:28:15 PM
    Author     : RAGHU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <script language="javascript" type="text/javascript">
<!--

var NumOfRow=5;

function add()
{
NumOfRow++;

// get the refference of the main Div
var mainDiv=document.getElementById('MainDiv');

// create new div that will work as a container
var newDiv=document.createElement('div');
newDiv.setAttribute('id','innerDiv'+NumOfRow);

//create span to contain the text
var newSpan=document.createElement('span');
newSpan.innerHTML="File: "+NumOfRow;

// create new textbox for email entry
var newTextBox=document.createElement('input');
newTextBox.type='file';
newTextBox.setAttribute('name','txtAddr'+NumOfRow);

// create remove button for each email adress

var newButton=document.createElement('input');
newButton.type='button';
newButton.value='Remove';
newButton.id='btn'+NumOfRow;

// atach event for remove button click
newButton.onclick=function RemoveEntry() { var mainDiv=document.getElementById('MainDiv');
mainDiv.removeChild(this.parentNode);
}

// append the span, textbox and the button
newDiv.appendChild(newSpan);
newDiv.appendChild(newTextBox);
newDiv.appendChild(newButton);

// finally append the new div to the main div
mainDiv.appendChild(newDiv);

}
// -->
</script>

           

      
    </head>
    <body>
          <jsp:include page="Header.jsp" />
      <form action="AllEmail.jsp" method="POST">
          <pre>
          File1:<input type="file" name="file1" value="" />
          File2:<input type="file" name="file2" value="" />
          File3:<input type="file" name="file3" value="" />
          File4:<input type="file" name="file4" value="" />
          File5:<input type="file" name="file5" value="" />
          </pre>
<div id="MainDiv">

    <pre>                      <input id="Button1" type="button" value="Add More" onclick="add()" /></pre>

</div>
          <pre>                    <input type="submit" value="Done Uploading "></pre>
</form>
    </body>
</html>
