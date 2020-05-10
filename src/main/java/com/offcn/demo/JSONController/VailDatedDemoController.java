package com.offcn.demo.JSONController;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@RestController
@Validated//要使用@NotBlank这些检验规则必须在类上面或者方法中或者参数中加上这个注解开头
public class VailDatedDemoController {
    //    检验传递的单个变量
//    给group校验加规则：[a-zA-Z0-9_]+  字母和数字和下划线都是允许的 + 表达有任意多个但是遵循前面的原则
    @RequestMapping("/vaild/{group:[a-zA-Z0-9_]+}/{userid}")
    public String vaild(@PathVariable("group") String group, @PathVariable("userid") String userid) {
        return group + ":" + userid;
    }

    //    校验传递的固定参数，加多个检验
//    http://localhost:8080/vaild2?group=eee&email=151@qq.com
    @RequestMapping("/vaild2")
    public String param(
            @NotBlank(message = "group不能是空")//还需要一个异常处理类GlobalExceptionHandler
            @RequestParam("group") String group,

            @NotBlank(message = "email不能是空")
            @Email(message = "不符合email格式")
            @RequestParam("email") String email) {
        return group + ":" + email;
    }


//传递一个对象怎么做这个参数对象的检验？也就是检验一个传递过来的对象，合法才进入方法内部执行

}
