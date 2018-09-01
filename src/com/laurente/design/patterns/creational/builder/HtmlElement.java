package com.laurente.design.patterns.creational.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HtmlElement {
    public String name, text;
    public List<HtmlElement> elements = new ArrayList<>();
    private final int INDENT_SIZE = 2;
    private final String newLine = System.lineSeparator();

    public HtmlElement() {
    }

    public HtmlElement(String name, String text) {
        this.name = name;
        this.text = text;
    }

    private String toStringImpl(int indent) {
        if (name == null || name.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String indentation = String.join("", Collections.nCopies(indent * INDENT_SIZE, " "));
        sb.append(String.format("%s<%s>%s", indentation, name, newLine));
        if (text != null && !text.isEmpty()) {
            sb.append(String.join("", Collections.nCopies((indent + 1) * INDENT_SIZE, " ")))
                    .append(text)
                    .append(newLine);
        }

        for (HtmlElement e : elements) {
            sb.append(e.toStringImpl(indent + 1));
        }
        sb.append(String.format("%s</%s>%s", indentation, name, newLine));
        return sb.toString();
    }

    @Override
    public String toString() {
        return toStringImpl(0);
    }
}
