package Service;

import Exceptions.DepartmentSearchException;
import com.skypro.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeDepartmentService {
    private final EmployeeService employeeService;

    @Autowired

    public EmployeeDepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .min(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new DepartmentSearchException("Департмент не найден"));
    }

    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .max(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new DepartmentSearchException("Департмент не найден"));
    }

    public List<Employee> getEmployeesWithDepartmentId(Integer departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public List<Employee> getAll() {
        return employeeService.getAll().stream()
                .sorted(Comparator.comparing(Employee::getDepartmentId))
                .collect(Collectors.toList());
    }
}
