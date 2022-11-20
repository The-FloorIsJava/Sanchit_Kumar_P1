package com.revature.P1SanchitKumar.DAO;

import com.revature.P1SanchitKumar.Models.Employee;
import com.revature.P1SanchitKumar.Util.ConnectionFactory;
import com.revature.P1SanchitKumar.Util.Interface.Crudable;
import com.revature.P1SanchitKumar.Util.Exceptions.InvalidEmployeeInputException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements Crudable<Employee> {


    @Override
    public Employee create(Employee newObject) {
        return null;
    }

    @Override
    public List<Employee> findAll() {

        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){
            List<Employee> employees = new ArrayList<>();

            String sql = "select * from employee";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                employees.add(convertSqlInfoToEmployee(resultSet));
            }

            return employees;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }


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


    public Employee loginCheck(String employee_username, String employee_password){

        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){

            String sql = "select * from employee where employee_username = ? and employee_password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, employee_username);
            preparedStatement.setString(2, employee_password);

            ResultSet resultSet = preparedStatement.executeQuery();

            // column headers return in first line - customer_id, customer_name, balance, password
            if(!resultSet.next()){
                throw new InvalidEmployeeInputException("Entered information for " + employee_username + "was incorrect. Please try again");
            }

            return convertSqlInfoToEmployee(resultSet);

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }


    private Employee convertSqlInfoToEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();

        employee.setEmployee_username(resultSet.getString("employee_username"));
        employee.setEmployee_name(resultSet.getString("employee_name"));
        employee.setEmployee_email(resultSet.getString("employee_email"));
        employee.setEmployee_password(resultSet.getString("employee_password"));
        employee.setEmployee_role(resultSet.getInt("employee_role"));

        return employee;
    }

}
