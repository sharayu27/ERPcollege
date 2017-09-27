package model;

import java.sql.*;

public class Database {

    Connection con;
    public Connection dataConnection()
    {
    try
    {
        
 Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpcollege","root","root");
        System.out.println("Database is connected");
    }catch(Exception e)
    {
        System.out.println("Fail to connect with database"+e);
    }
        return con;   
}
}
