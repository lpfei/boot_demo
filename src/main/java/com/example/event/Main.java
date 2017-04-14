package com.example.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 发布事件测试
 * Created by lpfei on 2017/4/7.
 */
@Component
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.event");
        Main main = context.getBean(Main.class);
        main.pulish(context);
        context.close();
    }

    public void pulish(AnnotationConfigApplicationContext context) {
        context.publishEvent(new DemoEvent(this, "22"));
    }
}
