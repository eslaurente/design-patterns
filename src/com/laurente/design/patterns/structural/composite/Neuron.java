package com.laurente.design.patterns.structural.composite;

import java.util.ArrayList;

public class Neuron {
    public ArrayList<Neuron> in;
    public ArrayList<Neuron> out;

    public void connectTo(Neuron other) {
        out.add(other);
        other.in.add(this);
    }
}
