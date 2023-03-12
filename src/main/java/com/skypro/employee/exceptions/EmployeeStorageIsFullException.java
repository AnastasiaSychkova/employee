package com.skypro.employee.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String massage) {
        super(massage);
    }
}
