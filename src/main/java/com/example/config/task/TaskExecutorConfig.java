package com.example.config.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 异步多线程支持
 * 读取自定义配置文件
 * Created by lpfei on 2017/4/5.
 */
@Configuration
@EnableConfigurationProperties(TaskProperties.class)
@EnableAsync//开启异步支持
public class TaskExecutorConfig implements AsyncConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(TaskExecutorConfig.class);
    @Autowired
    private TaskProperties taskProperties;

    @Override
    public Executor getAsyncExecutor() {
        logger.info("读取线程池配置文件");
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(taskProperties.getCoreSize());
        threadPoolTaskExecutor.setMaxPoolSize(taskProperties.getMaxSize());
        threadPoolTaskExecutor.setQueueCapacity(taskProperties.getQueueCapacity());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
