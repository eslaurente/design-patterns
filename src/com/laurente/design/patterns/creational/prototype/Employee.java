package com.laurente.design.patterns.creational.prototype;

public class Employee {
    public String name;
    public Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Employee(Employee employee) {
        this(employee.name, new Address(employee.address));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
