package com.solidprinciples.interfaceseggregation;

/**
 * Interfaces should be created in such a way that their clients don't have to implement
 * unnecessary functions that they do not need.
 */
public class InterfaceSegregationExecution {
    public static void main(String[] args) {

    }
}


interface RestaurantEmployee {
    public void cook();

    public void serve();

    public void washDishes();
}

/*
As you can see the Waiter class is implementing all methods of RestaurantEmployee.
Waiter should be responsible to serve the customers not to wash or cook dishes.
This is clear violation of Interface Segregation Principle.

class Waiter implements RestaurantEmployee {

    @Override
    public void cook() {

    }

    @Override
    public void serve() {

    }

    @Override
    public void washDishes() {

    }
 */

    /*
        Instead of adding all functionalities in Single Interface, we can create multiple
        individual interface like WaiterInterface and it will have all functions related to Waiter
        Another can be ChefInterface and it will will have all actions that Chef will be doing.
     */

interface WaiterInterface {
    public void cook();
}

class Waiter implements WaiterInterface {

    @Override
    public void cook() {

    }
}
