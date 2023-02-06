package com.solidprinciples.liskovsubstitution;

public class PermanentEmployee extends Employee  {
    public PermanentEmployee(String firstName, String lastName, long empNo) {
        super(firstName, lastName, empNo);
    }

    public long calculateBonus() {
        return getSalary() * 30 / 100;
    }
}
