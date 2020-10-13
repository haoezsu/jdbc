package testdb;

import java.sql.Date;

public class App1 {
    public static void main(String[] args)
    {
     java.sql.Date datum = new Date(System.currentTimeMillis());
     invoices a = new invoices(1, datum, 25421, "Test", true);
     InvoiceDaoImpl in = new InvoiceDaoImpl();

     in.addInvoices(a);
     in.getAllInvoices();
     in.updateInvoices(1, datum, 25481, "Hallo", true );
     in.deleteInvoices( 1);

     Aufgabe5 aufg = new Aufgabe5();
     aufg.addInvoices(a);
     aufg.getAllInvoices();
     aufg.updateInvoices(1, datum, 25481, "Hallo", true);
     aufg.deleteInvoices(1);




    }
}
