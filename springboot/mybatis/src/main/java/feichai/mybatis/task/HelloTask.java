package feichai.mybatis.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@EnableScheduling
@Component
public class HelloTask {
    private static final DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // second minute hour day month week year
    // run cron every 15 seconds
    @Scheduled(cron = "*/15 * * * * *")
    public void cron() {
        LocalDateTime now = LocalDateTime.now();
        log.info("spring-task.helloTask.cron run at {}", dft.format(now));
    }

}
