package com.skypro.employee;

import java.util.Objects;

public class Employee {
    private String firsName;
    private String lastName;
    private float salary;
    private int departmentId;

    public Employee(String firsName, String lastName, float salary, int departmentId) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Float.compare(employee.salary, salary) == 0 && departmentId == employee.departmentId && firsName.equals(employee.firsName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firsName, lastName, salary, departmentId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department=" + departmentId +
                '}';
    }
}