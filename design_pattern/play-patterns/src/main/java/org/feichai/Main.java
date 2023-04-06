package org.feichai;

import org.feichai.patterns.Singleton;
import org.feichai.patterns.adapter.Adapter;
import org.feichai.patterns.adapter.Target;

public class Main {
    public static void main(String[] args) {
        testSingleton();
        testAdapter();
    }

    public static void testAdapter() {
        System.out.println("run testAdapter");
        Target target = new Adapter();
        target.request();
        System.out.println("-------------------------------");
    }

    public static void testSingleton() {
        System.out.println("run testSingleton");
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();

        //java: Singleton() 在 org.feichai.patterns.Singleton 中是 private 访问控制
        // Singleton singleton3 = new Singleton();

        singleton1.doSomething();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println("-------------------------------");
    }
}
