package com.skypro.employee.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String massage){
        super(massage);
    }
}
