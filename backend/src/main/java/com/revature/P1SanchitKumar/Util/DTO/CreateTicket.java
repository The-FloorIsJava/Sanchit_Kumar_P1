package com.revature.P1SanchitKumar.Util.DTO;

import com.revature.P1SanchitKumar.Models.Requests;

public class CreateTicket {

    private String employee_username;
    private String description;
    private double amount;
    private String status;
    private String approvedBy;

    public String getEmployee_username() {
        return employee_username;
    }

    public void setEmployee_username(String employee_username) {
        this.employee_username = employee_username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }


    public Requests getRequest() {
        Requests requests = new Requests( 0, this.employee_username, this.description, this.amount, this.status, this.approvedBy);

        return requests;

    }
}
