package com.solidprinciples.liskovsubstitution;

public class ContractEmployee extends Employee {
    public ContractEmployee(String firstName, String lastName, long empNo) {
        super(firstName, lastName, empNo);
    }
}
