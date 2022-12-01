package com.revature.P1SanchitKumar.Models;

public class Requests {

    public enum myStatus {
        PENDING("pending"),
        DENIED("denied"),
        APPROVED("approved");
        private String value;
        private myStatus(String value){
            this.value = value;
        }
        public String getStringValue() {
            return this.value;
        }
        public static myStatus getEnumValue(String value) {
            switch(value) {
                case "pending":
                    return myStatus.PENDING;
                case "denied":
                    return myStatus.DENIED;
                case "approved":
                    return myStatus.APPROVED;
                default:
                    return myStatus.PENDING;
            }
        }
    }

    private int requests_id;
    private String employee_username;
    private String description;
    private double amount;
    private String status;
    private String approvedBy;

    public Requests(int requests_id, String employee_username, String description, double amount, String approvedBy) {
        this.requests_id = requests_id;
        this.employee_username = employee_username;
        this.description = description;
        this.amount = amount;
        this.status = myStatus.PENDING.getStringValue();
        this.approvedBy = approvedBy;
    }

    public Requests(int requests_id, String employee_username, String description, double amount, String status, String approvedBy) {
        this.requests_id = requests_id;
        this.employee_username = employee_username;
        this.description = description;
        this.amount = amount;
        this.status = status;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return this.status;
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
}
