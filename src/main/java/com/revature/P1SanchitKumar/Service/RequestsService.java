package com.revature.P1SanchitKumar.Service;

import com.revature.P1SanchitKumar.DAO.RequestsDAO;
import com.revature.P1SanchitKumar.Models.Requests;
import com.revature.P1SanchitKumar.Util.DTO.CreateTicket;

import java.util.List;

public class RequestsService {

    public Requests sessionRequests = null;

    private final RequestsDAO requestsDAO;

    public RequestsService(RequestsDAO requestsDAO) { this.requestsDAO = requestsDAO; }

    public Requests addRequests(CreateTicket ticket) { return requestsDAO.create(ticket.getRequest()); }

    public List<Requests> getRequestsByUser(String employee_username) {
        return requestsDAO.getRequestsForUser(employee_username);
    }

    public void removeRequests(String employee_username) {

    }

    public List<Requests> getAllRequests() {
        return requestsDAO.findAll();
    }


}
