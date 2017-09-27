<%-- 
    Document   : retrieveVideo
    Created on : 29 Dec, 2014, 12:00:22 PM
    Author     : Administrator
--%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.*,model.Database" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        try{
            InputStream is = null;
            byte[] vi = new byte[1024*1024*2];
            int size = 0;
    //String from = request.getParameter("from");
    //String to = request.getParameter("to");
    
    Database db = new Database();
    Connection con = db.dataConnection();
    
    Statement stmt = con.createStatement();
    String str = "Select * from uploadvideo where vid=1";;
    ResultSet rs = stmt.executeQuery(str);
    /*out.println("<html>");
    out.println("<body>");
    out.println("<form>");
    out.println("<table border='1' width='40%'>");
    out.println("<th>EventName</th><th>Event Date</th>");
 * */
    if(rs.next())
    {
        String vname = rs.getString(3);
       is = rs.getBinaryStream(1);
       response.reset();
       
        out.println(vname);
    String val = null;
    if(vname.contains(".mp4"))
    {
        val = "mp4";
    }
       else if(vname.contains(".flv"))
       {
          val = "flv";
       }
       else if(vname.contains(".avi"))
       {
          val = "avi";
       }
    else
        {
          val= "3gp";
        }
    
    
      
      while((size=is.read(vi))!= -1)
        {
          //response.getOutputStream().write(vi,0,size);
         
         if("mp4".equals(val))
    
          {
        %>
          
             <video width="320" height="240" controls>
                 <% 
                  response.setContentType("video/val");
                  response.addDateHeader("Expires", 0);
                  response.getOutputStream().write(vi,0,size);
               %>
    Your browser does not support the video tag.
</video>
        <%
       }
       
       else if("avi".equals(val))
      
        {
            %>
          <video width="320" height="240" controls>
                   <% 
                   response.setContentType("video/val");
                   response.addDateHeader("Expires", 0);
                  response.getOutputStream().write(vi,0,size);
               %>
 
  Your browser does not support the video tag.
</video>
          <%
        }
   
    else
   
               {
           %>
        
        <video width="320" height="240" controls>
    <%  
     response.setContentType("video/val");
     response.addDateHeader("Expires", 0);
                  response.getOutputStream().write(vi,0,size);
               %>
 
  Your browser does not support the video tag.
</video>
           <%
               }
        %>
        <%
        } 
    %>
    <% 
       }
    %>
    <%
      }catch(Exception e)
                    {
          out.println(e);
}
%>
    </body>
</html>
