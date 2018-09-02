package com.laurente.design.patterns.creational.prototype;

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person john = new Person(new String[]{"John", "Smith"}, new Address("London Road", 123));

        Person jane = (Person)john.clone();
        jane.names[0] = "Jane";
        jane.address.streetName = "6345 NE Glisan Street";
        jane.address.houseNumber = 124;
        System.out.println(john);
        System.out.println(jane);
        System.out.println(String.format("john.names[0].equals(jane.names[0]) == false: %s | john.address.streetName.equals(jane.address.streetName) == false: %s", john.names[0].equals(jane.names[0]), john.address.streetName.equals(jane.address.streetName)));
    }
}
