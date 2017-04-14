package com.example.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 * 实现ApplicationListener,并指定监听事件类型<DemoEvent>
 * 使用onApplicationEvent方法对消息进行接受处理
 * Created by lpfei on 2017/4/7.
 */
@Component
public class DemoListener{
    private static final Logger logger = LoggerFactory.getLogger(DemoListener.class);

    @EventListener //取代实现ApplicationListener接口
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        logger.info("监听事件:{}", msg);
    }
}
