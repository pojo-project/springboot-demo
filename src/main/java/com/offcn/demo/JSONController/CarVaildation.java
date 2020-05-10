package com.offcn.demo.JSONController;

import com.offcn.demo.pojo.Car;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarVaildation {
    @RequestMapping("/getcarvalidation1")
    public Car getCarVaildation(@RequestBody  @Validated Car car){//传递一个JSON格式的Car,现在需要对传递过来的Car的字段进行校验
//        1 在参数car添加 @Validated
//        2 进入Car中
        return car;
    }

}
