<%-- 
    Document   : addquestion
    Created on : Sep 13, 2014, 7:57:49 PM
    Author     : Admin
--%>
<%
    String str = (String)application.getAttribute("prgm");
    out.println(str);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>NewsPortal</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="css/style.css" type="text/css" rel="stylesheet" />
<style type="text/css">
<!--
.style1 {
	font-size: 36px;
	font-weight: bold;
}
-->
</style>
</head>
<body>
<div id="page_wrapper">
  <div id="header_wrapper">
    <div id="header">
      <h1>ACCS <font color="#FFDF8C"></font></h1>
      <h2>&nbsp;</h2>
    </div>
    <div id="navcontainer">
      <ul id="navlist">
	  	<li><a href="index.jsp">Home</a></li>
       <li><a href="usermenu.jsp">Back </a></li>	
	
		
      </ul>
    </div>
  </div>
  <div id="footer">
    <div align="center"></div>
  </div>
  <div align="center" class="style1"></div>
</div>
<div align=center>
  <p>
  <div align="center" class="style1">WELCOME TO STUDENT PROFILE</div>
 

    <body>
        <form method="post" action="AddQuestionAnswer">
            Question: <textarea name="ques"></textarea><br>
            Answer1 : <textarea name="ans1"></textarea><br>
            Answer2 : <textarea name="ans2"></textarea><br>
            Answer3 : <textarea name="ans3"></textarea><br>
            Answer4 : <textarea name="ans4"></textarea><br>
            Select Marks : <select name="marks">
                <option value="UNKNOWN">select marks....</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select><br>
            CorrectAnswer : <textarea name="crtans"></textarea><br><br>
                    <input type="submit" value="Add" style="width: 105px"/>
            <input type="reset" value="ClearAll"/>
        </form>
    </body>
</html>
