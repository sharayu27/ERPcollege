/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhtmlx.demo;


import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Database;
import java.util.*;

public class NewServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List rowValues = new ArrayList();
        try {
             String ttime = request.getParameter("time");
               String days = request.getParameter("days");
               String subj = request.getParameter("subj");
            String time=null;
            String mon=null;
            String tue=null;
            String wed=null;
            String thu=null;
            String fri=null;
            String sat=null;
            
            
               Database db = new Database();
               Connection con = db.dataConnection();
               
               Statement stm = con.createStatement();
               String str = "Select * from timetable";
               ResultSet rs = stm.executeQuery(str);
               while(rs.next())
               {
                  time = rs.getString(1);
                  mon = rs.getString(2);
                  tue = rs.getString(3);
                  wed = rs.getString(4);
                  thu = rs.getString(5);
                  fri = rs.getString(6);
                  sat = rs.getString(7);
                  
                  out.println(time);
                  out.println(mon);
                  out.println(tue);
                  out.println(wed);
                  out.println(thu);
                  out.println(fri);
                  out.println(sat);
                  
               }
               ResultSetMetaData rsm = rs.getMetaData();
               String mm = rsm.getColumnName(2);
               System.out.println(mm);
                  /* String mo = null;
                   String tt = null;
                   Statement st = con.createStatement();
                    String m = "select ttime,monday from timetable";   
                    ResultSet rm = st.executeQuery(m);
                    while(rm.next())
                    {
                        tt = rs.getString(1);
                        mo = rs.getString(2);
                        System.out.println(mo);
                    }*/
                    if(mon==null)
                    {
                        if(time.equals("9"))
                       {
                       
                               
                        Statement stmt = con.createStatement();
                     String sm = "update timetable set monday = '"+subj+"' where ttime='9'";
                     stmt.executeUpdate(sm);
                     stmt.close();
                   }
                    }
                     if(tue==null)
                    {
                         if(time.equals("9"))
                       {
                        Statement stmt = con.createStatement();
                     String sm = "update timetable set tuesday = '"+subj+"' where ttime='9'";
                     stmt.executeUpdate(sm);
                     stmt.close();
                   }
                    }
                      if(wed==null)
                    {
                         if(time.equals("9"))
                       {
                        Statement stmt = con.createStatement();
                     String sm = "update timetable set wednesday = '"+subj+"' where ttime='9'";
                     stmt.executeUpdate(sm);
                     stmt.close();
                   }
                    }
                       if(thu==null)
                    {
                         if(time.equals("9"))
                       {
                        Statement stmt = con.createStatement();
                     String sm = "update timetable set thursday = '"+subj+"' where ttime='9'";
                     stmt.executeUpdate(sm);
                     stmt.close();
                   }
                    }
                        if(fri==null)
                    {
                         if(time.equals("9"))
                       {
                        Statement stmt = con.createStatement();
                     String sm = "update timetable set friday = '"+subj+"' where ttime='9'";
                     stmt.executeUpdate(sm);
                     stmt.close();
                   }
                    }
                           if(sat==null)
                    {
                         if(time.equals("9"))
                       {
                        Statement stmt = con.createStatement();
                     String sm = "update timetable set saturday = '"+subj+"' where ttime='9'";
                     stmt.executeUpdate(sm);
                     stmt.close();
                   }
                    }
               }
       catch(Exception e) {            
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
