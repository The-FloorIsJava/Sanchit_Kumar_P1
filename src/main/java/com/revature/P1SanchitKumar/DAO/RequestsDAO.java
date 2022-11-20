package com.revature.P1SanchitKumar.DAO;

import com.revature.P1SanchitKumar.Models.Requests;
import com.revature.P1SanchitKumar.Util.Interface.Crudable;

import java.util.List;

public class RequestsDAO implements Crudable<Requests> {
    @Override
    public Requests create(Requests newObject) {
        return null;
    }

    @Override
    public List<Requests> findAll() {
        return null;
    }

    @Override
    public Requests findByUser(String employee_user) {
        return null;
    }

    @Override
    public boolean update(Requests updatedObject) {
        return false;
    }

    @Override
    public boolean delete(String employee_user) {
        return false;
    }
}
