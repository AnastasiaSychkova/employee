package com.skypro.employee.controller;

import com.skypro.employee.exceptions.DepartmentSearchException;
import com.skypro.employee.service.DepartmentService;
import com.skypro.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DepartmentSearchException.class)
    public String handleException(DepartmentSearchException e) {
        return String.format("%s EmployeeNotFoundException %s", HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    private final DepartmentService employeeDepartmentService;

    @Autowired
    public DepartmentController(DepartmentService employeeDepartmentService) {
        this.employeeDepartmentService = employeeDepartmentService;
    }

    @RequestMapping(path = "/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentId") Integer departmentId) {
        return employeeDepartmentService.getEmployeeWithMinSalary(departmentId);
    }

    @RequestMapping(path = "/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        return employeeDepartmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @RequestMapping(path = "/all")
    public Map<Integer, List<Employee>> getEmployeesWithDepartmentId(@RequestParam(required = false) Integer departmentId) {
        return employeeDepartmentService.getAll(departmentId);
    }
}
