package com.laurente.design.patterns.creational.prototype;

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee john = new Employee("John", new Address("123 London Road", "London", "UK"));

        // Employee chris = john;
        Employee chris = new Employee(john);

        chris.name = "Chris";
        chris.address.streetAddress = "1234 Glisan Street";
        chris.address.city = "Portland";
        chris.address.country = "USA";
        System.out.println(john);
        System.out.println(chris);
    }
}
