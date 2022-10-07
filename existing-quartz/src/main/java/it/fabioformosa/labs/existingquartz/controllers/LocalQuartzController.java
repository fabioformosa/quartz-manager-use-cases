package it.fabioformosa.labs.existingquartz.controllers;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/local-scheduler")
public class LocalQuartzController {

    @Autowired
    private Scheduler scheduler;

    @GetMapping
    public String getLocalQuartzSchedulerInstance() throws SchedulerException {
        String schedulerName = scheduler.getSchedulerName();
        log.info("Scheduler Instance Name is {}", schedulerName);
        return schedulerName;
    }

}
