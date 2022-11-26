package com.revature.P1SanchitKumar.DAO;

import com.revature.P1SanchitKumar.Models.Employee;
import com.revature.P1SanchitKumar.Models.Requests;
import com.revature.P1SanchitKumar.Util.ConnectionFactory;
import com.revature.P1SanchitKumar.Util.Interface.Crudable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestsDAO implements Crudable<Requests> {
    @Override
    public Requests create(Requests newObject) {
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {

            String sql = "INSERT INTO requests (employee_username, description, amount, myStatus, approvedBy) VALUES (?, ? , ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, newObject.getEmployee_username());
            preparedStatement.setString(2, newObject.getDescription());
            preparedStatement.setDouble(3, newObject.getAmount());
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
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){
            List<Requests> requests = new ArrayList<>();

            String sql = "select * from requests";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                requests.add(convertSqlInfoToRequests(resultSet));
            }

            return requests;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
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

    private Requests convertSqlInfoToRequests(ResultSet resultSet) throws SQLException {
        Requests requests = new Requests();

        requests.setRequests_id(resultSet.getInt("requests_id"));
        requests.setEmployee_username(resultSet.getString("employee_username"));
        requests.setDescription(resultSet.getString("description"));
        requests.setAmount(resultSet.getDouble("amount"));
        requests.setStatus(Requests.myStatus.valueOf(resultSet.getString("status")));
        requests.setApprovedBy(resultSet.getString("approvedBy"));

        return requests;
    }
}
