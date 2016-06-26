package com.zte.shi.InitClass;

/**
 * Created by Administrator on 2016/6/25.
 */
class Base{
    private String b_private_s;
    String b_default_s;
    protected String b_protected_s;
    public String b_public_s;

    public String getB_private_s() {
        return b_private_s;
    }

    public void setB_private_s(String b_private_s) {
        this.b_private_s = b_private_s;
    }

    public String getB_default_s() {
        return b_default_s;
    }

    public void setB_default_s(String b_default_s) {
        this.b_default_s = b_default_s;
    }

    public String getB_protected_s() {
        return b_protected_s;
    }

    public void setB_protected_s(String b_protected_s) {
        this.b_protected_s = b_protected_s;
    }

    public String getB_public_s() {
        return b_public_s;
    }

    public void setB_public_s(String b_public_s) {
        this.b_public_s = b_public_s;
    }

    public Base(String b_private_s, String b_default_s, String b_protected_s, String b_public_s) {
        this.b_private_s = b_private_s;
        this.b_default_s = b_default_s;
        this.b_protected_s = b_protected_s;
        this.b_public_s = b_public_s;
    }

    public Base() {
    }

    public Base(String s) {
        this.b_private_s = s;
    }

    public void run(String str){
        System.out.println("str:"+this);
    }

    @Override
    public String toString() {
        return "Base{" +
                "b_private_s='" + b_private_s + '\'' +
                ", b_default_s='" + b_default_s + '\'' +
                ", b_protected_s='" + b_protected_s + '\'' +
                ", b_public_s='" + b_public_s + '\'' +
                '}';
    }
}

class Sub extends Base{
    private String s_private_s;
    String s_default_s;
    protected String s_protected_s;
    public String s_public_s;

    public Sub(String b_private_s, String b_default_s, String b_protected_s, String b_public_s, String s_private_s, String s_default_s, String s_protected_s, String s_public_s) {
        super(b_private_s, b_default_s, b_protected_s, b_public_s);
        this.s_private_s = s_private_s;
        this.s_default_s = s_default_s;
        this.s_protected_s = s_protected_s;
        this.s_public_s = s_public_s;
    }

    public Sub(String s_private_s, String s_default_s, String s_protected_s, String s_public_s) {
        this.s_private_s = s_private_s;
        this.s_default_s = s_default_s;
        this.s_protected_s = s_protected_s;
        this.s_public_s = s_public_s;
    }

    public void run(String str){
        System.out.println("str::"+super.toString());
        System.out.println("str::"+this);
    }

    public String getS_private_s() {
        return s_private_s;
    }

    public void setS_private_s(String s_private_s) {
        this.s_private_s = s_private_s;
    }

    public String getS_default_s() {
        return s_default_s;
    }

    public void setS_default_s(String s_default_s) {
        this.s_default_s = s_default_s;
    }

    public String getS_protected_s() {
        return s_protected_s;
    }

    public void setS_protected_s(String s_protected_s) {
        this.s_protected_s = s_protected_s;
    }

    public String getS_public_s() {
        return s_public_s;
    }

    public void setS_public_s(String s_public_s) {
        this.s_public_s = s_public_s;
    }

    @Override
    public String toString() {
        return "Sub{" +
                "s_private_s='" + s_private_s + '\'' +
                ", s_default_s='" + s_default_s + '\'' +
                ", s_protected_s='" + s_protected_s + '\'' +
                ", s_public_s='" + s_public_s + '\'' +
                '}';
    }
}
public class TestImplement {
    public static void main(String[] args) {
        System.out.println(args[0]);
        Base b = new Sub("s_private","s_default","s_protected","s_public");
        Base b1 = new Sub("b_private","b_default","b_protected","b_public","s_private","s_default","s_protected","s_public");
        b.run("init without base");
        b1.run("init with base");
    }
}
