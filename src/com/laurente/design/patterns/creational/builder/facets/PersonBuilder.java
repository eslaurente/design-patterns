package com.laurente.design.patterns.creational.builder.facets;

// Faceted / Facade Builder
public class PersonBuilder {
    protected Person person = new Person();

    public PersonAddressBuilder address() {
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder job() {
        return new PersonJobBuilder(person);
    }

    public Person build() {
        return person;
    }
}
