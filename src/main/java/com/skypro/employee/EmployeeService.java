package com.skypro.employee;

import Exceptions.EmployeeAlreadyAddedException;
import Exceptions.EmployeeNotFoundException;
import Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final int MAX_EMPLOYEES_COUNT = 2;
    private final List<Employee> employees = new ArrayList<>(List.of());

    public Employee addEmployee(String name, String surName) {
        if (employees.size() == MAX_EMPLOYEES_COUNT) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }

        Employee employee = new Employee(name, surName);

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("В массиве уже есть такой сотрудник");
        }

        employees.add(employee);

        return employee;
    }

    public Employee deleteAnEmployee(String firstName, String lastName) {
        Employee employee = findAnEmployee(firstName, lastName);

        for (Employee e : employees) {
            if (e.equals(employee)) {
                return e;
            }
        }

        return employee;
    }

    public Employee findAnEmployee(String name, String surName) {
        Employee employee = null;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) != null && name.equals(employees.get(i).getFirsName()) && surName.equals(employees.get(i).getLastName())) {
                employee = employees.get(i);
            } else {
                throw new EmployeeNotFoundException("Сотрудник не найден");
            }
        }
        return employee;
    }
    public List<Employee> getAll() {
        return employees;
    }
}



