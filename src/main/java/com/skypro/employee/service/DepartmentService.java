package com.skypro.employee.service;

import com.skypro.employee.exceptions.DepartmentSearchException;
import com.skypro.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    @Autowired

    public DepartmentService(EmployeeService employeeService) {
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

    public Map<Integer, List<Employee>> getAll(Integer departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> departmentId == null || employee.getDepartmentId() == departmentId)
                .collect(Collectors.groupingBy(employee -> employee.getDepartmentId(),
                        Collectors.mapping(employee -> employee, Collectors.toList())));
    }
}
