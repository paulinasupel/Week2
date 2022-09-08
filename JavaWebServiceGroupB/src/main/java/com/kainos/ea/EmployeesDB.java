package com.kainos.ea;

import com.kainos.ea.employee_stuff.Employee;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeesDB {

    private static Connection conn;

    static Connection getConnection() {
        String user;
        String password;
        String host;

        if (conn != null) {
            return conn;
        }

        try {
            // Bad practice alert!
            FileInputStream propsStream =
                    new FileInputStream("employeesdb.properties");

            Properties props = new Properties();
            props.load(propsStream);

            user            = props.getProperty("user");
            password        = props.getProperty("password");
            host            = props.getProperty("host");

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain "
                                + "user, password, and host properties.");
            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/GroupB_PaulinaS?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    static List<Employee> getEmployees() {
        List<Employee> emps = new ArrayList<>();

        try {
            Connection con = EmployeesDB.getConnection();  // Bad practices alert!
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT emp_no AS `number`, "
                            + "CONCAT_WS (' ', first_name, last_name) AS `name`, "
                            + "salary * 100 AS `salary` "
                            + "FROM employees JOIN salaries USING(emp_no) "
                            + "WHERE to_date > NOW() AND salary = 100000");

            while (rs.next()) {
                Employee dbEmp = new Employee((short) rs.getInt("number"), rs.getInt("salary"), rs.getString("name"));
                System.out.println(dbEmp);
                emps.add(dbEmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Bad practice alert!
        }
        return emps;
    }


}
