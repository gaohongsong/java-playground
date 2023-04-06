package org.feichai;

import org.feichai.patterns.Singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        testSingleton();
    }

    public static void testSingleton() {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();

        //java: Singleton() 在 org.feichai.patterns.Singleton 中是 private 访问控制
        // Singleton singleton3 = new Singleton();

        singleton1.doSomething();
        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}
