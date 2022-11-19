package com.revature.P1SanchitKumar.Models;

public class Requests {

    public enum myStatus {
        PENDING,
        DENIED,
        APPROVED;
    }

    private int requests_id;
    private String employee_username;
    private String description;
    private int amount;
    private myStatus status;
    private String approvedBy;

    public Requests(int requests_id, String employee_username, String description, int amount, String approvedBy) {
        this.requests_id = requests_id;
        this.employee_username = employee_username;
        this.description = description;
        this.amount = amount;
        this.status = myStatus.PENDING;
        this.approvedBy = approvedBy;
    }

    public Requests(int requests_id, String employee_username, String description, int amount, myStatus status, String approvedBy) {
        this.requests_id = requests_id;
        this.employee_username = employee_username;
        this.description = description;
        this.amount = amount;
        this.status = myStatus.PENDING;
        this.approvedBy = approvedBy;

    }

    public Requests() {

    }

    public int getRequests_id() {
        return requests_id;
    }

    public void setRequests_id(int requests_id) {
        this.requests_id = requests_id;
    }

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public myStatus getStatus() {
        return status;
    }

    public void setStatus(myStatus status) {
        this.status = status;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
}
