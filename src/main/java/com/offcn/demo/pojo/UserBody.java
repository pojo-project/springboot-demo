package com.offcn.demo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

// 关联到配置文件中的userbody 将类中的属性和配置文件中的配置进行绑定时出现以下的问题：
@ConfigurationProperties(prefix="userbody")
@Component
public class UserBody {

    private String name;
    private  String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
