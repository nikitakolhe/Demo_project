package com.ugam1.core.schedulers;
import com.ugam1.core.config.SchedulerConfiguration;
import com.ugam1.core.models.Update;
import org.apache.sling.api.resource.*;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.apache.sling.event.jobs.JobManager;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(immediate = true, service = Ugam1Scheduler.class)
@Designate(ocd = SchedulerConfiguration.class)
public class Ugam1Scheduler implements Runnable{
    private static final Logger LOG = LoggerFactory.getLogger(Ugam1Scheduler.class);
    private int schedulerId;
    @Reference
    private Scheduler scheduler;
    @Reference
    Update update;
    @Activate
    protected void activate(SchedulerConfiguration config) {
        schedulerId = config.schedulerName().hashCode();
        addScheduler(config);
    }

    @Deactivate
    protected void deactivate(SchedulerConfiguration config) {
        removeScheduler();
    }

    private void removeScheduler() {
        scheduler.unschedule(String.valueOf(schedulerId));
    }

    private void addScheduler(SchedulerConfiguration config) {
        ScheduleOptions scheduleOptions = scheduler.EXPR(config.time());
        scheduleOptions.name(String.valueOf(schedulerId));
        scheduleOptions.canRunConcurrently(true);
        scheduler.schedule(this, scheduleOptions);
        LOG.info("\n ---------Scheduler added----------");

    }
    @Override
    public void run() {
        LOG.info("\n ====> RUN METHOD  ");
        update.update();
    }
}