package org.feichai.themyleaf.event;

import org.feichai.themyleaf.model.Result;
import org.springframework.context.ApplicationEvent;

/**
 * 自定事件类：MyCustomEvent
 */
public class MyCustomEvent extends ApplicationEvent {
    private Result result;
    public MyCustomEvent(Object source, Result result) {
        super(source);
        this.result = result;
    }

    public Result getResult() {
        return this.result;
    }
}
