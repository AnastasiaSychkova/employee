package Service;

import Exceptions.EmployeeAlreadyAddedException;
import Exceptions.EmployeeNotFoundException;
import Exceptions.EmployeeStorageIsFullException;
import com.skypro.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static List<Employee> employees = new ArrayList<>();

    static {
        Employee e1 = new Employee("Петр", "Елкин", 200333f, 1);
        Employee e2 = new Employee("Алексей", "Снигирь", 10211f, 2);
        Employee e3 = new Employee("Мария", "Петрова", 99999f, 4);
        Employee e4 = new Employee("Геннадий", "Хелпов", 9900f, 3);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
    }


    public Employee addEmployee(String name, String surName, float salary, Integer departmentId) {
        if (employees.size() == 7) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }

        Employee employee = new Employee(name, surName, salary, departmentId);
        //if (employee.getDepartmentId() > 5) {
         //   throw new EmployeeInvalidDepartmentIdException("ID не существует");
        //}

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("В массиве уже есть такой сотрудник");
        }

        employees.add(employee);

        return employee;
    }

    public Employee deleteAnEmployee(String firstName, String lastName) {
        Employee employee = findAnEmployee(firstName, lastName);
        employees.remove(employee);

        return employee;
    }

    public Employee findAnEmployee(String firstName, String lastName) {
        Employee employee = null;

        for (Employee e : employees) {
            if (e != null && firstName.equals(e.getFirstName()) && lastName.equals(e.getLastName())) {
                employee = e;
            }
        }

        if (employee == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }

        return employee;
    }

    public List<Employee> getAll() {
        return employees;
    }
}



