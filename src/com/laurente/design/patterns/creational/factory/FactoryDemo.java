package com.laurente.design.patterns.creational.factory;

public class FactoryDemo {

    public static void main(String[] args) {
        Point cartesianPoint = Point.newCartesianPoint(5, 6);
        Point polarPoint = Point.newPolarPoint(5, 6);
        System.out.println(String.format("New Polar Point:\n%s", polarPoint));
        System.out.println();
        System.out.println(String.format("New Cartesian Point\n%s", cartesianPoint));
    }
}
