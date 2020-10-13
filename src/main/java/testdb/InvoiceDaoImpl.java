package testdb;

import java.sql.Date;
import java.util.*;

public class InvoiceDaoImpl implements Daointerface
{
    java.sql.Date datum = new Date(System.currentTimeMillis());

    invoices i1 = new invoices( 1,  datum,  100,  "description",  true);
    invoices i2 = new invoices( 2,  datum,  400,  "Hallo",  true);
    invoices i3 = new invoices( 3,  datum,  324,  "imst",  true);
    invoices i4 = new invoices( 4,  datum,  635,  "asdfv",  false);

    ArrayList<invoices> liste = new ArrayList<>();
    public InvoiceDaoImpl()
    {


        liste.add(i1);
        liste.add(i2);
        liste.add(i3);
        liste.add(i4);

    }

    public List getAllInvoices()
    {

        for(int i = 0; i < liste.size(); i++)
        {
            System.out.println(liste.get(i));
        }

        return null;
    }

    public void updateInvoices(int id, Date datum, int value, String description, boolean paid)
    {
        liste.remove(id);
        invoices a = new invoices(id,datum,value,description,paid);
        liste.add(a);

    }

    public void deleteInvoices(int id)
    {
        liste.remove(id);
    }

    public void addInvoices(invoices a)
    {
        liste.add(a);

    }


}

