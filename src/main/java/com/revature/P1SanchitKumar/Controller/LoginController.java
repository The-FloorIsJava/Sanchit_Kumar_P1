package com.revature.P1SanchitKumar.Controller;



import com.revature.P1SanchitKumar.DAO.EmployeeDAO;
import com.revature.P1SanchitKumar.Models.Employee;
import com.revature.P1SanchitKumar.Service.LoginService;
import com.revature.P1SanchitKumar.Util.DTO.LoginCredentials;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class LoginController {

    LoginService loginService;

    Javalin app;

    public LoginController(Javalin app) {
        loginService = new LoginService(new EmployeeDAO()); //fix this by adding constructor in EmployeeService
        this.app = app;
    }

    public void loginEndpoint() {

        app.post("login",this::getLoginCredentialsHandler);


    }

    private void getLoginCredentialsHandler(Context context) {
//        List<Employee> allEmployees = employeeService.getAllEmployees();
//
//        context.json(allEmployees);


    }



}
