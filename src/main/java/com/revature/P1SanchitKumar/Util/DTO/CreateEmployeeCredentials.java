package com.revature.P1SanchitKumar.Util.DTO;

import com.revature.P1SanchitKumar.Models.Employee;

public class CreateEmployeeCredentials {

    private String employee_username;
    private String employee_email;
    private String employee_password;
    private String employee_name;



    public String getEmployee_username() {
        return employee_username;
    }

    public void setEmployee_username(String employee_username) {
        this.employee_username = employee_username;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_password() {
        return employee_password;
    }

    public void setEmployee_password(String employee_password) {
        this.employee_password = employee_password;
    }


    public Employee getEmployee() {
        Employee employee = new  Employee(this.employee_username, this.employee_email, this.employee_password, this.employee_name);
        return employee;
    }
}
