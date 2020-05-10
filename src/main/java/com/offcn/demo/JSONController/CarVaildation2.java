package com.offcn.demo.JSONController;

import com.offcn.demo.pojo.Car;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarVaildation2 {

    @RequestMapping("/carvalid2")//截取Car类的校验错误信息
    public String getcarvalidation4(@Validated Car car, BindingResult bindingResult) {//应为car加了时间格式化  BindingResult用来获取传递过来的Car对象的实体的字段校验的错误结果
//        所以不能直接传递参数对象，需要写initBinder,进行时间格式再次的转化
        if (bindingResult.hasErrors()) {//错误的结果
            return bindingResult.getFieldError().getDefaultMessage();//如果发生错误就返回错误信息
        }
        return car.toString();//没有错误返回对象
    }

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd hh:mm:ss"));
    }
}
