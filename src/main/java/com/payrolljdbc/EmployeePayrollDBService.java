package com.payrolljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;



public class EmployeePayrollDBService {
	  private Connection getConnection() throws SQLException {
	        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
	        String userName = "root";
	        String password = "Alliance@123";
	        java.sql.Connection connection;
	        System.out.println("Connectinng to database:" + jdbcURL);
	        connection = DriverManager.getConnection(jdbcURL, userName, password);
	        System.out.println("Connection is successful!!!" + connection);
	        return (Connection) connection;
	    }

	    public List<EmployeePayrollData> readData()  {
	        String sql = "select * from employee_payroll;";
	        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	        try (Connection connection = this.getConnection()){
	            Statement statement = (Statement) connection.createStatement();
	            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(sql);
	            while(resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                double salary = resultSet.getDouble("salary");
	                LocalDate startDate = resultSet.getDate("startDate").toLocalDate();
	                employeePayrollList.add(new EmployeePayrollData(id, name, salary, startDate));
	            }
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	        return employeePayrollList;
	    }

}
