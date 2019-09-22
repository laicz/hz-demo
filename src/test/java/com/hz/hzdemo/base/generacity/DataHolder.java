package com.hz.hzdemo.base.generacity;

/**
 * 使用泛型来包装对象，泛型可以使用一个 也可以使用多个
 * Create by zhoumingbing on 2019-05-16
 */
public class DataHolder<T>{

    T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public <E> void printInfo(E e) {
        System.out.println(e);
    }
}
