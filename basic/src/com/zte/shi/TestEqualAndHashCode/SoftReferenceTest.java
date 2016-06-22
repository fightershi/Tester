package com.zte.shi.TestEqualAndHashCode;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Crreated by Administrator on 2016/6/21.
 */
class InstanceClass {
    @Override
    public String toString() {
        return "InstanceClass{" +
                "i=" + i +
                ", str='" + str + '\'' +
                '}';
    }

    public int i;
    public String str;

    public InstanceClass(int i, String str) {
        this.i = i;
        this.str = str;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
public class SoftReferenceTest {
    private static InstanceClass  ic = new InstanceClass(9527,"tester");
    private static SoftReference sr = new SoftReference(ic);

    public static void main(String[] args){
        InstanceClass ic1;
        ic1 = testSoftReference(sr);
        System.out.println(ic.getI()+ic.getStr());
        testSoftReferenceAndWeakReference();
    }

    private static void testSoftReferenceAndWeakReference() {
        /*
        SoftReference :对象当没有直接引用指向它的时候不会被垃圾收集器清除，只有JVM内存不足的时候，才会被清除
        软引用是用来设计object-cache的。软引用的释放：*.clear()
        WeakReference :当gc遇到弱可及的对象，释放弱引用，收集该对象。
         */
        InstanceClass ic1 = new InstanceClass(111,"111");
        InstanceClass ic2 = new InstanceClass(222,"222");
        SoftReference<InstanceClass> sr = new SoftReference<InstanceClass>(ic1);
        WeakReference<InstanceClass> wr = new WeakReference<InstanceClass>(ic2);
        ic1 = null;
        ic2 = null;
        System.out.println("Before gc:");
        System.out.println("soft:"+sr.get()+"|weak:"+wr.get());
        System.gc();
        System.out.println("After gc:");
        System.out.println("soft:"+sr.get()+"|weak:"+wr.get());

        sr.clear();
        System.out.println("After release softReference:");
        System.out.println("soft:"+sr.get()+"|weak:"+wr.get());

    }

    public static InstanceClass testSoftReference(SoftReference sr){
        InstanceClass obj;
        if(sr!=null){
            obj = (InstanceClass) sr.get();
        }else
            return null;
        return obj;
    }
}
