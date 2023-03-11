package Exceptions;

public class DepartmentSearchException extends RuntimeException {
    public DepartmentSearchException(String massage) {
        super(massage);
    }
}
