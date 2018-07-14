package com.hhc.code.DesignMode.Prototype;

public class Circle extends Shape {
    public Circle(){
        type = "Square";
    }
    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
