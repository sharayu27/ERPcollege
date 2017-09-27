/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Database;
import java.sql.*;
import java.util.List;

public class EventCalender extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         ServletContext context = getServletContext();
        try {
            Integer eid = 0;
            try
            {
             eid = Integer.parseInt(request.getParameter("eid"));
            }catch(NumberFormatException ne)
            {
                
            }
              String  ename = request.getParameter("ename");
              String edate = request.getParameter("edate");
              
              Date dt = Date.valueOf(edate);
              
              Database db = new Database();
              Connection con = db.dataConnection();
              
            /*  Statement stmt = con.createStatement();
              String s = "select * from events";
              ResultSet rs = stmt.executeQuery(s);
              while(rs.next())
              {
                  eid = rs.getInt(1);
               }
              eid = eid+1;
              System.out.println(eid);
              
               request.setAttribute("eid",eid);
           Integer l = (Integer)request.getAttribute("eid");
          System.out.println(l);
              */
              
             /* eid = (Integer) request.getAttribute("eid");
                System.out.println(eid);
               */ 
              String ins = "insert into events values(?,?,?)";
              PreparedStatement ps = con.prepareStatement(ins);
              ps.setInt(1, eid);
              ps.setString(2,ename);
              ps.setDate(3,dt);
              if(ins!=null)
              {
                 response.sendRedirect("adminmenu.jsp?success");
              }
              ps.execute();
              ps.close();
        } catch(Exception e) {            
            out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
