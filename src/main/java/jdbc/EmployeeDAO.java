package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public List<Employee> getAllEmployeesList() {
        Connection connection = null;
        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            connection = Connections.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rSet = statement.executeQuery("SELECT * FROM employee");
            while (rSet.next()) {
                employeeList.add(new Employee.Builder().id(rSet.getInt("id"))
                        .name(rSet.getString("emp_name"))
                        .lastName(rSet.getString("emp_lastname"))
                        .job(rSet.getString("emp_job")).build());
            }
            return employeeList;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        Connection connection = null;
        try {
            connection = Connections.getInstance().getConnection();
            String sql = "INSERT INTO employee (emp_name, emp_lastname, emp_job) value (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getJob());
            ps.execute();

        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.getErrorCode();
            }
        }
    }

    public Employee getEmployeeById(Integer id) {
        Connection connection = null;
        try {
            connection = Connections.getInstance().getConnection();
            String sql = "SELECT id, emp_name, emp_lastname, emp_job FROM employee WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee.Builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("emp_name"))
                        .lastName(rs.getString("emp_lastname"))
                        .job(rs.getString("emp_job")).build();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return null;
    }

    public void updateEmployee(Employee employee, Integer employeeId) {
        Connection connection = null;
        try {
            connection = Connections.getInstance().getConnection();
            String sql = "UPDATE employee SET emp_name =?, emp_lastname=?, emp_job=? WHERE id= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getJob());
            ps.setInt(4, employeeId);
            ps.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.getErrorCode();
            }
        }
    }
}
