/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class AddQuestionAnswer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Database db = new Database();
             Connection con = db.dataConnection();
             
             String ques = request.getParameter("ques");
             String ans1 = request.getParameter("ans1");
             String ans2 = request.getParameter("ans2");
             String ans3 = request.getParameter("ans3");
             String ans4 = request.getParameter("ans4");
             int marks = Integer.parseInt(request.getParameter("marks"));
             String crtans = request.getParameter("crtans");
             
             ServletContext context = getServletContext();
             String pr = (String)context.getAttribute("prgm");
             
             if(pr.equals("C"))
             {
                 out.println(pr);
                 CPprogram c = new CPprogram();
                 boolean b = c.insert(ques,ans1,ans2,ans3,ans4,marks,crtans);
                 if(b=true)
                 {
                     response.sendRedirect("addquestion.jsp");
                 }
                 else
                 {
                     out.println("Please try again");
                 }
             }
             else if(pr.equals("C++"))
             {
                 out.println(pr);
                 CPlusprogram cpp = new CPlusprogram();
                 boolean b = cpp.insert(ques,ans1,ans2,ans3,ans4,marks,crtans);
                 if(b=true)
                 {
                     response.sendRedirect("addquestion.jsp");
                 }
                 else
                 {
                     out.println("Please try again");
                 }
             }
             else if(pr.equals("JAVA"))
             {
                 out.println(pr);
                 Javaprogram jp = new Javaprogram();
                 boolean b = jp.insert(ques,ans1,ans2,ans3,ans4,marks,crtans);
                 if(b=true)
                 {
                     response.sendRedirect("addquestion.jsp");
                 }
                 else
                 {
                     out.println("Please try again");
                 }
             }
             else
             {
                 out.println(pr);
                 DotNetprogram dn = new DotNetprogram();
                 boolean b = dn.insert(ques,ans1,ans2,ans3,ans4,marks,crtans);
                 if(b=true)
                 {
                     response.sendRedirect("addquestion.jsp");
                 }
                 else
                 {
                     out.println("Please try again");
                 }
             }
                 
             
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
