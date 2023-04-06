package org.feichai.patterns.adapter;


/**
 * Adaptee的适配器类，内部包装了一个Adaptee对象
 */
public class Adapter implements Target {
    private final Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
