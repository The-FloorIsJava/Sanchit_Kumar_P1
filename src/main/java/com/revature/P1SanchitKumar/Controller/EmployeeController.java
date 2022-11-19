package com.revature.P1SanchitKumar.Controller;

import com.revature.P1SanchitKumar.DAO.EmployeeDAO;
import com.revature.P1SanchitKumar.Service.EmployeeService;
import io.javalin.Javalin;

public class EmployeeController {

    EmployeeService employeeService;

    Javalin app;

    public EmployeeController(Javalin app) {
        employeeService = new EmployeeService(new EmployeeDAO()); //fix this by adding constructor in EmployeeService
        this.app = app;
    }

}
