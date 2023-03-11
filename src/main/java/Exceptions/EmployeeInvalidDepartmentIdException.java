package Exceptions;

public class EmployeeInvalidDepartmentIdException extends RuntimeException{
    public EmployeeInvalidDepartmentIdException(String massage){
        super(massage);
    }
}
