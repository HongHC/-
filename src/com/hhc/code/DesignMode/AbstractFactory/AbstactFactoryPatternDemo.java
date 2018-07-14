package com.hhc.code.DesignMode.AbstractFactory;

public class AbstactFactoryPatternDemo {
	public static void main(String[] args) {
		AbstractFactory as = FactoryProducer.getFactory("Shape"); 
		Shape as1 = as.getShape("Circle");
		as1.draw();
		Shape as2 = as.getShape("Rectangle");
		as2.draw();
		Shape as3 = as.getShape("Square");
		as3.draw();
		AbstractFactory ac = FactoryProducer.getFactory("Color");
		Color ac1 = ac.getColor("Red");
		ac1.fill();
		Color ac2 = ac.getColor("Blue");
		ac2.fill();
		Color ac3 = ac.getColor("Green");
		ac3.fill();
	} 
}
