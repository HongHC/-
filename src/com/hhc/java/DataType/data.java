package com.hhc.java.DataType;
//boolean(true,false),byte(-128,127),short(-32768,32767),int(-2147483648,2147483647)
//long(-9223372036854775808,9223372036854775807),char('\u0000' ,'\uffff')
//float(1.4E-45,3.4028235E38),double(4.9E-324,1.7976931348623157E308)
//boolean
//char<强制转换>Short
//byte->short->int->long->float->double
public class data {
    static boolean bo =  true;
    static byte by = 100;//-128,127
    static short sh = 50;
    static char ch = 'F';
    static int in = 150;
    static long lo = 200;
    static float fl = 200.5f;
    static double dou = 250.5;
    public static void main(String[] args){
        System.out.println("boolean bo:"+bo);
        System.out.println("byte by:"+by);
        System.out.println("short sh:"+sh);
        System.out.println("char ch:"+ch);
        System.out.println("int in:"+in);
        System.out.println("long lo:"+lo);
        System.out.println("float fl:"+fl);
        System.out.println("double dou:"+dou);
        short sh1 = by;
        short sh2 = (short)ch;
        char ch1 = (char)sh;
        int in1 = sh;
        int in2 = ch;
        long lo1 = in;
        float fl1 = lo;
        double dou1 = fl;
        System.out.println("short sh1:"+sh1);
        System.out.println("short sh2:"+sh2);
        System.out.println("char ch1:"+ch1);
        System.out.println("int in1:"+in1);
        System.out.println("int in2:"+in2);
        System.out.println("long lo1:"+lo1);
        System.out.println("float fl1:"+fl1);
        System.out.println("double dou1:"+dou1);
    }


}
