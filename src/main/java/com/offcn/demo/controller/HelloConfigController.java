package com.offcn.demo.controller;

import com.offcn.demo.pojo.TestUser;
import com.offcn.demo.pojo.UserBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//这个类用来使用yml配置文件的自定义属性配置
@RestController
@EnableConfigurationProperties({UserBody.class, TestUser.class})//开启这个userBodyl类的配置信息读取功能,会到UserBody 定义的配置资源位置找资源
public class HelloConfigController {
/*    @Value("${offcn_ip}")
    private String offcn_ip;
    @Value("${offcn_port}")
    private String offcn_port;*/
    @Autowired
    private UserBody userBody;//在配置文件配置类的初始值
    @Autowired
    private TestUser testUser;//在配置文件配置类的初始值

    @GetMapping("/getUser")
    public String getValue(){
        return userBody.toString();
    }
}
