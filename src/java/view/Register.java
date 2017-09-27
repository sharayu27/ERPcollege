/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import model.Database;

public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
       Database db = new Database();
       Connection con = db.dataConnection();
       
       String uname = request.getParameter("uname");
       String pass = request.getParameter("pass");
       String gender = request.getParameter("gender");
       String mno = request.getParameter("mno");
       String email = request.getParameter("email");
       String   hno = request.getParameter("hno");
          String sname = request.getParameter("sname");
         String city = request.getParameter("city");
         String state = request.getParameter("state");
        String country = request.getParameter("country");
       String pcode = request.getParameter("pcode");   
       
       String str = "insert into registration values(?,?,?,?,?,?,?,?,?,?,?)";
       PreparedStatement ps = con.prepareStatement(str);
       ps.setString(1,uname);
       ps.setString(2,pass);
       ps.setString(3,gender);
       ps.setString(4,mno);
       ps.setString(5,email);
       ps.setString(6,hno);
       ps.setString(7,sname);
       ps.setString(8,city);
       ps.setString(9,state);
       ps.setString(10,country);
       ps.setString(11,pcode);
       
       boolean b = ps.execute();
       if(b=true)
       {
           response.sendRedirect("userlogin.jsp?success");
       }
       else
       {
           out.println("Fail to Insert press back button");
       }
        }catch(Exception e) {            
            out.println("Error insertion " +e);
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
