package ir.maktab58.dataAccess;

import ir.maktab58.model.Department;

import java.sql.*;

/**
 * @author Mahsa Alikhani m-58 - pset05 - jdbc Q#1
 */
public class DataAccessDepartment {

    Connection connection;

    public DataAccessDepartment() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_company","root","5103583");
    }

    public void insertNewDepartment() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("insert into departments values(4, 'management', 223355)");
            System.out.println("Record " + result + " inserted.");
        }else{
            System.out.println("there is no connection!");
        }
    }

    public void updateDepartmentName() throws SQLException {
        if(connection != null){
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("update departments set name ='marketing' where id = 4");
            System.out.println("Record " + result + " updated.");
        }else {
            System.out.println("there is no connection!");
        }
    }

    public ResultSet showDepartments() throws SQLException {
        if(connection != null){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from departments");
            return resultSet;
        }else {
            return null;
        }
    }
}
