package Controller;

import Exceptions.DepartmentSearchException;
import Service.EmployeeDepartmentService;
import com.skypro.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeDepartmentController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DepartmentSearchException.class)
    public String handleException(DepartmentSearchException e) {
        return String.format("%s EmployeeNotFoundException %s", HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    private final EmployeeDepartmentService employeeDepartmentService;

    @Autowired
    public EmployeeDepartmentController(EmployeeDepartmentService employeeDepartmentService) {
        this.employeeDepartmentService = employeeDepartmentService;
    }

    @RequestMapping(path = "/mix-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentId") Integer departmentId) {
        return employeeDepartmentService.getEmployeeWithMinSalary(departmentId);
    }

    @RequestMapping(path = "/departments/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        return employeeDepartmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @RequestMapping(path = "/all")
    public List<Employee> getEmployeesWithDepartmentId(@RequestParam("departmentId") Integer departmentId) {
        return employeeDepartmentService.getEmployeesWithDepartmentId(departmentId);
    }

    @RequestMapping(path = "/all")
    public List<Employee> getAll() {
        return employeeDepartmentService.getAll();
    }
}
