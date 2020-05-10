package com.offcn.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {//传递参数时的异常处理类

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody//以JSON字符串格式返回
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleVaildationException(ConstraintViolationException e) {//吧异常截获
        for (ConstraintViolation<?> s : e.getConstraintViolations()) {
            return s.getInvalidValue() + "$" + s.getMessage();//打印的错误信息
        }
        return "请求的参数不合法";
    }
}
