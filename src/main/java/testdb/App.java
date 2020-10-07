package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select Marke,Reichweite from tabelle");
            while(rs.next())
                System.out.println(rs.getString("Marke")+"  "+rs.getInt("Reichweite"));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}