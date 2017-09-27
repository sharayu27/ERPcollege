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

public class TimeInsert extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
               String time = request.getParameter("time");
               String days = request.getParameter("days");
               String subj = request.getParameter("subj");
               String tt = null;
               String ddm = null;
               String ddt = null;
               String ddw = null;
               String ddth = null;
               String ddf= null;
               String dds = null;
               
               String sub = null;
               
               Database db = new Database();
               Connection con = db.dataConnection();
               
               Statement stm = con.createStatement();
               String str = "Select ttime,monday,tuesday,wednesday,thursday,friday,saturday from timetable";
               ResultSet rs = stm.executeQuery(str);
               while(rs.next())
               {
                   tt = rs.getString(1);
                   ddm = rs.getString(2);
                   ddt = rs.getString(3);
                   ddw = rs.getString(4);
                   ddth = rs.getString(5);
                   ddf = rs.getString(6);
                   dds = rs.getString(7);
                  System.out.println(tt);
                  System.out.println(ddm);
                  System.out.println(ddt);
                  System.out.println(ddw);
                  System.out.println(ddth);
                  System.out.println(ddf);
                   System.out.println(dds);
               }
               ResultSetMetaData rsmd = rs.getMetaData();
               String ttime = rsmd.getColumnName(1);
               String mon = rsmd.getColumnName(2);
               String tue = rsmd.getColumnName(3);
               String wed = rsmd.getColumnName(4);
               String thu = rsmd.getColumnName(5);
               String fri = rsmd.getColumnName(6);
               String sat = rsmd.getColumnName(7);
               System.out.println(mon);
               System.out.println(tue);
               System.out.println(wed);
               System.out.println(thu);
               System.out.println(fri);
               System.out.println(sat);
               
              
           if((time.equals(tt))) 
               {
                   if(ddm==null)
                   {
                 
                      String up = "update timetable set ttime='"+tt+"',monday='"+subj+"' where ttime='"+tt+"'";
                      int exec = stm.executeUpdate(up);
                      if(exec!=0)
                      {
                          out.println("value is updated");
                      }
                      else
                      {
                          out.println("value is not updated");
                      }
                  }
                  else if(ddt==null)
                   {
                       String up = "update timetable set ttime='"+tt+"',monday='"+subj+"' where ttime='"+tt+"'";
                      int exec = stm.executeUpdate(up);
                      if(exec!=0)
                      {
                          out.println("value is updated");
                      }
                      else
                      {
                          out.println("value is not updated");
                      }
                   }
                  else if(ddw==null)
                   {
                       String up = "update timetable set ttime='"+tt+"',monday='"+subj+"' where ttime='"+tt+"'";
                      int exec = stm.executeUpdate(up);
                      if(exec!=0)
                      {
                          out.println("value is updated");
                      }
                      else
                      {
                          out.println("value is not updated");
                      }
                   }
                  else if(ddth==null)
                   {
                       String up = "update timetable set ttime='"+tt+"',monday='"+subj+"' where ttime='"+tt+"'";
                      int exec = stm.executeUpdate(up);
                      if(exec!=0)
                      {
                          out.println("value is updated");
                      }
                      else
                      {
                          out.println("value is not updated");
                      }
                   }
                  else if(ddf==null)
                   {
                       String up = "update timetable set ttime='"+tt+"',monday='"+subj+"' where ttime='"+tt+"'";
                      int exec = stm.executeUpdate(up);
                      if(exec!=0)
                      {
                          out.println("value is updated");
                      }
                      else
                      {
                          out.println("value is not updated");
                      }
                   }
                  else if(dds==null)
                   {
                       String up = "update timetable set ttime='"+tt+"',monday='"+subj+"' where ttime='"+tt+"'";
                      int exec = stm.executeUpdate(up);
                      if(exec!=0)
                      {
                          out.println("value is updated");
                      }
                      else
                      {
                          out.println("value is not updated");
                      }
                   }
                   else
                   {
                       out.println("Record Full");
                   }
               }
               
        } catch(Exception e) {            
            out.println("Error :" +e);
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
