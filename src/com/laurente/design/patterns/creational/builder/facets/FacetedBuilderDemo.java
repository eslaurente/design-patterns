package com.laurente.design.patterns.creational.builder.facets;

public class FacetedBuilderDemo {
    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder
                .address()
                    .atAddress("123 London Road")
                    .inCity("London")
                    .inPostCode("SW12BC")
                .job()
                    .worksAt("Fabrikam")
                    .worksAsA("Engineer")
                    .earns(123000)
                .build();
        System.out.println(person);
    }
}
