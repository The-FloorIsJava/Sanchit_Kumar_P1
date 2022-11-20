package com.revature.P1SanchitKumar.Service;

import com.revature.P1SanchitKumar.DAO.EmployeeDAO;
import com.revature.P1SanchitKumar.Models.Employee;

import java.util.List;

public class EmployeeService {

    public Employee sessionEmployee = null;

    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {this.employeeDAO = employeeDAO; }

    public Employee addEmployee(Employee employee) {
        return employeeDAO.create(employee);
    }

    public Employee getEmployee(String employee_username) {
        return employeeDAO.findByUser(employee_username);   //get back to this method
    }

    public void removeEmployee(String employee_username) {

    }

    public List<Employee> getAllEmployees() { return employeeDAO.findAll();}


}
