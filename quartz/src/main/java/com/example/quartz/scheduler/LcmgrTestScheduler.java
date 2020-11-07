package com.example.quartz.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LcmgrTestScheduler {
    private SchedulerFactory schedulerFactory;
    private Scheduler scheduler;

    @PostConstruct
    public void start() throws SchedulerException {

        schedulerFactory = new StdSchedulerFactory();
        scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        //job 지정
        JobDetail job = JobBuilder.newJob(LcmgrTestJob.class).withIdentity("testJob").build();
        JobDetail job2 = JobBuilder.newJob(LcmgrTestJob2.class).withIdentity("testJob2").build();


        //trigger 생성
        Trigger trigger = TriggerBuilder.newTrigger().
                withSchedule(CronScheduleBuilder.cronSchedule("15 * * * * ?")).build();
//        startAt과 endAt을 사용해 job 스케쥴의 시작, 종료 시간도 지정할 수 있다.
//        Trigger trigger = TriggerBuilder.newTrigger().startAt(startDateTime).endAt(EndDateTime)
//                .withSchedule(CronScheduleBuilder.cronSchedule("*/1 * * * *")).build();

        Trigger trigger2 = TriggerBuilder.newTrigger().
                withSchedule(CronScheduleBuilder.cronSchedule("45 * * * * ?")).build();

        Trigger trigger3 = TriggerBuilder.newTrigger().withIdentity(TriggerKey.triggerKey("myTrigger", "myTriggerGroup"))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever())
                .build();


        scheduler.scheduleJob(job, trigger);
        scheduler.scheduleJob(job2, trigger3);
    }
}