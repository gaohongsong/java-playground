package org.feichai.themyleaf;

import org.feichai.themyleaf.event.listeners.SpringStartEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThemyleafApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ThemyleafApplication.class);

        // 加入自定义监听类
        application.addListeners(new SpringStartEventListener());
        application.run(args);

        // SpringApplication.run(ThemyleafApplication.class, args);
    }

}
