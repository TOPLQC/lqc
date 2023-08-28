package com.wnxy.day14;

import lombok.SneakyThrows;

import java.lang.reflect.Method;


public class MyApp {
    public static void main(String[] args) throws Exception {
        demo04();
    }

    @SneakyThrows
    public static void demo04() {
        String name = "add";
        Class<Tiger> clazz = Tiger.class;
        Method declaredMethod = clazz.getDeclaredMethod(name, Integer.class, Integer.class);
        Object invoke = declaredMethod.invoke(null, 10, 80);
        System.out.println("invoke = " + invoke);
    }


    //用户传入哪个方法名，我们就调用哪个方法。禁止使用if-else
    public static void demo03(String methodName) throws Exception {
        Tiger tiger = new Tiger();
        //1、获取字节码
        Class<?> clazz = tiger.getClass();
        //2、根据方法名称获取方法，
        //getDeclaredMethod方法要求参数1是目标方法的名称，后面要求提供参数的字节码(重载)，如果没有参数就空着
        //method就是我们要找的目标方法
        Method method = clazz.getDeclaredMethod(methodName);
        method.invoke(tiger);//激活，调用方法。如果是非静态方法，必须提供执行方法的对象
        //如果目标方法有参数，那么还需要在tiger后面加上实际的参数值
    }


    public static void demo02() {

    }

    @SneakyThrows
    public static void demo01() {
        String className = "com.wnxy.day14.Tiger";
        //通过className获取class字节码
        Class<?> clazz = Class.forName(className);

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("--------------------------------------------------------------------");
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println(declaredMethod.getName());
        }

        //通过class字节码new出对象使用
        Tiger tiger = (Tiger) clazz.newInstance();
    }
}
