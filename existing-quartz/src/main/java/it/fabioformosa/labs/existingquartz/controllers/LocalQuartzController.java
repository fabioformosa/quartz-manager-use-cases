package it.fabioformosa.labs.existingquartz.controllers;

import it.fabioformosa.quartzmanager.api.common.utils.Try;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/local-scheduler")
public class LocalQuartzController {

    @Autowired
    private List<Scheduler> schedulers;

    @GetMapping
    public List<String> getLocalQuartzSchedulerInstance() throws SchedulerException {
        List<String> schedulerNames = schedulers.stream().map(Try.sneakyThrow(Scheduler::getSchedulerName)).toList();
        log.info("Scheduler Instance Name is {}", schedulerNames);
        return schedulerNames;
    }

}
