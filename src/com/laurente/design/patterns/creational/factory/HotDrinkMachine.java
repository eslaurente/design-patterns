package com.laurente.design.patterns.creational.factory;

import javafx.util.Pair;
import org.reflections.Reflections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HotDrinkMachine {
    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();

    public HotDrinkMachine() throws ReflectiveOperationException  {
        Set<Class<? extends HotDrinkFactory>> types = new Reflections("")
                .getSubTypesOf(HotDrinkFactory.class);

        for (Class<? extends HotDrinkFactory> type : types) {
            namedFactories.add(new Pair<>(
                    type.getSimpleName().replace("Factory", ""),
                    type.getDeclaredConstructor().newInstance()
            ));
        }
    }

    public HotDrink makeDrink() throws IOException {
        System.out.println("Available drinks:");
        for (int i = 0; i < namedFactories.size(); i++) {
            Pair<String, HotDrinkFactory> item = namedFactories.get(i);
            System.out.println(String.format("%d: %s", i, item.getKey()));
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = bufferedReader.readLine();
            int i = Integer.parseInt(s);
            int amount;
            if (s != null && i < namedFactories.size() && i >= 0) {
                System.out.println("Specify amount:");
                s = bufferedReader.readLine();
                amount = Integer.parseInt(s);
                if (s != null && amount > 0) {
                    return namedFactories.get(i).getValue().prepare(amount);
                }
            }
            System.out.println("Incorrect input, try again...");
        }
    }
}
