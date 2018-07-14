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
        System.out.println(c1 == c2);//�жϵ�һ�ַ�ʽ��ȡ��Class����͵ڶ��ַ�ʽ��ȡ���Ƿ���ͬһ��
        System.out.println(c2 == c3);//�ж����ַ�ʽ�Ƿ��ȡ����ͬһ��Class����
        System.out.println("**********************���й��й��췽��*********************************");
        Constructor[] cArr = c3.getConstructors();
        for (Constructor c : cArr) {
            System.out.println(c);
        }
        System.out.println("************���еĹ��췽��(������˽�С��ܱ�����Ĭ�ϡ�����)***************");
        cArr = c3.getDeclaredConstructors();
        for (Constructor c : cArr) {
            System.out.println(c);
        }
        System.out.println("*****************��ȡ���С��޲εĹ��췽��*******************************");
        Constructor con = c3.getConstructor(null);
        System.out.println("con=" + con);
        Object obj = con.newInstance();
        System.out.println("******************��ȡchar���Ͳ������췽����������*******************************");
        con = c3.getDeclaredConstructor(char.class);
        System.out.println("con=" + con);
        con.setAccessible(true);
        obj = con.newInstance('��');


        System.out.println("************��ȡ���й��е��ֶ�********************");
        Field[] fArr = c3.getFields();
        for (Field f : fArr) {
            System.out.println(f);
        }
        System.out.println("************��ȡ���е��ֶ�(����˽�С��ܱ�����Ĭ�ϵ�)********************");
        fArr = c3.getDeclaredFields();
        for (Field f : fArr) {
            System.out.println(f);
        }
        System.out.println("*************��ȡ�����ֶ�**������***********************************");
        Field f = c3.getField("name");
        System.out.println(f);
        obj = c3.getConstructor().newInstance();
        f.set(obj, "hhc");
        Student s = (Student) obj;
        System.out.println("��֤������" + s.name);
        System.out.println("**************��ȡ˽���ֶ�****������********************************");
        f = c3.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true);//�������䣬���˽���޶�
        f.set(obj, "18888888888");
        System.out.println("��֤�绰��" + s.toString());


        System.out.println("***************��ȡ���еġ����С�����*******************");
        c3.getMethods();
        Method[] methodArray = c3.getMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }
        System.out.println("***************��ȡ���еķ���������˽�е�*******************");
        methodArray = c3.getDeclaredMethods();
        for (Method m : methodArray) {
            System.out.println(m);
        }
        System.out.println("***************��ȡ���е�show1()����*******************");
        Method m = c3.getMethod("show1", String.class);
        System.out.println(m);
        //ʵ����һ��Student����
        obj = c3.getConstructor().newInstance();
        m.invoke(obj, "���»�");

        System.out.println("***************��ȡ˽�е�show4()����******************");
        m = c3.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//���˽���޶�
        Object result = m.invoke(obj, 20);//��Ҫ����������һ����Ҫ���õĶ��󣨻�ȡ�з��䣩��һ����ʵ��
        System.out.println("����ֵ��" + result);


        Method methodMain = c3.getMethod("main", String[].class);//��һ���������������ƣ��ڶ��������������βε����ͣ�
        methodMain.invoke(null, (Object) new String[]{"a", "b", "c"});

        m = c3.getMethod(getValue("methodName"));//show
        m.invoke(c3.getConstructor().newInstance());


        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");
        Class listClass = strList.getClass(); //�õ� strList ������ֽ��� ����
        m = listClass.getMethod("add", Object.class);
        m.invoke(strList, 100);
        for(Object obj1 : strList){
            System.out.println(obj1);
        }
    }
    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();//��ȡ�����ļ��Ķ���
        FileReader in = new FileReader("G:/eclipse-workspace/����/src/com/hhc/java/Reflect/pro.txt");//��ȡ������
        pro.load(in);//�������ص������ļ�������
        in.close();
        return pro.getProperty(key);//���ظ���key��ȡ��valueֵ
    }
}
