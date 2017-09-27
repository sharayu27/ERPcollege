<%@page import="model.Database"%>
<%@ page import="java.sql.*"%>

<%@ page import="java.io.*"%>

<%

	
	
	Blob file1= null;
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
		
  
  
	
	try
	{
            String name = request.getParameter("name");
            Database db = new Database();
		 con=db.dataConnection();

		ps = con.prepareStatement("select * from book where bname = '"+name+"'");
		rs = ps.executeQuery();
		while(rs.next())
		{
		file1=rs.getBlob(4);
		
		}
		int len1=(int)file1.length();
		
		
		//session.setAttribute("resumeBlob1",file1);
		byte[] ba = file1.getBytes(1, (int)file1.length());
		String filename="File";
			   
			response.setContentType("application/zip");
			response.setHeader("Content-Disposition","attachment; filename=\""+filename+"\"");
			OutputStream os = response.getOutputStream();
			
			
			os.write(ba);
			

			os.close();
				//response.sendRedirect("index.html");
	
	}
	
	
		catch(Exception e)
	{
	System.out.println("Exception :"+e);
	}

	
	%>