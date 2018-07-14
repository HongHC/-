package com.hhc.java.Static;
//静态成员变量在类加载时初始化，普通成员变量在new对象时初始化
public class Person {
    Book book1 = new Book("book1");
    static Book book2;

    static {
        book2 = new Book("static:book2");
        book4 = new Book("static:book4");
    }

    public Person(String msg) {
        System.out.println(msg);
    }

    Book book3 = new Book("book3");
    static Book book4;

    public static void funStatic() {
        System.out.println("static:funStatic");
    }

    public static void main(String[] args) {
        Person.funStatic();
        System.out.println("****************");
        Person p1 = new Person("p1");
    }
}
