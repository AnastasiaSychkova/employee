package com.skypro.employee.exceptions;

public class DepartmentSearchException extends RuntimeException {
    public DepartmentSearchException(String massage) {
        super(massage);
    }
}
