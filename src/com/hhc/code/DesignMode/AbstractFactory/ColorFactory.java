package com.hhc.code.DesignMode.AbstractFactory;

public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(String colorType) {
		// TODO Auto-generated method stub
		if(colorType==null)
			return null;
		if(colorType.equalsIgnoreCase("Red"))
			return new Red();
		if(colorType.equalsIgnoreCase("Blue"))
			return new Blue();
		if(colorType.equalsIgnoreCase("Green"))
			return new Green();
		return null;
	}

	@Override
	public Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

}
