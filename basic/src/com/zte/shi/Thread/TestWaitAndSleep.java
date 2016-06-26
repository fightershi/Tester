package com.zte.shi.Thread;

/**
 * Created by Administrator on 2016/6/26.
 */
public class TestWaitAndSleep {
    public static void main(String[] args) {

    }
}
class MyThead implements Runnable{
    @Override
    public void run() {
        
    }
}
class Test{
    private int i;
    private String s;

    @Override
    public String toString() {
        return "Test{" +
                "i=" + i +
                ", s='" + s + '\'' +
                '}';
    }

    public Test(int i, String s) {
        this.i = i;
        this.s = s;
    }

    public int getI() {

        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
