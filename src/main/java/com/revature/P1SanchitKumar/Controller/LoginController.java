package com.revature.P1SanchitKumar.Controller;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.P1SanchitKumar.DAO.EmployeeDAO;
import com.revature.P1SanchitKumar.Models.Employee;
import com.revature.P1SanchitKumar.Service.EmployeeService;
import com.revature.P1SanchitKumar.Service.LoginService;
import com.revature.P1SanchitKumar.Util.DTO.CreateEmployeeCredentials;
import com.revature.P1SanchitKumar.Util.DTO.LoginCredentials;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;
import java.util.StringTokenizer;

public class LoginController {

    LoginService loginService;

    Javalin app;

    public LoginController(Javalin app) {
        //loginService = new LoginService(new EmployeeDAO()); //fix this by adding constructor in EmployeeService
        loginService = new LoginService(new EmployeeDAO()); //fix this by adding constructor in EmployeeService
        this.app = app;
    }

    public void loginEndpoint() {

        app.post("login",this::postLoginCredentialsHandler);
        app.post("register",this::postRegisterHandler);


    }

//    private void getLoginCredentialsHandler(Context context) {
////        List<Employee> allEmployees = employeeService.getAllEmployees();
////
////        context.json(allEmployees);
//
//        String body = context.body();
//        StringTokenizer st = new StringTokenizer(body,"\r\n");
//        st.nextToken();
//        String employee_username = st.nextToken().split(":")[1].trim();
//
//        String employee_password = st.nextToken().split(":")[1].trim();
//
//        Employee employee = loginService.getEmployee(employee_username);
//
//        if(employee == null) {
//            context.json(false);;
//        }
//
//        else if(employee_password.equals(employee.getEmployee_password())) {
//            context.json(true);;
//        }
//        else {
//            context.json(false);;
//        }
//
//
//
//    }

    private void postLoginCredentialsHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        LoginCredentials loginCredentials = mapper.readValue(context.body(), LoginCredentials.class);
        if (this.loginService.checkLogin(loginCredentials) == false) {
            context.json(String.format("Failure to login %s.", loginCredentials.getEmployee_username()));
        }
        else {
            context.json(String.format("Success %s", loginCredentials.getEmployee_username()));
        }
    }

    private void postRegisterHandler(Context context) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        CreateEmployeeCredentials createEmployeeCredentials = mapper.readValue(context.body(), CreateEmployeeCredentials.class);
        if (this.loginService.registerEmployee(createEmployeeCredentials) == null) {
            context.json(String.format("Failure to create employee %s.", createEmployeeCredentials.getEmployee_username()));
        }
        else {
            context.json(String.format("Success %s", createEmployeeCredentials.getEmployee_username()));
        }

    }



}
