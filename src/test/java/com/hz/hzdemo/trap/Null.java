package com.hz.hzdemo.trap;

/**
 * Create by zhoumingbing on 2019-05-09
 */
public class Null {
    public static void  greet(){
        System.out.println("Hello, my name is Null");
    }

    public static void main(String[] args) {
        Null x = null;
        x.greet();
        ((Null)x).greet();
        ((Null)null).greet();
    }
}
