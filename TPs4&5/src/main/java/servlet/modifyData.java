/*package servlet;

import test.testjpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "modifyData" ,
        urlPatterns={ "/modifyData/{id}" })
public class modifyData extends HttpServlet
{
    private EntityManager manager ;

    protected void doGet(HttpServletRequest req , HttpServletResponse resp )
            throws ServletException, IOException {
        EntityManagerFactory factory =
                Persistence. createEntityManagerFactory ( "example" );
        manager = factory.createEntityManager();
        String id = req.getParameter("id");
        Employee emp = getEmployee(id);

        req.setAttribute("employeeName", emp.getName());
        req.setAttribute("employeeDept", emp.getDepartment());

        req.getRequestDispatcher("ajoutEmployee.html").forward(req, resp);
    }

    public Employee getEmployee(String id)
    {
        return manager .createQuery( "Select a From Employee a WHERE a.id = "+id ,
                Employee. class ).getResultList().get(0);
    }
}*/
