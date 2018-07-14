package com.hhc.code.DesignMode.Singleton;
//ÀÁººÄ£Ê½
public class SingleObject {
	private static SingleObject instance = new SingleObject();
	private SingleObject() {};
	public static SingleObject getInstance() {
		return instance;
	}
	public void showMessage() {
		System.out.println("Hello World!");
	}
}
