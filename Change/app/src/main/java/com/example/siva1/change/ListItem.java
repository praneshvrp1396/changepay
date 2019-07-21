package com.example.siva1.change;

public class ListItem {
    int id;
    String name;
    int year;
    String color;
    String pantone_value;

    @Override
    public String toString() {
        return "ListItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", pantone_value='" + pantone_value + '\'' +
                '}';
    }
}
