package com.example;

import com.example.aware.AwareService;
import com.example.event.DemoPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lpfei on 2017/4/7.
 */
@Controller
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    private DemoPublisher demoPublisher;
    @Autowired
    private AwareService awareService;
    /**
     * 测试事件发布监听
     */
    @RequestMapping(value = "/publish")
    @ResponseBody
    public String publish() {
        demoPublisher.publish("发言");
        awareService.outputResult();
        return "OK";
    }
}
