package testdb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Aufgabe5
{


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

        public void getAllInvoices()
        {

            conDatabase();
            try{
                ResultSet rs= App.stmt.executeQuery("select * from invoice");
                while(rs.next())
                    System.out.println(rs.getInt(1)+"  "+rs.getString(3));
                con.close();
            }catch(Exception e){ System.out.println(e);}



        }

        public void updateInvoices(int id, Date datum, int value, String description, boolean paid)
        {
            conDatabase();
            try{
                Statement state = con.createStatement();
                String sql = "update invoice"
                        + " set description = '"+description +"'"
                        + "where id = '"+id +"'";
                state.executeUpdate(sql);
            } catch (Exception e)
            {
                System.out.println(e);
            }

            System.out.println("Update complete.");


        }

        public void deleteInvoices(int id)
        {
            conDatabase();
            try{
                Statement state = con.createStatement();
                String sql = "delete from invoice"
                        + " where id = '"+id +"'";
                state.executeUpdate(sql);
            } catch (Exception e)
            {
                System.out.println(e);
            }

            System.out.println("Delete complete.");

        }

        public void addInvoices(invoices a)
        {
            conDatabase();
            try{
                Statement state = con.createStatement();
                String sql = "insert into invoice"
                        + "(date, description, value, paid)"
                        + "values ('"+a.getDatum() +"' ,'"+a.getDescription()+"', '"+a.getValue()+"', '"+a.isPaid()+"')";
                state.executeUpdate(sql);
            } catch (Exception e)
            {
                System.out.println(e);
            }


            System.out.println("Insert complete.");

        }


}

