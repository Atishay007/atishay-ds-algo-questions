package com.solidprinciples.liskovsubstitution;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private long empNo;
    private long salary;

    public Employee(String firstName, String lastName, long empNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.empNo = empNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(long empNo) {
        this.empNo = empNo;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
