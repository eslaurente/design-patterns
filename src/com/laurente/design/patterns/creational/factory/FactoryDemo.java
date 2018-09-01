package com.laurente.design.patterns.creational.factory;

import java.io.IOException;

public class FactoryDemo {

    public static void main(String[] args) throws ReflectiveOperationException, IOException {
        // ** Factory **
        Point cartesianPoint = Point.Factory.newCartesianPoint(5, 6);
        Point polarPoint = Point.Factory.newPolarPoint(5, 6);
        System.out.println(String.format("New Polar Point:\n%s", polarPoint));
        System.out.println();
        System.out.println(String.format("New Cartesian Point\n%s", cartesianPoint));

        System.out.println();

        // ** Abstract Factory - HotDrinkMachine
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink hotDrink = machine.makeDrink();
        hotDrink.consume();
    }
}
