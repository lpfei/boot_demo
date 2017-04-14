package com.example.config.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 计划任务支持
 * Created by lpfei on 2017/4/5.
 */
@Configuration
@EnableScheduling  //开启计划任务支持,默认单线程执行
public class TaskSchedulerConfig {
}
