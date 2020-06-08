package jpa;

import test.testjpa.domain.Department;
import test.testjpa.domain.Employee;
import test.testjpa.domain.SondageFils;
import test.testjpa.domain.SondagePrincipal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.Date;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
 		Employee emp0 = new Employee("ibrahim");
		Employee emp1 = new Employee("mohamed");
		Employee emp2 = new Employee("hassan");
		Department dept0 = new Department("Informatique");
		Department dept1 = new Department("Civile");
		Department dept2 = new Department("Telecom");
		manager.persist(dept0);
		manager.persist(dept1);
		manager.persist(dept2);
		emp0.setDepartment(dept0);
		emp1.setDepartment(dept1);
		emp2.setDepartment(dept2);
		manager.persist(emp0);
		manager.persist(emp1);
		manager.persist(emp2);
		SondageFils sf0 = new SondageFils("sondageFils0",new Date(), "Rennes");
		manager.persist(sf0);
		SondageFils sf1 = new SondageFils("sondageFils1",new Date(), "Nantes");
		manager.persist(sf1);
		SondageFils sf2 = new SondageFils("sondageFils2",new Date(), "Rennes");
		manager.persist(sf2);
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
