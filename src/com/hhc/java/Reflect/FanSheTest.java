package com.hhc.java.Reflect;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class FanSheTest {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Class c1 = (new Student()).getClass();
        Class c2 = Student.class;
        Class c3 = Class.forName("com.hhc.java.Reflect.Student");
        System.out.println(c1.getName());
        System.out.println(c1 == c2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个
        System.out.println(c2 == c3);//判断三种方式是否获取的是同一个Class对象
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] cArr = c3.getConstructors();
        for (Constructor c : cArr) {
            System.out.println(c);
        }
        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        cArr = c3.getDeclaredConstructors();
        for (Constructor c : cArr) {
            System.out.println(c);
        }
        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor con = c3.getConstructor(null);
        System.out.println("con=" + con);
        Object obj = con.newInstance();
        System.out.println("******************获取char类型参数构造方法，并调用*******************************");
        con = c3.getDeclaredConstructor(char.class);
        System.out.println("con=" + con);
        con.setAccessible(true);
        obj = con.newInstance('男');


        System.out.println("************获取所有公有的字段********************");
        Field[] fArr = c3.getFields();
        for (Field f : fArr) {
            System.out.println(f);
        }
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fArr = c3.getDeclaredFields();
        for (Field f : fArr) {
            System.out.println(f);
        }
        System.out.println("*************获取公有字段**并调用***********************************");
        Field f = c3.getField("name");
        System.out.println(f);
        obj = c3.getConstructor().newInstance();
        f.set(obj, "hhc");
        Student s = (Student) obj;
        System.out.println("验证姓名：" + s.name);
        System.out.println("**************获取私有字段****并调用********************************");
        f = c3.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定
        f.set(obj, "18888888888");
        System.out.println("验证电话：" + s.toString());


        System.out.println("***************获取所有的”公有“方法*******************");
        c3.getMethods();
        Method[] methodArray = c3.getMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }
        System.out.println("***************获取所有的方法，包括私有的*******************");
        methodArray = c3.getDeclaredMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }
        System.out.println("***************获取公有的show1()方法*******************");
        Method m = c3.getMethod("show1", String.class);
        System.out.println(m);
        //实例化一个Student对象
        obj = c3.getConstructor().newInstance();
        m.invoke(obj, "刘德华");

        System.out.println("***************获取私有的show4()方法******************");
        m = c3.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result = m.invoke(obj, 20);//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);


        Method methodMain = c3.getMethod("main", String[].class);//第一个参数：方法名称，第二个参数：方法形参的类型，
        methodMain.invoke(null, (Object) new String[]{"a", "b", "c"});

        m = c3.getMethod(getValue("methodName"));//show
        m.invoke(c3.getConstructor().newInstance());


        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");
        Class listClass = strList.getClass(); //得到 strList 对象的字节码 对象
        m = listClass.getMethod("add", Object.class);
        m.invoke(strList, 100);
        for(Object obj1 : strList){
            System.out.println(obj1);
        }
    }
    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();//获取配置文件的对象
        FileReader in = new FileReader("G:/eclipse-workspace/秋招/src/com/hhc/java/Reflect/pro.txt");//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }
}
