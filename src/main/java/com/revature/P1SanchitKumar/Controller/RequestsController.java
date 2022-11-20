package com.revature.P1SanchitKumar.Controller;

import com.revature.P1SanchitKumar.DAO.RequestsDAO;
import com.revature.P1SanchitKumar.Models.Requests;
import com.revature.P1SanchitKumar.Service.RequestsService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class RequestsController {

    RequestsService requestsService;

    Javalin app;

    public RequestsController(Javalin app) {
        requestsService = new RequestsService (new RequestsDAO());
        this.app = app;
    }

    public void requestsEndpoint() {

    }

    private void getSpecificRequestsHandler(Context context) {
        String employee_username = context.pathParam("employee_username");
        Requests employee = requestsService.getRequestsByUser(employee_username); // get back to this
    }
}
