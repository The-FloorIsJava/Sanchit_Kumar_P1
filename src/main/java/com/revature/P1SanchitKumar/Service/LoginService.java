package com.revature.P1SanchitKumar.Service;

import com.revature.P1SanchitKumar.DAO.EmployeeDAO;
import com.revature.P1SanchitKumar.Models.Employee;
import com.revature.P1SanchitKumar.Util.DTO.CreateEmployeeCredentials;
import com.revature.P1SanchitKumar.Util.DTO.LoginCredentials;

import java.util.List;

public class LoginService {

    private Employee    sessionEmployee = null;

    public Employee getSessionEmployee() {
        return sessionEmployee;
    }

    public void setSessionEmployee(Employee sessionEmployee) {
        this.sessionEmployee = sessionEmployee;
    }

    private final EmployeeDAO employeeDAO;

    public LoginService(EmployeeDAO employeeDAO) {this.employeeDAO = employeeDAO; }

    public Employee addEmployee(Employee employee) {
        return employeeDAO.create(employee);
    }

    public Employee getEmployee(String employee_username) {
        return employeeDAO.findByUser(employee_username);   //get back to this method
    }

    public void removeEmployee(String employee_username) {

    }

    public List<Employee> getAllEmployees() { return employeeDAO.findAll();}


    public boolean checkLogin(LoginCredentials loginCredentials) {
       Employee employee =  employeeDAO.findByUser(loginCredentials.getEmployee_username());

       if(employee == null) {
           return false;
       }
       else if(employee.getEmployee_password().equals(loginCredentials.getEmployee_password())) {
           this.sessionEmployee = employee;
           return true;
       }
       else {
           return false;
       }
    }

    public Employee registerEmployee(CreateEmployeeCredentials createEmployeeCredentials) {

        Employee employee =  employeeDAO.create(createEmployeeCredentials.getEmployee());

        return employee;
    }
}
