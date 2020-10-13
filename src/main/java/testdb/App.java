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

        showInvoices();

       /* try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from invoice");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}*/
    }

    static Connection con;
    static Statement stmt;
    public static void conDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            App.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "");
            App.stmt = App.con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void showInvoices(){
            conDatabase();
            try{
                ResultSet rs= App.stmt.executeQuery("select * from invoice");
                while(rs.next())
                    System.out.println(rs.getInt(1)+"  "+rs.getString(3));
                con.close();
            }catch(Exception e){ System.out.println(e);}
    }

    /*public static void insertInvoice(Date date, String description, double value, Boolean paid){

    }
    public static void updateInvoice(int id, Date date, String description, double value, Boolean paid){

    }
    public static void deleteInvoice(int id){

    }
*/



}