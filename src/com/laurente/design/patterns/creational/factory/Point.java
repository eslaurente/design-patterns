package com.laurente.design.patterns.creational.factory;

public class Point {
    enum CoordinateSystem {
        POLAR,
        CARTESIAN
    }

    private CoordinateSystem coordinateSystem;

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

    private Point(double x, double y, CoordinateSystem coordinateSystem) {
        this.x = x;
        this.y = y;
        this.coordinateSystem = coordinateSystem;
    }

    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y, CoordinateSystem.CARTESIAN);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho * Math.cos(theta), rho * Math.sin(theta), CoordinateSystem.POLAR);
    }

    @Override
    public String toString() {
        boolean isCartesian = this.coordinateSystem.equals(CoordinateSystem.CARTESIAN);
        return String.format("Point {\n  %s = %s,\n  %s = %s\n}", isCartesian ? "x" : "rho", x, isCartesian ? "y" : "theta", y);
    }
}
