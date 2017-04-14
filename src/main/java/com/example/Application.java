package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * main方法启动
 * Created by lpfei on 2017/3/15.
 */
@SpringBootApplication
@ComponentScan("com.example")//启动扫描包
//@MapperScan(basePackages = "com.example.**.mapper") //扫描mapper或者@Mapper注解
//SpringBootServletInitializer 继承SpringBootServletInitializer,tomcat启动方式
public class Application {
//extends SpringBootServletInitializer
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        logger.info("tomcat方式启动........................");
        return builder.sources(Application.class);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*@Bean
    public EmbeddedServletContainerFactory servletContainerFactory() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("*//*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(80);
        connector.setSecure(false);
        connector.setRedirectPort(8443);
        return connector;
    }*/
}
