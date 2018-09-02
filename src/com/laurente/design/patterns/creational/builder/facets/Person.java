package com.laurente.design.patterns.creational.builder.facets;

public class Person {
    public String streetAddress, postCode, city;
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "Employee{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postCode ='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}
