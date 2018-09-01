package com.laurente.design.patterns.creational.factory;

public class CoffeeFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println(String.format("Grind some beans, boil water, pour %d ml, add cream and sugar, and enjoy!", amount));
        return new Coffee();
    }
}
