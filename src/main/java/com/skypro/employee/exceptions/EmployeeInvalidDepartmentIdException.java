package com.skypro.employee.exceptions;

public class EmployeeInvalidDepartmentIdException extends RuntimeException{
    public EmployeeInvalidDepartmentIdException(String massage){
        super(massage);
    }
}
