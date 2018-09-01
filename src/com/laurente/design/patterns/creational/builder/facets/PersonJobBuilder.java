package com.laurente.design.patterns.creational.builder.facets;

public class PersonJobBuilder extends PersonBuilder {

    public PersonJobBuilder(Person person) {
        this.person = person;
    }

    public PersonJobBuilder worksAt(String companyName) {
        this.person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder worksAsA(String position) {
        this.person.position = position;
        return this;
    }

    public PersonJobBuilder earns(int annualIncome) {
        this.person.annualIncome = annualIncome;
        return this;
    }
}
