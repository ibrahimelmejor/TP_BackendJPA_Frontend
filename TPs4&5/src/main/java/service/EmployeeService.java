package service;

import test.testjpa.domain.Department;
import test.testjpa.domain.Employee;
import test.testjpa.dto.EmployeeDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeService {
    private EntityManager manager ;
    public EmployeeService()
    {
        EntityManagerFactory factory =
                Persistence. createEntityManagerFactory ( "example" );
        manager = factory.createEntityManager();
    }
    public List<Employee> listEmployees() {

        List<Employee> resultList = manager .createQuery( "Select a From Employee a" ,
                Employee. class ).getResultList();
        return resultList;
    }

    public void addEmployee(EmployeeDto employee)
    {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Department department = new Department( employee.getDepartment() );

        manager.persist( department);
        manager.persist( new Employee( employee.getName() ,department));
        tx.commit();
    }
}
