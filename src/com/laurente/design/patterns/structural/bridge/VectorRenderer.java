package com.laurente.design.patterns.structural.bridge;

public class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a cirlce of radius: " + radius);
    }
}
