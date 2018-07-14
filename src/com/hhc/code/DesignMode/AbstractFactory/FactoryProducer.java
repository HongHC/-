package com.hhc.code.DesignMode.AbstractFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String Choice) {
		if(Choice.equalsIgnoreCase("Shape"))
			return new ShapeFactory();
		if(Choice.equalsIgnoreCase("Color"))
			return new ColorFactory();
		return null;
	}
}
