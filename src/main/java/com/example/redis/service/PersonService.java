package com.example.redis.service;

import com.example.redis.entity.Person;
import com.example.redis.mapper.PersonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lpfei on 2017/3/29.
 */
@Service
public class PersonService {
    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valueOperations;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valueOpera;

    @Resource(name = "redisTemplate")
    ListOperations<Object, Object> listOperations;


    /**
     * 保存string
     *
     * @param key
     * @param value
     */
    public void setString(String key, String value) {
        logger.info("我是info");
        valueOperations.set(key, value);
    }

    /**
     * 保存用户
     *
     * @param person
     */
    public void savePerson(Person person) {
        valueOpera.set(person.getId(), person);
    }

    /**
     * 缓存查询string
     *
     * @param key
     * @return
     */
    @Cacheable(value = "value", keyGenerator = "wiselyKeyGenerator")
    public String getString(String key) {
        logger.info("无缓存时走这里");
        return valueOperations.get(key);
    }

    /**
     * 缓存查询person
     *
     * @param key
     * @return
     */
    @Cacheable(value = "person", keyGenerator = "wiselyKeyGenerator")
    public Person getPerson(String key) {
        logger.info("无缓存时走这里");
        return (Person) valueOpera.get(key);
    }

    /**
     * 向list添加数据
     */
    public void setLeftPush(String key, Object object) {
        logger.info("向list添加:{}",object);
        listOperations.leftPush(key, object);
    }

    /**
     * 从list中取数据
     * 后进先出
     * @return
     */
    public Object getLeftPop(String key) {
        logger.info("从list取数据:{}",key);
        logger.debug("wo de debug");
        return  listOperations.leftPop(key);
    }


    public void insertPerson(Person person) throws Exception{
        personMapper.insert(person);
    }

    public Person selectById(String id){
        return personMapper.selectByPrimaryKey(id);
    }
}
