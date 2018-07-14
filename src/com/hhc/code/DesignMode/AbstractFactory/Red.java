package com.hhc.code.DesignMode.AbstractFactory;

public class Red implements Color{
	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}
