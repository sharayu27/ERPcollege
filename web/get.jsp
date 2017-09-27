<%@page language="java" import ="java.sql.*" %>  

<%@page import="java.sql.*,model.Database" %>
 <%  
 String name=request.getParameter("count");  
 String buffer="<div>";  
 Database db = new Database();
 Connection con = db.dataConnection();  
 Statement stmt = con.createStatement();  
 ResultSet rs = stmt.executeQuery("Select * from uploadvideo where vid LIKE '"+name+"%'");  
   while(rs.next()){
   buffer=buffer+rs.getString(2)+"<br>";  
   }  
 buffer=buffer+"</div>";  
 response.getWriter().println(buffer);  

 %>