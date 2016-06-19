package com.zte.shi.TestEqualAndHashCode;

import java.util.Random;

/**
 * Created by Administrator on 2016/6/19.
 */
public class TestMyUnit {
    public static char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
            +"ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public static void main(String[] args) throws CloneNotSupportedException {
        //MyUnit mu1 = new MyUnit();
        TestUnit();
        TestUnit2();
        TestString();
        Test_MyUnit();
    }

    private static void Test_MyUnit() throws CloneNotSupportedException{
        System.out.println("TestMyUnit start................");
        /*short s = 1;
        double d = 10d;*/
        Unit u = new Unit(1,"abc");
        Unit[] units = genUnits();
        int[] ints = new int[]{1,2,3};
        MyUnit mu1 = new MyUnit((short)1,'a',(byte)1,false,12L,11f,10d,u,units,ints);
        MyUnit mu3 = mu1;
        System.out.println(mu1.equals(mu3));
        MyUnit mu2 = (MyUnit) mu1.clone();
        System.out.println(mu1);
        System.out.println(mu2);
        System.out.println(mu1.equals(mu2));

        mu1.getUnits()[1].setStr("Test");
        mu1.getUnits()[1].setI(1111);
        //mu1.getInts()[1]=1111;
        System.out.println(mu1);
        System.out.println(mu2);
        System.out.println(mu1.equals(mu2));
        System.out.println("TestMyUnit end..................");
    }

    private static Unit[] genUnits() {
        Unit[] units = new Unit[10];
        Random r = new Random();
        for(int i=0;i<10;i++){
            int j = r.nextInt(10)+2;
            units[i]=new Unit(j,genString(j,r));
        }
        for(Unit u:units){
            System.out.println("int:"+u.getI()+"| str:"+u.getStr());
        }
        /*for(Unit u:units){
            u.setI(r.nextInt());
        }*/
        return units;
    }

    private static void TestString() {
        String str1 = "12346";
        String str2 = "12346";
        System.out.println(str1 == str2);
    }

    private static void TestUnit2() throws CloneNotSupportedException {
        System.out.println("TestUnit2 start................");
        StringBuffer sb = new StringBuffer("Unit2");
        Unit2 u21 = new Unit2(sb);
        Unit2 u22 = new Unit2(sb);
        Unit2 u23 = (Unit2) u21.clone();
        sb.append("111");
        System.out.println(u21);
        System.out.println(u22);
        System.out.println(u23);
        System.out.println(u21.equals(u22));
        u21.setSb(new StringBuffer("Unit222"));
        System.out.println(u23);
        System.out.println("TestUnit2 end..................");
    }

    private static void TestUnit() throws CloneNotSupportedException {
        System.out.println("TestUnit start................");
        Unit u1 = new Unit(1, "firstSet");
        Unit u2 = new Unit(1, new String("firstSet"));
        System.out.println(u1.hashCode());
        System.out.println(u1.equals(u2));
        Unit u3 = (Unit) u1.clone();
        System.out.println(u1.equals(u3));
        u3.setStr("secondSet");
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println("TestUnit end..................");
    }
    public static String genString(int length,Random random){
        char[] c = new char[length];
        /*for(char cc:c){  //为什么不可以
            cc = numbersAndLetters[random.nextInt(61)];
        }*/
        for(int i=0;i<c.length;i++){
            c[i] = numbersAndLetters[random.nextInt(61)];
        }
        return String.valueOf(c);
    }
}
