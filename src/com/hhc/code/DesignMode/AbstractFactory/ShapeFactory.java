package com.hhc.code.DesignMode.AbstractFactory;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape getShape(String shapeType) {
		// TODO Auto-generated method stub
		if(shapeType==null)
			return null;
		if(shapeType.equalsIgnoreCase("Circle")) {
			return new Circle();
		}
		if(shapeType.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		}
		if(shapeType.equalsIgnoreCase("Square")) {
			return new Square();
		}
		return null;
	}

}
