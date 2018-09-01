package com.laurente.design.patterns.creational.builder.facets;

public class PersonAddressBuilder extends PersonBuilder {

    public PersonAddressBuilder(Person person) {
        this.person = person;
    }

    public PersonAddressBuilder atAddress(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder inPostCode(String postCode) {
        person.postCode = postCode;
        return this;
    }

    public PersonAddressBuilder inCity(String city) {
        person.city = city;
        return this;
    }

}
