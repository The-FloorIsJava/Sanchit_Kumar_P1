package com.revature.P1SanchitKumar.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.P1SanchitKumar.DAO.RequestsDAO;
import com.revature.P1SanchitKumar.Models.Requests;
import com.revature.P1SanchitKumar.Service.LoginService;
import com.revature.P1SanchitKumar.Service.RequestsService;
import com.revature.P1SanchitKumar.Util.DTO.CreateEmployeeCredentials;
import com.revature.P1SanchitKumar.Util.DTO.CreateTicket;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.List;

public class RequestsController {
    private static final int MANAGER_ROLE = 1;
    RequestsService requestsService;
    LoginService  loginService;

    Javalin app;

    public RequestsController(Javalin app, RequestsService requestsService, LoginService loginService) {
        this.requestsService = requestsService;
        this.loginService = loginService;
        this.app = app;
    }

    public void requestsEndpoint() {
        app.post("ticket",this::postTicketHandler);
        app.get("getTickets",this::getAllTicketsHandler);

    }

    private void postTicketHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CreateTicket createTicket = mapper.readValue(context.body(), CreateTicket.class);
        Requests requests= this.requestsService.addRequests(createTicket);
        if (requests == null) {
            context.json(String.format("Failure to create request %s.", createTicket.getDescription()));
        }
        else {
            context.json(String.format("Success"));
        }
    }

    private void getAllTicketsHandler(Context context) {
        List<Requests> allTickets = new ArrayList<>();
        if(loginService.getSessionEmployee() == null) {
            context.json("User not logged in ");
            return;
        }
        if(loginService.getSessionEmployee().getEmployee_role()==MANAGER_ROLE) {
            allTickets = requestsService.getAllRequests();
        }
        else {
            allTickets = requestsService.getRequestsByUser(loginService.getSessionEmployee().getEmployee_username());
        }
        context.json(allTickets);
    }


//    private void getSpecificRequestsHandler(Context context) {
//        String employee_username = context.pathParam("employee_username");
//        Requests employee = requestsService.getRequestsByUser(employee_username); // get back to this
//    }
}
