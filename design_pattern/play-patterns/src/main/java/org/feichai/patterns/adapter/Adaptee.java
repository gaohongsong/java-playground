package org.feichai.patterns.adapter;

/**
 * 需要适配的类，提供了不一致的request方法
 */
public class Adaptee {
    public void specificRequest() {
        System.out.println("特殊请求!");
    }
}
