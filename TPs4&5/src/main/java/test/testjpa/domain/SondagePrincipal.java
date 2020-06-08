package test.testjpa.domain;


import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_ENTITE")
public class SondagePrincipal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSondage")
    int idSondage;

    @Column(name = "intitule",length=40)
    String intitule;

    public SondagePrincipal(){}

    public SondagePrincipal(String intitule)
    {
        this.intitule = intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getIntitule() {
        return intitule;
    }
}
