package fr.istic.sir.rest;

import service.EmployeeService;
import test.testjpa.domain.Employee;
import test.testjpa.dto.EmployeeDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path( "/employees" )
@Consumes(MediaType. APPLICATION_JSON)
@Produces(MediaType. APPLICATION_JSON )
public class EmployeeRest
{
    EmployeeService employeeService = new EmployeeService();

    @GET
    @Path ( "/list" )
    public List<EmployeeDto>  getListEmployees() {
        List<EmployeeDto> list = new ArrayList<>();
        for (Employee itr:  employeeService.listEmployees()) {
            EmployeeDto empl = new EmployeeDto(itr.getName(), itr.getDepartment().getName());
            list.add(empl);
        }
        return  list;
    }

    @POST
    @Path ( "/add" )
    public void addEmployee(EmployeeDto employee)
    {
        employeeService.addEmployee(employee);
    }

}
