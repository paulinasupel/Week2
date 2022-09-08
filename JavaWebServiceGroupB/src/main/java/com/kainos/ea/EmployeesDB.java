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
    public static List<String> getEmployees() {
        List<String> emps = new ArrayList<>();
        String resp = "";
        try {
            Connection con = EmployeesDB.getConnection();  // Bad practices alert!
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
"SELECT s.se_id AS 'Sales ID', " +
        "                    CONCAT_WS (' ', e.fname, e.lname) AS 'Sales name'" +
        "                    FROM Employee e, SalesEmployee s " +
        "                    WHERE e.emp_id = s.se_id;");
            while (rs.next()) {
                /*Employee dbEmp = new Employee((short) rs.getInt("emp_id"), rs.getDouble("salary"), rs.getString("fname"), rs.getString("lname"),
                        rs.getString("bankAccountNumber"), rs.getString("NIN"),
                        rs.getString("phoneNumber"), rs.getString("email"));
                System.out.println(dbEmp);

                 */
                resp = ("These is a sales employee: " + "ID: " +  rs.getInt("Sales ID")
                        + ", name: " +  rs.getString("Sales name"));
                //emps.add(dbEmp);
                emps.add(resp);


            }
            rs = st.executeQuery("SELECT s.de_id AS 'Delivery ID', " +
                    "                    CONCAT_WS (' ', e.fname, e.lname) AS 'Delivery name'" +
                    "                    FROM Employee e, DeliveryEmployee s " +
                    "                    WHERE e.emp_id = s.de_id;");

            while (rs.next()) {

              resp = ("These is a delivery employee: " + "ID: " +  rs.getInt("Delivery ID")
                       + ", name: " +  rs.getString("Delivery name"));
                emps.add(resp);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Bad practice alert!
        }
        return emps;
    }

    public static Employee insertEmployees(Employee employee) {
        try {
            Connection con = EmployeesDB.getConnection();  // Bad practices alert!
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "INSERT INTO Employee (fname, lname, salary, bankAccountNumber, NIN, phoneNumber, email)"

    + "VALUES" + employee.getFirstName() + ", " + employee.getLastName() + ", " +
                            employee.getSalary() + ", " + employee.getBankAccountNumber() + ", " +
                            employee.getNiNumber() + ", " + employee.getPhoneNumber() + ", " +
                            employee.getEmail());

        } catch (SQLException ex) {
            ex.printStackTrace(); // Bad practice alert!
        }
        return employee;
    }



}
