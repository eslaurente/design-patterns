package com.laurente.design.patterns.creational.prototype;

public class Address {
    public String streetAddress, city, country;

    public Address(String streetAddress, String city, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
    }

    public Address(Address address) {
        this(address.streetAddress, address.city, address.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
