package testdb;

import java.sql.Date;

public class invoices {

    int id;
    Date datum = new Date(System.currentTimeMillis());
    int value;
    String description;
    boolean paid;

    public invoices(int id, Date datum, int value, String description, boolean paid)
    {
        this.id = id;
        this.datum = datum;
        this.value = value;
        this.description = description;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public Date getDatum() {
        return datum;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
