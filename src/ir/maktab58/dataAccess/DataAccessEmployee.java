package ir.maktab58.dataAccess;

import ir.maktab58.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58 - pset05 - jdbc Q#1
 */
public class DataAccessEmployee {

    Connection connection;

    public DataAccessEmployee() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_company", "root", "5103583");
    }

    public void insertNewEmployee() throws SQLException {
        if(connection != null){
            Statement statement = connection.createStatement();

            int result = statement.executeUpdate("insert into employees (id, first_name, last_name, personal_number, birth_date, id_department)" +
                    "values (7, 'sam', 'samani', 4568, '2002-8-12', 1)");
            System.out.println("Record " + result + " inserted.");
        }else{
            System.out.println("there is no connection!");
        }
    }

    public void updateName() throws SQLException {
        if(connection != null){
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("update employees set first_name = 'alireza', last_name = 'mohammadifar'" +
                    "where id = 2");
            System.out.println("Record " + result + " updated.");
        }else{
            System.out.println("there is no connection!");
        }
    }

    public List<Employee> showEmployeesOnSpecificDepartment() throws SQLException {
        if(connection != null){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employees " +
                    "inner join departments on employees.id_department = departments.id " +
                    "where departments.name = 'financial'");
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setPersonalId(resultSet.getInt("personal_number"));
                employee.setBirthDate(resultSet.getDate("birth_date"));
                employee.setDepartmentId(resultSet.getInt("id_department"));
                employees.add(employee);
            }
            return employees;
        }else {
            return Collections.emptyList();
        }
    }
}
