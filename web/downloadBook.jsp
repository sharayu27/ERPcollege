<%-- 
    Document   : downloadBook
    Created on : 17 Apr, 2015, 7:24:06 PM
    Author     : Administrator
--%>
<%@page import="java.sql.*,model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>UploadProject</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <form method="post" action="downloadBook.jsp">
<div id="page_wrapper">
  <div id="header_wrapper">
    <div id="header">
      <h1>ACCS<font color="#FFDF8C"></font></h1>
      <h2>&nbsp;</h2>
    </div>
    <div id="navcontainer">
      <ul id="navlist">
        <li><a href="index.jsp">Home </a></li>
           <li><a href="adminmenu.jsp">Back </a></li>
        
      </ul>
    </div>
  </div>
  <div id="footer"></div>
</div>
<div align=center>
  <p><a href='http://all-free-download.com/free-website-templates/'></a><form method="POST">
  
    <div align="center">Download Books <br>
        <br>
</div>
    
    <br>    <table width="200" border="0">
      <tr>
        <td>Technology</td>
        <td><label>
          <input type="text" name="tech" value=""/>
        </label></td>
      </tr>
      <tr>
        <td><label>
          <input type="submit" value="Submit" />
        </label></td>
        
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
    <br>
    <br>
	    <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    <br>
    &nbsp;&nbsp;&nbsp;&nbsp;</div>
</form> </p>
  </p>
  <p>&nbsp;</p>
  <%
try
  {
   String tech = request.getParameter("tech");
   Database db = new Database();
   Connection con = db.dataConnection();
   Statement stmt = con.createStatement();
   String str = "select * from book where technology like '%"+tech+"%'";
   ResultSet rs = stmt.executeQuery(str);
   out.println("<table border='1' align='center'>");
   out.println("<th>BookName</th><th>Technology</th><th>AuthorName</th><th>Download</th>");
   while(rs.next())
   {
      out.println("<tr><td>"+rs.getString(1)+"</td>");    
      out.println("<td>"+rs.getString(2)+"</td>");
      out.println("<td>"+rs.getString(3)+"</td>");
      out.println("<td><a href='bookdownload.jsp?name="+rs.getString(1)+" '\'>Download</a></td></tr>");  
   }
   out.println("</table>");
    }catch(Exception e)
    {
        
    }            
%>
</div>
</body>
</html>
