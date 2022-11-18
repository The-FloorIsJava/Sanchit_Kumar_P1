package com.revature.P1SanchitKumar.Models;

public class Employee {

    private String employee_username;

    private String employee_email;

    private String employee_password;

    private String employee_name;

    private int employee_role;

    public Employee() {

    }

    public Employee(String employee_username, String employee_email, String employee_password, String employee_name) {
        this.employee_username = employee_username;
        this.employee_email = employee_email;
        this.employee_password = employee_password;
        this.employee_name = employee_name;
        this.employee_role = 0;
    }

    public Employee(String employee_username, String employee_email, String employee_password, String employee_name, int employee_role) {
        this.employee_username = employee_username;
        this.employee_email = employee_email;
        this.employee_password = employee_password;
        this.employee_name = employee_name;
        this.employee_role = employee_role;

    }
}
