package testdb;

import java.sql.Date;
import java.util.List;

interface Daointerface
{


    public List getAllInvoices();
    public void updateInvoices(int id, Date datum, int value, String description, boolean paid);
    public void deleteInvoices(int id);
    public void addInvoices(invoices a);





}
