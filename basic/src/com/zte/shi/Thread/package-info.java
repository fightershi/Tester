/**
 * Created by Administrator on 2016/6/26.
 *
 * wait有两种形式wait()和wait(milliseconds).
 sleep和wait的区别有：
 1，这两个方法来自不同的类分别是Thread和Object
 2，最主要是sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法。
 3，wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在
 任何地方使用
 synchronized(x){
 x.notify()
 //或者wait()
 }
 4,sleep必须捕获异常，而wait，notify和notifyAll不需要捕获异常
 */
package com.zte.shi.Thread;