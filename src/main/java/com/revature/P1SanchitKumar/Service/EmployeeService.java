package com.revature.P1SanchitKumar.Service;

import com.revature.P1SanchitKumar.DAO.EmployeeDAO;
import com.revature.P1SanchitKumar.Models.Employee;

public class EmployeeService {

    public Employee sessionEmployee = null;

    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {this.employeeDAO = employeeDAO; }


}
