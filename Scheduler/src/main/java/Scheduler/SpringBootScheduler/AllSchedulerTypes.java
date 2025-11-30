package Scheduler.SpringBootScheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Month;

@Component
public class AllSchedulerTypes {
    @Scheduled(fixedRate = 5000)
    public void fixedRateTask() {
        System.out.println("fixedRate: runs every 5 seconds");
    }
    @Scheduled(fixedDelay = 5000)
    public void fixedDelayTask() {
        System.out.println("fixedDelay: runs 5 seconds after previous run completes");
    }
    @Scheduled(initialDelay = 1000, fixedRate = 3000)
    public void initialDelayTask() {
        System.out.println("initialDelay + fixedRate: starts after 10 sec, then every 5 sec");
    }
//    (Hint: Remember the position of the fields: Seconds, Minutes, Hours, Day of Month, Month, Day of Week)
    @Scheduled(cron = "1 * * * * *")
    public void cronTask() {
        System.out.println("cron: runs at the start of every minute");
    }
}
