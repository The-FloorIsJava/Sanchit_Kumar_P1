package com.revature.P1SanchitKumar.Controller;

import com.revature.P1SanchitKumar.DAO.EmployeeDAO;
import com.revature.P1SanchitKumar.Models.Employee;
import com.revature.P1SanchitKumar.Service.EmployeeService;

import com.revature.P1SanchitKumar.Service.LoginService;
import io.javalin.Javalin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.javalin.http.Context;

import java.util.List;

public class EmployeeController {

    LoginService employeeService;  // put this within the main method Dependecny injection.

    Javalin app;

    public EmployeeController(Javalin app , LoginService employeeService) {
        this.employeeService = employeeService; //change this and move it to the main method and inject DAO into it.
        this.app = app;
    }

    public void employeeEndpoint() {

        app.get("employees", this::getAllEmployeesHandler);
        app.get("employee/{username}", this::getSpecificEmployeeHandler);

    }


    private void getAllEmployeesHandler(Context context) {
        List<Employee> allEmployees = employeeService.getAllEmployees();

        context.json(allEmployees);
    }

    private void getSpecificEmployeeHandler(Context context) {
        String employee_username = context.pathParam("username");
        Employee employee = employeeService.getEmployee(employee_username); // get back to this
        context.json(employee);
    }

}
