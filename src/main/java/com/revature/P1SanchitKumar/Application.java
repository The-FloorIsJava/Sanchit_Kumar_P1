package com.revature.P1SanchitKumar;

import com.revature.P1SanchitKumar.Controller.EmployeeController;
import com.revature.P1SanchitKumar.DAO.EmployeeDAO;
import com.revature.P1SanchitKumar.Models.Employee;
import com.revature.P1SanchitKumar.Service.EmployeeService;
import io.javalin.Javalin;

import java.util.List;

public class Application {
    static EmployeeService employeeService;
    static EmployeeDAO employeeDAO;
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);
//        employeeDAO = new EmployeeDAO();
//        employeeService = new EmployeeService(employeeDAO);
//
//        List<Employee> employees = employeeService.getAllEmployees();
//        System.out.println(employees);

        new EmployeeController(app).employeeEndpoint();



    }

}
