package com.example.redis.controller;

import com.example.config.task.TaskProperties;
import com.example.redis.entity.Person;
import com.example.redis.service.PersonService;
import com.example.task.TaskTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by lpfei on 2017/3/28.
 */
@Controller
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/set")
    public void set() {
        Person person = new Person();
        person.setAge(15);
        person.setId("1");
        person.setName("大大");
        personService.savePerson(person);
        personService.setString("1", "大大");
    }

    @RequestMapping(value = "/getStr")
    @ResponseBody
    public String getStr() {
        return personService.getString("1");
    }

    @RequestMapping(value = "/getPerson")
    @ResponseBody
    public Person getPerson() {
        return personService.getPerson("1");
    }

    @RequestMapping(value = "/setList")
    @ResponseBody
    public void setList(String value) {
        personService.setLeftPush("list", value);
    }

    @RequestMapping(value = "/getList")
    @ResponseBody
    public Object getList(String key) {
        logger.debug("con  de bug");
        return personService.getLeftPop(key);
    }

    /**
     * 向数据库添加用户信息
     *
     * @return
     */
    @RequestMapping(value = "/setPerson")
    @ResponseBody
    public String setPerson() {
        Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setName("person");
        person.setAge(23);
        try {
            personService.insertPerson(person);
            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    /**
     * 登录
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String id, HttpServletRequest request) {
        //判断用户有没有登录
        Object person=request.getSession().getAttribute("Person");
        if(person==null){
            logger.info("无用户登录session信息:{}",person);
        }else{
            logger.info("用户已登录:{}",((Person)person).getName());
            return "OK Again";
        }
        //登录,将session添加到redis
        person = personService.selectById(id);
        if (person != null) {
            request.getSession().setAttribute("Person", person);
            logger.info("用户登录:{}", id);
            return "OK";
        }
        return "ERROR";
    }

    @Autowired
    private TaskProperties taskProperties;

    @Autowired
    private TaskTest taskTest;
    @ResponseBody
    @RequestMapping(value = "asy")
    public String asy(){
        System.out.println(taskProperties.getCoreSize()+"fdfdfdfd");
        for (int i=0;i<10;i++){
            taskTest.print2(i);
            taskTest.print3(i);
        }
        return "OK";
    }
}
