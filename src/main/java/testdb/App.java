package testdb;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        showInvoices();
        Date datum = new Date(System.currentTimeMillis());
        //insertInvoice( datum,  "description",  1234, true);
        updateInvoice( 2, datum,  "description",  5000, true);

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
    public static void conDatabase() {  //connection zum Database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            App.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "");
            App.stmt = App.con.createStatement();   //create statement
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

    public static void insertInvoice(Date date, String description, double value, Boolean paid){
        conDatabase();
        try{
            Statement state = con.createStatement();
            String sql = "insert into invoice"
                    + "(date, description, value, paid)"
                    + "values ('"+date +"' ,'"+description+"', '"+value+"', '"+paid+"')";
            state.executeUpdate(sql);
        } catch (Exception e)
        {
            System.out.println(e);
        }


        System.out.println("Insert complete.");
    }
    public static void updateInvoice(int id, Date date, String description, double value, Boolean paid){
        conDatabase();
        try{
            Statement state = con.createStatement();
            String sql = "update invoice"
                    + " set date = this.date "
                    + "where id = this.id";
            state.executeUpdate(sql);
        } catch (Exception e)
        {
            System.out.println(e);
        }

        System.out.println("Update complete.");
    }
    public static void deleteInvoice(int id){
        conDatabase();
        try{
            Statement state = con.createStatement();
            String sql = "delete * from invoice"
                    + "where id = this.id";
            state.executeUpdate(sql);
        } catch (Exception e)
        {
            System.out.println(e);
        }

        System.out.println("Delete complete.");
    }
    

}