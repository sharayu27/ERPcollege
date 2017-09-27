/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Database;
import java.sql.*;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig(maxFileSize=16177215)
public class UploadVideo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
              int vid = 0;
              InputStream is = null;
              try
              {
                  vid = Integer.parseInt(request.getParameter("vid"));
              }catch(NumberFormatException ne)
              {
                  
              }
              String cate = request.getParameter("cate");
              String vname = request.getParameter("vname");
              String video = request.getParameter("video");
              
               Database db = new Database();
               Connection con = db.dataConnection();
               
               Part partFile = request.getPart("video");
                if (partFile != null) {
            // prints out some information for debugging
            System.out.println(partFile.getName());
            System.out.println(partFile.getSize());
            System.out.println(partFile.getContentType());
             
            // obtains input stream of the upload file
            is = partFile.getInputStream();
        }
         
               
             //  String upvideo = System.getProperty("user.home")+File.separatorChar+video;
             
            //   FileInputStream fis = new FileInputStream(upvideo);
               
               String str = "insert into uploadvideo values (?,?,?,?)";
               PreparedStatement ps = con.prepareStatement(str);
               
               ps.setInt(1, vid);
               ps.setString(2,cate);
               ps.setString(3,vname);
              // ps.setBinaryStream(4,fis,fis.available());
               
               if (is != null) {
                // fetches input stream of the upload file for the blob column
                ps.setBlob(4, is);
            }
              
               boolean exec = ps.execute();
               if(exec = true)
               {
                  response.sendRedirect("adminmenu.jsp?sucess");
               }
               
               ps.close();
               con.close();
        } catch(Exception e)
        {            
            out.println("Problem in Upload please try again : " +e);
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
