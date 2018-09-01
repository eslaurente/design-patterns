package com.laurente.design.patterns.creational.factory;

public class TeaFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.println(String.format("Put in tea bag, boil water, pour %d ml, add lemon, and enjoy!", amount));
        return new Tea();
    }
}
