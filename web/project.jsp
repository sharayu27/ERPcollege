<%@page import="java.sql.*,model.Database" %>
<%
  try
   {
      Database db = new Database();
      Connection con = db.dataConnection();
      String proj = request.getParameter("proj");
      Statement stmt = con.createStatement();
      String str = "Select * from uploadproject where projname = '"+proj+"'";           
      ResultSet rs = stmt.executeQuery(str);
      
      while(rs.next())
      {
        out.println(rs.getString(1));
        out.println(rs.getString(2));
        out.println("<a href='downloadproject.jsp'>Download</a>");
      }
  }catch(Exception e)
                   {
      out.println(e);
      
  }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
    </body>
</html>
