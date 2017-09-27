<%@page import="java.sql.*,model.Database"%>
<%! int eid; %>
<%
  
   Database db = new Database();
              Connection con = db.dataConnection();
              
              Statement stmt = con.createStatement();
              String s = "select * from events";
              ResultSet rs = stmt.executeQuery(s);
              while(rs.next())
              {
                  eid = rs.getInt(1);
               }
              eid = eid+1;
              application.setAttribute("eid",eid);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>NewsPortal</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
     <form method="post" action="EventCalender">
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
  
    <div align="center">Add Questions <br>
        <br>
</div>
   
    <br>
    <table width="200" border="1">
      <tr>
        <td>EventId</td>
        <td><label>
           <input type="text" name="eid" value="<%= eid %>" readonly="true"/></td>
        </label></td>
      </tr>
      <tr>
        <td>EventName</td>
        <td> <input type="text" name="ename" value=""/></td>
      </tr>
      <tr>
        <td>StartDate </td>
        <td><input type="text" name="edate" value=""/>(yyyy-mm-dd)</td>
      </tr>
      
      <tr>
        <td><label>
          <input type="submit" value="Add" />
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
</div>
</body>
</html>
