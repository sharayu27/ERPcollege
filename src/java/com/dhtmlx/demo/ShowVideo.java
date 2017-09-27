/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhtmlx.demo;

import java.io.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class ShowVideo extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
String filename = "D:\\bas.mp4"; //my own filename 
//you can write http://localhost 
//String filepath = "C:/"; //located on Local C harddisk 

BufferedInputStream buf = null; 

try { 


File myfile = new File( filename); 

//set response headers 
response.setContentType("application"); //I want to play a video file 

//response.addHeader("Content-Disposition", "attachment; filename=" + filename); 

response.setContentLength((int) myfile.length()); 

FileInputStream input = new FileInputStream(myfile); 
buf = new BufferedInputStream(input); 
int readBytes = 0; 

//read from the file; write to the ServletOutputStream 
while ((readBytes = buf.read()) != -1) { 
out.write(readBytes); 
} 

} catch (IOException ioe) { 
} finally { 


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
