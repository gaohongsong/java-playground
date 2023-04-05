package org.feichai.themyleaf.config;

import lombok.extern.slf4j.Slf4j;
import org.feichai.themyleaf.event.MyCustomEvent;
import org.feichai.themyleaf.model.Result;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * 全局事件监听器配置
 * http://localhost:8080/event/pushEvent?code=1&message=test
 * 23:12:17 INFO  o.f.t.controller.EventDemoController - Published Event: code=1, message=test
 * 23:12:17 INFO  o.f.t.config.EventListenerConfig - Global handle ObjectEvent: Result(message=test, code=1, data=null)
 * 23:12:17 INFO  o.f.t.config.EventListenerConfig - Global handle ResultEvent: Result(message=test, code=1, data=null)
 * 23:12:17 ERROR o.f.t.event.MyCustomEventListener - handle MyCustomEvent: result=Result(message=test, code=1,
 * data=null), time=1680707537009
 * 23:12:17 INFO  o.f.t.config.EventListenerConfig - Global handle ObjectEvent: org.feichai.themyleaf.event
 * .MyCustomEvent[source=#publishEvent]
 * 23:12:17 WARN  o.f.t.config.EventListenerConfig - Global handle MyCustomEvent: result=Result(message=test, code=1,
 * data=null), time=1680707537009
 */
@Slf4j
@Configuration
public class EventListenerConfig {
    @EventListener
    public void handleEvent(Object event) {
        log.info("Global handle ObjectEvent: {}", event);
    }

    @EventListener
    public void handleResultEvent(Result result) {
        log.info("Global handle ResultEvent: {}", result);
    }

    /**
     * 全局有条件事件监听处理
     * http://localhost:8080/api/hello?name=pitou&age=1
     *
     * @param event MyCustomEvent事件
     */
    @EventListener(condition = "#event.result.code != 0")
    public void handleCustomEvent(MyCustomEvent event) {
        log.warn("Global handle MyCustomEvent: result={}, time={}", event.getResult(), event.getTimestamp());
    }
}
