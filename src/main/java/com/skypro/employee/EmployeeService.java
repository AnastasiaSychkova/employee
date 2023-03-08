package com.skypro.employee;

import Exceptions.EmployeeAlreadyAddedException;
import Exceptions.EmployeeNotFoundException;
import Exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private final int MAX_EMPLOYEES_COUNT = 2;
    private final Map<String, String> employees = new HashMap<>(Map.of());

    public Employee addEmployee(String name, String surName) {
        if (employees.size() == MAX_EMPLOYEES_COUNT) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }

        Employee employee = new Employee(name, surName);

        if (employees.containsKey(employee.getLastName())) {
            throw new EmployeeAlreadyAddedException("В массиве уже есть такой сотрудник");
        }

        employees.put(employee.getLastName(), employee.getFirsName());

        return employee;
    }

    public Employee deleteAnEmployee(String firstName, String lastName) {
        Employee employee = findAnEmployee(firstName, lastName);
        employees.remove(employee.getLastName());

        return employee;
    }

    public Employee findAnEmployee(String name, String surName) {
        Employee employee = new Employee(name,surName);
        if (employees.containsKey(employee.getLastName())) {
            System.out.println("Сотрудник найден");
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    public Map<String, String> getAll() {
        return employees;
    }
}



