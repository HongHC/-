package com.hhc.code.DesignMode.Factory;

public class ShapeFactory {
	public Shape getShape(String ShapeType) {
		if(ShapeType==null)
			return null;
		if(ShapeType.equalsIgnoreCase("Circle")) {
			return new Circle();
		}
		if(ShapeType.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		}
		if(ShapeType.equalsIgnoreCase("Square")) {
			return new Square();
		}
		return null;
	}
}
