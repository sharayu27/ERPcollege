<%-- 
    Document   : questionUpload
    Created on : 31 Dec, 2014, 11:39:06 AM
    Author     : Administrator
--%>

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
 

        <form method="post" action="AddQuestion">
        Choose Programing Language
        <select name="prgm">
            <option value="UNKNOWN">select...</option>
            <option value="C++">C++</option>
            <option value="C">C</option>
            <option value="JAVA">JAVA</option>
            <option value="DOTNET">DOTNET</option>
        </select> <br>
        
        <input type="submit" value="Submit">
        </form>
    </body>
</html>
