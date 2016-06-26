package com.zte.shi.InitClass;

/**
 * Created by Administrator on 2016/6/25.
 */
public class InitClass {
    private String s;

    public static void main(String[] args) {
        System.out.println(new InitClass().getS());
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
