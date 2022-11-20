package com.revature.P1SanchitKumar.Controller;

import com.revature.P1SanchitKumar.DAO.EmployeeDAO;
import com.revature.P1SanchitKumar.Models.Employee;
import com.revature.P1SanchitKumar.Service.EmployeeService;

import io.javalin.Javalin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.javalin.http.Context;

import java.util.List;

public class EmployeeController {

    EmployeeService employeeService;

    Javalin app;

    public EmployeeController(Javalin app) {
        employeeService = new EmployeeService(new EmployeeDAO()); //fix this by adding constructor in EmployeeService
        this.app = app;
    }

    public void employeeEndpoint() {

        app.get("employees", this::getAllEmployeesHandler);
        app.get("employee/{name}", this::getSpecificEmployeeHandler);

    }


    private void getAllEmployeesHandler(Context context) {
        List<Employee> allEmployees = employeeService.getAllEmployees();

        context.json(allEmployees);
    }

    private void getSpecificEmployeeHandler(Context context) {
        String employee_username = context.pathParam("employee_username");
        Employee employee = employeeService.getEmployee(employee_username); // get back to this
        context.json(employee);
    }

}
