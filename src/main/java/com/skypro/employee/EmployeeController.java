package com.skypro.employee;

import Exceptions.EmployeeAlreadyAddedException;
import Exceptions.EmployeeNotFoundException;
import Exceptions.EmployeeStorageIsFullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeStorageIsFullException.class)
    public String handleException(EmployeeStorageIsFullException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public String handleException(EmployeeAlreadyAddedException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleException(EmployeeNotFoundException e) {
        return String.format("%s EmployeeNotFoundException %s", HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    private final EmployeeService employeeService;

    @Autowired

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path = "/add")
    public Employee addEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.addEmployee(name, surname);
    }

    @RequestMapping(path = "/find")
    public Employee findAnEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.findAnEmployee(name, surname);
    }

    @RequestMapping(path = "/delete")
    public Employee deleteAnEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return employeeService.deleteAnEmployee(name, surname);
    }
    @RequestMapping(path = "/findAll")
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }
}
