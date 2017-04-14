package com.example.config.task;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 线程池
 * 自定义配置文件
 * Created by lpfei on 2017/4/5.
 */
@ConfigurationProperties(prefix = "task.pool")
@Component  //注册为spring管理类
public class TaskProperties {
    private int coreSize;
    private int maxSize;
    private int queueCapacity;

    public int getCoreSize() {
        return coreSize;
    }

    public void setCoreSize(int coreSize) {
        this.coreSize = coreSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }
}
