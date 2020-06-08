package servlet;
import test.testjpa.domain.Department;
import test.testjpa.domain.Employee;
import test.testjpa.jpa.JpaTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet (name= "employeeRecords" ,
        urlPatterns={ "/employeeRecords" })
public class EmployeeRecords extends HttpServlet {
    private EntityManager manager ;
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp )
            throws ServletException, IOException {
        EntityManagerFactory factory =
                Persistence. createEntityManagerFactory ( "example" );
        manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            this.createEmployees();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        resp .setContentType( "text/html" );
        PrintWriter out = resp.getWriter();
        out .println( "<HTML>\n <meta charset=\"UTF-8\">\n<BODY>\n" +
                "<H1>Liste des employés</H1>\n<table><th>Id</th><th>Name</th><th>Department</th>");
        for(Employee record : this.listEmployees())
        {
            out.println("<tr>");
                out.println("<td>");
                     out .println( record.getId() );
                out.println("</td>");
                out.println("<td>");
                    out .println( record.getName() );
                out.println("</td>");
                out.println("<td>");
                    out .println( record.getDepartment().getName() );
                out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        manager.close();
        System. out .println( ".. done" );
    }
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp )
            throws ServletException, IOException {
// TODO Auto-generated method stub
        super .doPost( req , resp );
    }

    public void createEmployees() {
        int numOfEmployees = manager .createQuery( "Select a From Employee a" ,
                Employee. class ).getResultList().size();
        if (numOfEmployees == 0) {
            Department department = new Department( "java" );
            manager .persist(department);
            manager .persist( new Employee( "Jakab Gipsz" ,department));
            manager .persist( new Employee( "Captain Nemo" ,department));
        }
    }
    public List<Employee> listEmployees() {
        List<Employee> resultList = manager .createQuery( "Select a From Employee a" ,
                Employee. class ).getResultList();
        return resultList;
    }
}