package com.hz.hzdemo.base.generacity;

import org.junit.Test;
import org.springframework.core.BridgeMethodResolver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Create by zhoumingbing on 2019-05-15
 */
public class GenericityTest {

    @Test
    public void testObject() {
        List<Object> list = new ArrayList<>();
        list.add("String");
        list.add(1);
        list.add(new HashMap<>());

        List list1 = new ArrayList();
        list1.add("String");
        list1.add(1);
        list1.add(new HashMap<>());

        Object[] objects = new Object[10];
        objects[0] = "String";
        objects[1] = 1;
        objects[2] = new HashMap<>();
    }

    @Test
    public void testDataHolder() {
        DataHolder<String> dataHolder = new DataHolder<>();
        dataHolder.printInfo(1);
        dataHolder.printInfo("AAAAA");
        dataHolder.printInfo(8.88f);
    }

    @Test
    public void bridgeTest() throws InvocationTargetException, IllegalAccessException {
        //获取到当前类的定义的所有的方法
        Class<StringGenerator> clazz = StringGenerator.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        System.out.println("---------------------------------");
        //获取到所有的公共方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        //子类继承具体的泛型父类，会将泛型方法重新生成一个具体的方法，而泛型方法(Object)则会生成一个桥接方法
        StringGenerator stringGenerator = new StringGenerator();
        for (Method method : methods) {
            if (method.isBridge()){
                System.out.println("name : " + method.getName() + "   ，return:  " + method.getReturnType());
                method.invoke(stringGenerator,"hello");
                Method bridgedMethod = BridgeMethodResolver.findBridgedMethod(method);
                System.out.println("name : " + bridgedMethod.getName() + "   ，return:  " + bridgedMethod.getReturnType());

            }
        }

        System.out.println("--------------------------------");
        //调用桥接方法
        stringGenerator.next("1212121");
    }

    @Test
    public void list(){
        List<String> list = new ArrayList<>();
        list.add("哈");
        list.add("喝");
    }
}
