package com.laurente.design.patterns.creational.factory;

enum CoordinateSystem {
    CARTESIAN,
    POLAR
}

public class Point {
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    private double x, y;

    /**
     *  BAD: Have to document what underlying args are and switch based on a type
     * @param a
     * @param b
     * @param coordinateSystem
     */
    public Point(double a, double b, CoordinateSystem coordinateSystem) {
        switch (coordinateSystem) {
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
            case POLAR:
                this.x = a * Math.cos(b);
                this.y = a * Math.sin(b);
                break;
            default:
                break;
        }
    }
}
