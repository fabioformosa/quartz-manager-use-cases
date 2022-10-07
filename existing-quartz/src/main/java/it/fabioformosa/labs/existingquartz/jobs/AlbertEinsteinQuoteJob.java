package it.fabioformosa.labs.existingquartz.jobs;

import it.fabioformosa.quartzmanager.api.jobs.AbstractQuartzManagerJob;
import it.fabioformosa.quartzmanager.api.jobs.entities.LogRecord;
import org.quartz.JobExecutionContext;

public class AlbertEinsteinQuoteJob extends AbstractQuartzManagerJob {
    @Override
    public LogRecord doIt(JobExecutionContext jobExecutionContext) {
        return new LogRecord(LogRecord.LogType.INFO, "Strive not to be a success, but rather to be of value");
    }
}
