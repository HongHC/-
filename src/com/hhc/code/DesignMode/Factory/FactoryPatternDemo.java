package com.hhc.code.DesignMode.Factory;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeFactory s = new ShapeFactory();
		Shape s1 = s.getShape("Circle");
		s1.draw();
		Shape s2 = s.getShape("Rectangle");
		s2.draw();
		Shape s3 = s.getShape("Square");
		s3.draw();
	}
}
