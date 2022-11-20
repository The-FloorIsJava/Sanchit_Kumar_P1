package com.revature.P1SanchitKumar.Service;

import com.revature.P1SanchitKumar.DAO.RequestsDAO;
import com.revature.P1SanchitKumar.Models.Requests;

import java.util.List;

public class RequestsService {

    public Requests sessionRequests = null;

    private final RequestsDAO requestsDAO;

    public RequestsService(RequestsDAO requestsDAO) { this.requestsDAO = requestsDAO; }

    public Requests addRequests(Requests requests) { return requestsDAO.create(requests); }

    public Requests getRequestsByUser(String employee_username) { return null; } // get back to this implementation

    public void removeRequests(String employee_username) {

    }

    public List<Requests> getAllRequests() { return requestsDAO.findAll(); }


}
