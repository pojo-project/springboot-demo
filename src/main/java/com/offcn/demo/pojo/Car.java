package com.offcn.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


/*SpringBoot支持JSR-303 标准的校验，具体注解标签如下：
@NotNull   限制必须不为null,注意支持String类型校验
@NotEmpty         验证注解的元素值不为 null 且不为空（字符串长度不为0、集合大小不为0）
@NotBlank           验证注解的元素值不为空（不为null、去除首位空格后长度为0），不同于@NotEmpty，@NotBlank只应用于字符串且在比较时会去除字符串的空格
@Pattern(value)  限制必须符合指定的正则表达式
@Size(max,min)   限制字符长度必须在 min 到 max 之间（也可以用在集合上）
@Email        验证注解的元素值是Email，也可以通过正则表达式和flag指定自定义的email格式
@Max(value)       限制必须为一个不大于指定值的数字
@Min(value)        限制必须为一个不小于指定值的数字
@DecimalMax(value)   限制必须为一个不大于指定值的数字
@DecimalMin(value)    限制必须为一个不小于指定值的数字
@Null          限制只能为null（很少用）
@AssertFalse         限制必须为false （很少用）
@AssertTrue         限制必须为true （很少用）
@Past          限制必须是一个过去的日期
@Future     限制必须是一个将来的日期
@Digits(integer,fraction)        限制必须为一个小数，且整数部分的位数不能超过 integer，小数部分的位数不能超过fraction （很少用）*/


//转化为JSON格式字符串的时候对这个对象进行校验，返回校验后的数据格式
public class Car implements Serializable {
    /*注解说明：
    @JsonFormat就是格式化JSON输出，pattern是日期时间格式化形式，timezone即时区（东八区）
    @DateTimeFormat 将String转换成Date，一般前台给后台传值时用。
    @JsonIgnore 忽略字段，不转换为JSON
    @JsonInclude(JsonInclude.Include.NON_NULL) 当字段值为空的时候不在转换为JSON*/


    //    添加将这个类作为参数传递时到方法中的时候的字段校验
    @Max(value = 100, message = "id不能大于100")//校验传递id最大值不能大于100
    private int id;
    @NotBlank(message = "用户名不能是空")//检验传递的是不能是空
    @Length(min = 2, max = 10, message = "用户名长度必须在{min}-{max}之间")//校验传递的字段长度2-10之间
    private String name;
    @DecimalMin(value = "1.0", message = "价格低于一元")//校验传递的价格是1.0---10.0之间
    @DecimalMax(value = "10.0", message = "价格最高10元")
    private float price;
    //   转JSON格式的时候 格式化时间指定格式
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;
    private String email;

    //    @JsonInclude(JsonInclude.Include.NON_NULL)//    当属性值为空的时候，返回为转JSON不会携带这个这段到数据结构中
    @JsonInclude
    @NotNull(message = "属性字段不能为空")//检验传递属性不能是NULL
    @NotBlank(message = "属性字段不能为空白")//校验传递属性不是“ ”
    private String isNull;
    //    转JSON的时候不会携带这个这段
    @JsonIgnore
    private String memo;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }
}
