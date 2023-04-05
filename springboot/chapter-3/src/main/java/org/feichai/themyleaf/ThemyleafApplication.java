package org.feichai.themyleaf;

import org.feichai.themyleaf.event.MyEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThemyleafApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ThemyleafApplication.class);

        // 加入自定义监听类
        application.addListeners(new MyEventListener());
        application.run(args);

        // SpringApplication.run(ThemyleafApplication.class, args);
    }

}
