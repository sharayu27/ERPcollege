/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

public class DotNetprogram {
     public boolean insert(String question,String ans1,String ans2,String ans3,String ans4,int marks,String crtans)
    {
        try
        {
        Database db = new Database();
        Connection con  = db.dataConnection();
        String str = "insert into dnet values(?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(str);
        ps.setString(1,question);
        ps.setString(2,ans1);
        ps.setString(3,ans2);
        ps.setString(4,ans3);
        ps.setString(5,ans4);
        ps.setInt(6,marks);
        ps.setString(7,crtans);
        
         boolean exe = ps.execute();
         if(exe = true)
         {
             System.out.println("Data is inserted");
         }
         ps.close();
         con.close();
        }catch(Exception e)
        {
            
        }
        return true;
    }
}
