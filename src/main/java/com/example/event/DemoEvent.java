package com.example.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * Created by lpfei on 2017/4/7.
 */
public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1323690068601026165L;
    private String msg;

    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
