package servlet;

import test.testjpa.domain.Department;
import test.testjpa.domain.Employee;
import test.testjpa.jpa.JpaTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "ajoutEmployee" ,
        urlPatterns={ "/ajoutEmployee" })
public class AjoutEmployee extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp )
            throws ServletException, IOException {
        req.getRequestDispatcher("ajoutEmployee.html").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp )
            throws ServletException, IOException {
        String employee = req.getParameter("nomEmploye");
        String departement = req.getParameter("nomDepartement");
        Department department = new Department( departement );
        EntityManagerFactory factory =
                Persistence. createEntityManagerFactory ( "example" );
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(department);
        manager.persist( new Employee( employee ,department));
        tx.commit();
        resp.sendRedirect( "/employeeRecords");
    }
}
