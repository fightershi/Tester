package com.zte.shi.Arithmetic;

/**
 * Created by Administrator on 2016/6/25.
 */
public class Arithmetic {
    public static void main(String[] args) {
        double num=7.4;
        int a=(int)Math.abs(num+0.5);//绝对值
        int b=(int)Math.ceil(num+0.5);//四舍五入
        int c=(int)Math.floor(num+0.5);//小于的最大整数
        int d=(int)Math.round(num+0.5);//大于的最小整数
        int e=(int)Math.round(num-0.5);
        int f=(int)Math.floor(num-0.5);
        int g=(int)Math.ceil(num-0.5);
        int h=(int)Math.abs(num-0.5);
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("c="+c);
        System.out.println("d="+d);
        System.out.println("e="+e);
        System.out.println("f="+f);
        System.out.println("g="+g);
        System.out.println("h="+h);
        int a3[][] = new int[3][3];
        int []a4[] = new int[3][3];
        int [][]a5 = new int[3][3];
        int[] []a6 = new int[3][];
    }
}
