package com.kainos.ea.resources;

import com.kainos.ea.EmployeesDB;

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
    @Path("/reportEmployeeDetails")
    @Produces(MediaType.APPLICATION_JSON)
    public String reportEmployeeDetails() {
        String result = String.join("\n ", EmployeesDB.getEmployees());
        return result;
    }

    @POST
    @Path("/print")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String sendMsg(Message message) {
        return "Hello from a RESTful Web service: " + message.getText();
    }
}
