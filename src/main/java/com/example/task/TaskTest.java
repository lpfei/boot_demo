package com.example.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by lpfei on 2017/4/5.
 */
@Service
public class TaskTest {
    private static final Logger logger = LoggerFactory.getLogger(TaskTest.class);

    //@Scheduled(fixedRate = 5000)
    public void print() {
        //计划执行
        logger.info("每5秒钟执行一次........");
        for (int i=0;i<10;i++){
            print2(i);
            print3(i);
        }

    }
    @Async
    public void print2(int i){
        //异步执行
        Thread t=Thread.currentThread();
        logger.info("异步执行.......{}---------------------{}",t.getName(),i+1);

    }
    @Async
    public void print3(int i){
        //异步执行
        Thread t=Thread.currentThread();

        logger.info("异步执行.......{}===={}",t.getName(),i);

    }

}
