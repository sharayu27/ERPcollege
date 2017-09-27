<%-- 
    Document   : downloadproj
    Created on : 10 Apr, 2015, 12:20:32 PM
    Author     : Administrator
--%>
<%@page import="model.Database"%>
<%@ page import="java.sql.*"%>


<%-- 
    Document   : questionUpload
    Created on : 31 Dec, 2014, 11:39:06 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>NewsPortal</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <form method="post" action="SelectTestType">
<div id="page_wrapper">
  <div id="header_wrapper">
    <div id="header">
      <h1>ACCS<font color="#FFDF8C"></font></h1>
      <h2>&nbsp;</h2>
    </div>
    <div id="navcontainer">
      <ul id="navlist">
        <li><a href="index.jsp">Home </a></li>
       <li><a href="usermenu.jsp">Back </a></li>
        
      </ul>
    </div>
  </div>
  <div id="footer"></div>
</div>
<div align=center>
  <p><a href='http://all-free-download.com/free-website-templates/'></a><form method="POST">
  
    <div align="center"> <br>
        <br>
</div>
    
    <br>
     <%
            try
             {
            Database db = new Database();
           Connection con=db.dataConnection();    
           Statement stmt = con.createStatement();
           String str = "select projname,technology from uploadproject";
           ResultSet rs = stmt.executeQuery(str);
           out.println("<table border='1' width='40%' align='center'>");
           out.println("<th>ProjectName</th><th>Technology</th><th>Download</th>");
           while(rs.next())
           {
              out.println("<tr><td>"+rs.getString(1)+"</td>");
              out.println("<td>"+rs.getString(2)+"</td>");
              out.println("<td><a href=downloadproject.jsp?proj="+rs.getString(2)+" '\'>Click</td></tr>");
           }
            }catch(Exception e)
            {
                
            }
            out.println("<table>");
            %>
    <br>
    <br>
	    <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    <br>
    &nbsp;&nbsp;&nbsp;&nbsp;</div>
</form> </p>
  </p>
  <p>&nbsp;</p>
</div>
</body>
</html>


