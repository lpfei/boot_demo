package com.example.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by lpfei on 2017/4/7.
 */
public class Main1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareService.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
        context.close();
    }
}
