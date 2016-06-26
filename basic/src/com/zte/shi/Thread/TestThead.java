package com.zte.shi.Thread;

/**
 * Created by Administrator on 2016/6/25.
 */
class T1 extends Thread{}
class T2 extends T1{}
class T3 implements Runnable{
    //class T3 must either be declared abstract or implement abstract method 'run()' in Runnable
    @Override
    public void run() {

    }

}
public class TestThead {
    public static void main(String[] args) {
        new T1().start();
        new T2().start();
        new Thread(new T3()).start();
        System.out.println("end");
    }
}
