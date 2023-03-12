package com.skypro.employee.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String massage){
        super(massage);
    }
}
