package com.example.config.tomcat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lpfei on 2017/4/14.
 * 优先级低于配置文件server.port
 * 仅内置tomcat有效,配置文件相同
 */@Configuration
public class TomcatConfig {
    @Value("${server.port:9091}")
    private int port;

    @Bean
    public EmbeddedServletContainerFactory servletContainer(){
        return new TomcatEmbeddedServletContainerFactory(this.port);
    }
}
