package it.fabioformosa.labs.existingquartzandstorage.config;

import it.fabioformosa.labs.existingquartzandstorage.jobs.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class TriggerConfig {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void createATrigger() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).build();
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(2)).build();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
        log.info("Scheduler started!");

        new Thread(() -> {
            try {
                Thread.sleep(10000);
                scheduler.standby();
                log.info("Scheduler paused!");
            } catch (InterruptedException | SchedulerException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}
