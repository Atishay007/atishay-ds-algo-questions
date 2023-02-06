package com.solidprinciples.liskovsubstitution;

/**
 * Liskov is the name of the author who has created this principle.
 * This principle says that whatever a parent class is doing using their existing methods,
 * that should be done by child class as well, may it can override the functionality, but that
 * functionality should not be broken.
 * In short Subclass should extend the functionality of the parent class not narrow it down.
 * <p>
 * Here,Employee is abstract class which has common tasks which are extended by Permanent and Contract
 * employee.
 * Contract Employee doesn't get bonus but Permanent Employee will get, if we write calculateBonus()
 * functionality in Employee abstract class, then it will mean that this functionality will be performed
 * by its child classes, Permanent and Contract employee.
 * But we have written calculateBonus() functionality in Permanent class only.
 *
 * In Java, Liskov Substitution is well handed by overriding principles.
 * Like child class overriden can't throw broader exception than the one defined in parent class method
 * but it can throw narrow exceptions.
 *
 * The return type is covariant means the return type can be any child class that extends the parent class.
 */
public class LiskovSubstitutionExecution {
    public static void main(String[] args) {
        Employee permEmp = new PermanentEmployee("Atishay", "Jain", 1001);
        System.out.println(((PermanentEmployee) permEmp).calculateBonus());
        Employee contractEmp = new ContractEmployee("Atishay", "Jain", 1001);
        System.out.println(contractEmp.getSalary());
    }
}
