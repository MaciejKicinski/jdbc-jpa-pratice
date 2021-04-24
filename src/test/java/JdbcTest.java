import jdbc.Employee;
import jdbc.EmployeeDAO;
import org.junit.Test;

import java.util.List;

public class JdbcTest {

    @Test
    public void testOfEmployeeList() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> list = employeeDAO.getAllEmployeesList();
        for (Employee employee : list) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void testOfAddEmployee() {
        Employee maciek = new Employee();
        Employee ewelina = new Employee();
        maciek.setName("Maciek");
        maciek.setLastName("Kici");
        maciek.setJob("inzynier");
        ewelina.setName("Ewelina");
        ewelina.setLastName("Haj");
        ewelina.setJob("marimbioloczystka");
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(maciek);
        employeeDAO.addEmployee(ewelina);
        testOfEmployeeList();
    }

    @Test
    public void testOfgetEmployeeById() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee result = employeeDAO.getEmployeeById(1);
        System.out.println(result.toString());
    }

    @Test
    public void testOfUpdateEmployee() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee maciek = new Employee();
        maciek.setName("Maciek");
        maciek.setLastName("Kici");
        maciek.setJob("programista");
        employeeDAO.updateEmployee(maciek, 1);
        testOfgetEmployeeById();
    }
}
