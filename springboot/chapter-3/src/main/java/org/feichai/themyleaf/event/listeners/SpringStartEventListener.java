package org.feichai.themyleaf.event.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 事件监听：ApplicationStartedEvent
 * 21:57:54 WARN  o.f.themyleaf.event.MyEventListener - ApplicationStartedEvent published at 2023-04-05 21:57:54
 */
@Slf4j
public class SpringStartEventListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
        log.warn("ApplicationStartedEvent published at {}", fmt.format(new Date(event.getTimestamp())));
        // System.out.printf("ApplicationStartedEvent published at %s", fmt.format(new Date(event.getTimestamp())));
    }
}
