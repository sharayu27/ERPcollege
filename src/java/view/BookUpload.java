/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.MultipartConfig;
import model.Database;

@MultipartConfig(maxFileSize=1122334567)
public class BookUpload extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String name = request.getParameter("name"); 
            String tech = request.getParameter("tech");
            String aname = request.getParameter("aname");
            Part book = request.getPart("book");
            InputStream is = null;
            
            Database db = new Database();
            Connection con = db.dataConnection();
            
            if(book!=null)
            {
                System.out.println("Size : " +book.getSize());
                is = book.getInputStream();
            }
            
            String str = "insert into book values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1,name);
            ps.setString(2,tech);
            ps.setString(3,aname);
            if(book!=null)
            {
                ps.setBlob(4,is);
            }
            boolean ins = ps.execute();
            if(ins=true)
            {
                response.sendRedirect("adminmenu.jsp?success");
            }
            ps.close();
            con.close();
        }catch(Exception e) {            
            out.println("Error inserting : " +e);
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
