package com.example.quartz.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class LcmgrTestJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        /*
         * Job Interface를 implements하여
         * execute 메소드에 로직을 넣는다.
         * */  System.out.println("--------------------------job수행---------------------------");
        System.out.println("1111");
        int i = 0;
        while (true){
            try {
                Thread.sleep(1000); //1초 대기
                i++;
                System.out.println("LcmgrTestJob1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                if (i >= 50) break;
            }

        }
    }

}