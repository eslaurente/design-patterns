package com.laurente.design.patterns.structural.composite;

public class CompositeDemo {

    public static void main(String[] args) {
        System.out.println("** Simple Composite Example **");
        GraphicObject drawing = new GraphicObject();
        drawing.setName("My Drawing");
        drawing.children.add(new Square("Red"));
        drawing.children.add(new Circle("Yellow"));

        GraphicObject group = new GraphicObject();
        group.children.add(new Circle("Blue"));
        group.children.add(new Square("Blue"));

        drawing.children.add(group);

        System.out.println(drawing);
        System.out.println();


        System.out.println("** Neuron Composite Example **");
        Neuron neuron1 = new Neuron();
        Neuron neuron2 = new Neuron();
        NeuronLayer layer1 = new NeuronLayer();
        NeuronLayer layer2 = new NeuronLayer();

        neuron1.connectTo(neuron2);
//        Implementation of the following does not make sense:
//        neuron1.connectTo(layer1);
//        layer1.connectTo(neuron1);
//        layer2.connectTo(neuron2);

    }
}
