package com.zte.shi.TestEqualAndHashCode;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Administrator on 2016/6/19.
 */

/*
如何覆写equals()和hashcode

覆写equals方法
1  使用instanceof操作符检查“实参是否为正确的类型”。
2  对于类中的每一个“关键域”，检查实参中的域与当前对象中对应的域值。
3. 对于非float和double类型的原语类型域，使用==比较；
4  对于对象引用域，递归调用equals方法；
5  对于float域，使用Float.floatToIntBits(afloat)转换为int，再使用==比较；
6  对于double域，使用Double.doubleToLongBits(adouble)转换为int，再使用==比较；
7  对于数组域，调用Arrays.equals方法。
覆写hashcode
1. 把某个非零常数值，例如17，保存在int变量result中；
2. 对于对象中每一个关键域f（指equals方法中考虑的每一个域）：
3, boolean型，计算(f? 0 : 1);
4. byte,char,short型，计算(int);
5. long型，计算(int)(f ^ (f>>>32));
6. float型，计算Float.floatToIntBits(afloat);
7. double型，计算Double.doubleToLongBits(adouble)得到一个long，再执行[2.3];
8. 对象引用，递归调用它的hashCode方法;
9. 数组域，对其中每个元素调用它的hashCode方法。
10. 将上面计算得到的散列码保存到int变量c，然后执行result=37*result+c;
11. 返回result。
 */

/*
   深拷贝与浅拷贝， 如果对象中有引用类型，就要用深拷贝（String除外，在java中，String是不可变的）
   ，以防止拷贝前后的对象所共同指向的对象被改变了。
*/
class Unit2 implements Cloneable{
    private StringBuffer sb;
    public Unit2(){

    }
    public Unit2(StringBuffer sb){
        this.sb = sb;
    }
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    public StringBuffer getSb(){
        return this.sb;
    }
    public void setSb(StringBuffer sb){
        this.sb = sb;
    }
    public boolean equals(Object o){
        if(!(o instanceof Unit2))
            return false;
        Unit2 u2= (Unit2)o;
        return u2.sb.equals(sb);
    }
    public int hashCode(){
        int result = 17;
        result = 31 * result + sb.hashCode();
        return result;
    }

    public String toString(){
        return "HashCode:"+hashCode()
                +"|sb:"+getSb();
    }
}
class Unit implements Cloneable {
    private int i;
    private String str;

    public Unit(int i,String str){
        this.i = i;
        this.str = str;
    }
    public boolean equals(Object o){
        if(!(o instanceof Unit))
            return false;
        Unit instance = (Unit)o;
        return instance.i==i
                && instance.str.equals(str);
    }

    public int hashCode(){
        int result=17;
        result = 31 * result+i;
        result = 31 * result+str.hashCode();
        return result;
    }
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
    public int getI(){
        return this.i;
    }
    public String getStr(){
        return this.str;
    }
    public void setI(int i){
        this.i = i;
    }
    public void setStr(String str){
        this.str = str;
    }
   /* public String toString(){
        return "HashCode:"+hashCode()
                +"|i:"+getI()
                +"|str:"+getStr();
    }*/

    @Override
    public String toString() {
        return "Unit{" +
                "i=" + i +
                ", str='" + str + '\'' +
                '}';
    }
}
public class MyUnit implements Cloneable {
    private short aShort;
    private char aChar;
    private byte aByte;
    private boolean aBoolean;
    private long aLong;
    private float aFloat;
    private double aDouble;
    private Unit aUnit;
    private Unit[] units;
    private int[] ints;

    public MyUnit(short s,char c,byte by,boolean bo,long l,float f, double d,Unit u,Unit[] us,int[] is){
        aShort = s;
        aChar = c;
        aByte = by;
        aBoolean = bo;
        aLong = l;
        aFloat = f;
        aDouble = d;
        aUnit = u;
        units = us.clone();
        ints = is;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof MyUnit))
            return false;
        MyUnit instance = (MyUnit)o;
        /*System.out.println("Arrays.equals(units,instance.units):"+Arrays.equals(units,instance.units));
        System.out.println("aUnit.equals(instance.aUnit):"+aUnit.equals(instance.aUnit));
        System.out.println("Arrays.equals(ints,instance.ints):"+Arrays.equals(ints,instance.ints));
        System.out.println("Float.floatToIntBits(aFloat)==aFloat:"+(Float.floatToIntBits(aFloat)==aFloat));
        System.out.println("Double.doubleToLongBits(aDouble)==aDouble:"+(Double.doubleToLongBits(aDouble)==aDouble));*/
        return instance.aShort==aShort
                && instance.aChar==aChar
                && instance.aBoolean==aBoolean
                && instance.aByte==aByte
                && instance.aLong==aLong
                && Float.floatToIntBits(instance.aFloat)==Float.floatToIntBits(aFloat)
                && Double.doubleToLongBits(instance.aDouble)==Double.doubleToLongBits(aDouble)
                && Arrays.equals(ints,instance.ints)
                && aUnit.equals(instance.aUnit)
                && Arrays.equals(units,instance.units);
    }

    public int hashCode(){
        int result = 17;
        result = 31 * result + (int)aShort;
        result = 31 * result + (int)aChar;
        result = 31 * result +(aBoolean ? 1 : 0);
        result = 31 * result + (int)aByte;
        result = 31 * result + (int)(aLong ^ (aLong >>> 32));
        result = 31 * result + Float.floatToIntBits(aFloat);
        long toLong  = Double.doubleToLongBits(aDouble);
        result = 31 * result + (int)(toLong ^ (toLong >>> 32));
        result = 31 * result + intsHashCode(ints);
        result = 31 * result + unitsHashCode(units);
        return result;
    }

    @Override
    public String toString() {
        return "MyUnit{" +
                "aShort=" + aShort +
                ", aChar=" + aChar +
                ", aByte=" + aByte +
                ", aBoolean=" + aBoolean +
                ", aLong=" + aLong +
                ", aFloat=" + aFloat +
                ", aDouble=" + aDouble +
                ", aUnit=" + aUnit +
                ", units=" + Arrays.toString(units) +
                ", ints=" + Arrays.toString(ints) +
                '}';
    }

    public int intsHashCode(int[] ints){
         int result=17;
         for(int i:ints){
             result = 31 * result + i;
         }
         return result;
     }

    public int unitsHashCode(Unit[] units){
        int result = 17;
        for(Unit u:units){
            result = 31 * result + u.hashCode();
        }
        return result;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    public byte getaByte() {
        return aByte;
    }

    public void setaByte(byte aByte) {
        this.aByte = aByte;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public long getaLong() {
        return aLong;
    }

    public void setaLong(long aLong) {
        this.aLong = aLong;
    }

    public float getaFloat() {
        return aFloat;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public Unit getaUnit() {
        return aUnit;
    }

    public void setaUnit(Unit aUnit) {
        this.aUnit = aUnit;
    }

    public Unit[] getUnits() {
        return units;
    }

    public void setUnits(Unit[] units) {
        this.units = units;
    }

    public int[] getInts() {
        return ints;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    public short getaShort() {
        return aShort;
    }

    public void setaShort(short aShort) {
        this.aShort = aShort;
    }

    public Object clone() throws CloneNotSupportedException{
        MyUnit mu = (MyUnit)super.clone();
        mu.setaUnit((Unit) mu.getaUnit().clone());
        mu.setInts(mu.getInts().clone());
        mu.setUnits(mu.getUnits().clone());
        return mu;
    }
}
