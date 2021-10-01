package ir.maktab58;

import ir.maktab58.dataAccess.DataAccessDepartment;
import ir.maktab58.dataAccess.DataAccessEmployee;
import ir.maktab58.model.Employee;

import java.sql.*;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58 - pset05 - jdbc Q#1
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DataAccessEmployee dataAccessEmployee = new DataAccessEmployee();
        //dataAccessEmployee.insertNewEmployee();
        dataAccessEmployee.updateName();
        List<Employee> allEmployees = dataAccessEmployee.showEmployeesOnSpecificDepartment();
        for (Employee obj : allEmployees) {
            System.out.print("ID: "+obj.getId()+", ");
            System.out.print("First name: "+obj.getFirstName()+", ");
            System.out.print("Last name: "+obj.getLastName()+", ");
            System.out.print("Personal number: "+obj.getPersonalId()+", ");
            System.out.print("Birth date: "+obj.getBirthDate());
            System.out.println();
        }

        DataAccessDepartment dataAccessDepartment = new DataAccessDepartment();
        //dataAccessDepartment.insertNewDepartment();
        dataAccessDepartment.updateDepartmentName();
        ResultSet result = dataAccessDepartment.showDepartments();
        while (result.next()){
            System.out.println("Department: " + result.getInt("id") +", " + result.getString("name")
                    + ", " + result.getInt("phone_number"));
        }
    }
}
