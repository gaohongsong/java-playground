package org.feichai.patterns;

// 饿汉式单例
public class Singleton {
    private static final Singleton singleton = new Singleton();

    // 将构造方法设置为private，禁止外部创建对象
    private Singleton() {
    }

    public static Singleton getSingleton() {
        return singleton;
    }

    public void doSomething() {
        System.out.println("do something...");
    }
}
