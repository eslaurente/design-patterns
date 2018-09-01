package com.laurente.design.patterns.creational.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        // HtmlBuilder
        HtmlBuilder builder = new HtmlBuilder("ul")
                .addChild("li", "hello")
                .addChild("li", "world");
        System.out.println(builder.toString());


        // Recursive Generics - PersonBuilder
        EmployeeBuilder pb = new EmployeeBuilder();
        Person emerald = pb
                .withName("Emerald")
                .worksAt("Software Developer Engineer")
                .build();
        System.out.println(emerald);
    }
}
