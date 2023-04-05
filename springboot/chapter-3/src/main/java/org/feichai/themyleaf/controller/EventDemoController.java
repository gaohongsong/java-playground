package org.feichai.themyleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.feichai.themyleaf.event.MyCustomEvent;
import org.feichai.themyleaf.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/event")
public class EventDemoController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * 发布自定义事件
     * http://localhost:8080/event/pushEvent?code=1&message=test
     * @param code 错误码
     * @param message 消息
     * @return 提示信息
     */
    @GetMapping("/pushEvent")
    public String pushEvent(@RequestParam("code") Integer code,@RequestParam("message")  String message) {
        log.info("Published Event: code={}, message={}", code, message);
        Result<Object> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);

        eventPublisher.publishEvent(result);
        eventPublisher.publishEvent(new MyCustomEvent("#publishEvent", result));
        return "publish success";
    }
}
