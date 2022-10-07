package it.fabioformosa.labs.simplyspringnosec.jobs;

import it.fabioformosa.quartzmanager.api.jobs.AbstractQuartzManagerJob;
import it.fabioformosa.quartzmanager.api.jobs.entities.LogRecord;
import org.quartz.JobExecutionContext;

public class LaoTzuQuoteJob extends AbstractQuartzManagerJob {
    @Override
    public LogRecord doIt(JobExecutionContext jobExecutionContext) {
        return new LogRecord(LogRecord.LogType.INFO, "The journey of a thousand miles begins with one step");
    }
}
