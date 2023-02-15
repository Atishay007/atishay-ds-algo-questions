package com.misc;

import java.util.*;

/**
 * In Tieto, Difference between Comparator and Comparable question was asked.
 */
public class DifferenceComparatorAndComparable {
    public static void main(String[] args) {
        Patient[] arr = new Patient[2];
        arr[0] = new Patient("John", "Brand", 27);
        arr[1] = new Patient("Diana", "Ross", 26);
        /*
        If we didn't specify Comparable interface then we will get ClassCastException,
          The same way we get in TreeMap, Comparable works well on Primitives
         */
        //Arrays.sort(arr);
        Arrays.sort(arr, new AgeComparator());
        System.out.println(Arrays.toString(arr));
    }
}

class Patient {
    private String firstName;
    private String lastName;
    private int age = 0;

    Patient() {
    }

    Patient(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}


/**
 * Comparable interface can be implemented on the class on which we have to do sorting
 * because compareTo have 1 parameter but we need other object to compare with this parameter
 * so we use "this" but if we have different class like AgeComparable then "this" will not work
 * as this class doesn't have fields to compare with Patient class.
 * <p>
 * Also, in Comparable we can have 1 sorting logic, now we can write multiple sort logic like sorting
 * on name, age etc. in that single compareTo() method.
 * <p>
 * We can't write mutiple sorting conditions like we have done in Comparator() interface.
 */

/*
class AgeComparable implements Comparable<Patient> {
    @Override
    public int compareTo(Patient pat) {
        return this.get.compareTo(pat.firstName);
    }
}
 */


class AgeComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient pat1, Patient pat2) {
        return pat1.getAge() - pat2.getAge();
    }
}

class NameComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient pat1, Patient pat2) {
        return pat1.getFirstName().compareTo(pat2.getFirstName());
    }
}
