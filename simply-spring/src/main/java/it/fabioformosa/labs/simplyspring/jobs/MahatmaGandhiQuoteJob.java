package it.fabioformosa.labs.simplyspring.jobs;

import it.fabioformosa.quartzmanager.api.jobs.AbstractQuartzManagerJob;
import it.fabioformosa.quartzmanager.api.jobs.entities.LogRecord;
import org.quartz.JobExecutionContext;

public class MahatmaGandhiQuoteJob extends AbstractQuartzManagerJob {
    @Override
    public LogRecord doIt(JobExecutionContext jobExecutionContext) {
        return new LogRecord(LogRecord.LogType.INFO, "You must be the change you wish to see in the world");
    }
}
