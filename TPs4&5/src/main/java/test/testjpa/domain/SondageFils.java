package test.testjpa.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class SondageFils extends SondagePrincipal
{
    @Temporal(TemporalType.DATE)
    @Column(name = "dateSondage")
    private Date date;
    @Column(name = "lieu",length=40)
    private String lieu;

    public SondageFils(Date date, String lieu) {
        this.date = date;
        this.lieu = lieu;
    }
    public SondageFils(){}
    public SondageFils(String intitule, Date date, String lieu) {
        super(intitule);
        this.date = date;
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}
