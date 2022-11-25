package com.revature.P1SanchitKumar;

import com.revature.P1SanchitKumar.Controller.EmployeeController;
import com.revature.P1SanchitKumar.Controller.LoginController;
import com.revature.P1SanchitKumar.DAO.EmployeeDAO;
import com.revature.P1SanchitKumar.Service.LoginService;
import io.javalin.Javalin;

public class Application {
    static LoginService employeeService;
    static EmployeeDAO employeeDAO;
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);
        employeeDAO = new EmployeeDAO();
        employeeService = new LoginService(employeeDAO);
        new EmployeeController(app , employeeService).employeeEndpoint();
        new LoginController(app, employeeService).loginEndpoint();


    }

}
