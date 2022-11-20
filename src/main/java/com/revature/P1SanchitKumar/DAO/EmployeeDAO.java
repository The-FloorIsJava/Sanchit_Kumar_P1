package com.revature.P1SanchitKumar.DAO;

import com.revature.P1SanchitKumar.Models.Employee;
import com.revature.P1SanchitKumar.Util.Interface.Crudable;

import java.util.List;

public class EmployeeDAO implements Crudable<Employee> {


    @Override
    public Employee create(Employee newObject) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Employee findByUser(String employee_user) {
        return null;
    }

    @Override
    public boolean update(Employee updatedObject) {
        return false;
    }

    @Override
    public boolean delete(String employee_user) {
        return false;
    }
}
