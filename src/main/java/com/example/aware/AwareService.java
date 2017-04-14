package com.example.aware;


import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;


/**
 * Created by lpfei on 2017/4/7.
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private static final Logger logger = LoggerFactory.getLogger(AwareService.class);
    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult() {
        logger.info("bean的名字:{}", beanName);
        Resource resource = loader.getResource(loader.CLASSPATH_URL_PREFIX + "com/example/aware/test.txt");
        try {
            logger.info("resourceLoader加载的内容:{}", IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
