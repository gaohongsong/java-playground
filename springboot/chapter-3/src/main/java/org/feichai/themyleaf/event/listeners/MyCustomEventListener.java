package org.feichai.themyleaf.event.listeners;

import lombok.extern.slf4j.Slf4j;
import org.feichai.themyleaf.event.MyCustomEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyCustomEventListener implements ApplicationListener<MyCustomEvent> {
    @Override
    public void onApplicationEvent(MyCustomEvent event) {
        log.error("handle MyCustomEvent: result={}, time={}", event.getResult(), event.getTimestamp());
    }
}
