package com.laurente.design.patterns.creational.singleton;

// Note: making field members static creates a singleton effect, regardless of the fact that client code can
//       instantiate as many instances of this class as it wants
public class MonoStateSingleton {

    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        MonoStateSingleton.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        MonoStateSingleton.age = age;
    }

    @Override
    public String toString() {
        return "MonoStateSingleton{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
