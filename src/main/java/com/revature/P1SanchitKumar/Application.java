package com.revature.P1SanchitKumar;

import com.revature.P1SanchitKumar.Controller.EmployeeController;
import com.revature.P1SanchitKumar.Controller.LoginController;
import com.revature.P1SanchitKumar.Controller.RequestsController;
import com.revature.P1SanchitKumar.DAO.EmployeeDAO;
import com.revature.P1SanchitKumar.DAO.RequestsDAO;
import com.revature.P1SanchitKumar.Service.LoginService;
import com.revature.P1SanchitKumar.Service.RequestsService;
import io.javalin.Javalin;

public class Application {
    static LoginService employeeService;
    static EmployeeDAO employeeDAO;

    static RequestsService requestsService;
    static RequestsDAO requestsDAO;
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);
        employeeDAO = new EmployeeDAO();
        employeeService = new LoginService(employeeDAO);
        requestsDAO = new RequestsDAO();
        requestsService = new RequestsService(requestsDAO);
        new EmployeeController(app , employeeService).employeeEndpoint();
        new LoginController(app, employeeService).loginEndpoint();
        new RequestsController(app, requestsService, employeeService).requestsEndpoint();


    }

}
