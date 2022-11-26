package com.revature.P1SanchitKumar.DAO;

import com.revature.P1SanchitKumar.Models.Requests;
import com.revature.P1SanchitKumar.Util.ConnectionFactory;
import com.revature.P1SanchitKumar.Util.Interface.Crudable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RequestsDAO implements Crudable<Requests> {
    @Override
    public Requests create(Requests newObject) {
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {

            String sql = "INSERT INTO requests (employee_username, description, amount, myStatus, approvedBy) VALUES (?, ? , ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, newObject.getEmployee_username());
            preparedStatement.setString(2, newObject.getDescription());
            preparedStatement.setInt(3, newObject.getAmount());
            preparedStatement.setString(4, newObject.getStatus().getStringValue());
            preparedStatement.setString(5, newObject.getApprovedBy());

            int row = preparedStatement.executeUpdate();

            if(row == 1) {
                return newObject;
            }
            else {
                return null;
            }


        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
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
