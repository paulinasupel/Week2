package com.kainos.ea.resources;

import com.kainos.ea.EmployeesDB;
import com.kainos.ea.employee_stuff.Employee;
import com.kainos.ea.employee_stuff.SalesEmployee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api")
public class WebService {

    @GET
    @Path("/print/{msg}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMsg(@PathParam("msg") String message) {
        return "Hello from a RESTful Web service: " + message;
    }

    @GET
    @Path("/reportSalesEmployeeDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> reportSalesEmployeeDetails() {
        //String result = "";
        //for (City c : CitiesDB.getCities()) {
        //    result += c.getName() + ", \n";
        //}
        return EmployeesDB.getSalesEmployees();
    }

    @GET
    @Path("/reportDeliveryEmployeeDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> reportDeliveryEmployeeDetails() {
        //String result = "";
        //for (City c : CitiesDB.getCities()) {
        //    result += c.getName() + ", \n";
        //}
        return EmployeesDB.getDeliveryEmployees();
    }

    @GET
    @Path("/reportEmployeeDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> reportEmployeeDetails() {
        return EmployeesDB.getEmployees();
    }

    @POST
    @Path("/addEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertEmployee(Employee employee) {
        return EmployeesDB.insertEmployees(employee);
    }

    @POST
    @Path("/addSalesEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertSalesEmployee(SalesEmployee employee) {
        return EmployeesDB.insertESalesEmployees(employee);
    }

    @POST
    @Path("/print")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String sendMsg(Message message) {
        return "Hello from a RESTful Web service: " + message.getText();
    }
}
