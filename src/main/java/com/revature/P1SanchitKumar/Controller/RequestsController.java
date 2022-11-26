package com.revature.P1SanchitKumar.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.P1SanchitKumar.DAO.RequestsDAO;
import com.revature.P1SanchitKumar.Models.Requests;
import com.revature.P1SanchitKumar.Service.RequestsService;
import com.revature.P1SanchitKumar.Util.DTO.CreateEmployeeCredentials;
import com.revature.P1SanchitKumar.Util.DTO.CreateTicket;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class RequestsController {

    RequestsService requestsService;

    Javalin app;

    public RequestsController(Javalin app) {
        requestsService = new RequestsService (new RequestsDAO());
        this.app = app;
    }

    public void requestsEndpoint() {
        app.post("ticket",this::postTicketHandler);
        app.get("getTickets",this::getAllTicketsHandler);

    }

    private void postTicketHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CreateTicket createTicket = mapper.readValue(context.body(), CreateTicket.class);
    }

    private void getAllTicketsHandler(Context context) {
        List<Requests> allTickets = requestsService.getAllRequests();
        context.json(allTickets);
    }


//    private void getSpecificRequestsHandler(Context context) {
//        String employee_username = context.pathParam("employee_username");
//        Requests employee = requestsService.getRequestsByUser(employee_username); // get back to this
//    }
}
