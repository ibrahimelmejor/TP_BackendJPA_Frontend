package service;

import test.testjpa.domain.SondageFils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SondageService {
    private EntityManager manager ;
    public SondageService()
    {
        EntityManagerFactory factory =
                Persistence. createEntityManagerFactory ( "example" );
        manager = factory.createEntityManager();
    }
    public List<SondageFils> findAllSurveysEntities(String intitule, String lieu) {
        CriteriaBuilder qb = manager.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<SondageFils> sondage = cq.from(SondageFils.class);

        //Constructing list of parameters
        List<Predicate> predicates = new ArrayList<Predicate>();

        //Adding predicates in case of parameter not being null
        if (intitule != null) {
            predicates.add(
                    qb.equal(sondage.get("intitule"), intitule));
        }

        if (lieu != null) {
            predicates.add(
                    qb.equal(sondage.get("lieu"), lieu));
        }
        //query itself
        cq.select(sondage)
                .where(predicates.toArray(new Predicate[]{}));
        //execute query and do something with result
        return manager.createQuery(cq).getResultList();

    }
}
