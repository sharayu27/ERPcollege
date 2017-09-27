/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Database;

/**
 *
 * @author Administrator
 */
public class CollegeTimeTable extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            String tt = null;
            String dd = null;
            String fac = null;
            
             Database db = new Database();
             Connection con = db.dataConnection();
             
             Statement stmt = con.createStatement();
         
             String ret = "Select * from timetable";
              ResultSet rs = stmt.executeQuery(ret);
              while(rs.next())
              {
                  tt = rs.getString(1);
                  dd = rs.getString(2);
                  fac = rs.getString(4);
              }
              
             String ttime = request.getParameter("time");
             String days = request.getParameter("days");
             String subj = request.getParameter("subj");
             String fact = request.getParameter("fact");
             
             if((tt.equals(ttime)) && (dd.equals(days) && (fac.equals(fact))))
             {
                 out.println("Already time and days are allocated to factulty");
             }
             else
             {
             String str = "insert into timetable value(?,?,?,?)";
             PreparedStatement ps = con.prepareStatement(str);
             ps.setString(1,ttime);
             ps.setString(2,days);
             ps.setString(3,subj);
             ps.setString(4,fact);
             
             boolean ins = ps.execute();
             if(ins=true)
             {
                 response.sendRedirect("timetablecoll.jsp?success");
             }
             ps.close();
             }
        }catch(Exception e) {            
            out.close();
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
