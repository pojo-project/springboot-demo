package com.example.springbootjpa.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity  会自动创建这个表，如果这个表存在
// public class UserEntity{...} 表名 user_entity
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})//懒加载对象不转json
//懒加载：需要时才加载
public class User {
    // @Id - 标明主键字段
// @GeneratedValue(strategy=GenerationType.IDENINY)
    // -AUTO主键由程序控制, 是默认选项 ,不设置就是这个
    // -IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
// @Column(对应数据库字段名, 可为空, 最大长度20)
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name",nullable = true,length = 2000)//和数据库的字段的映射 ，并加规则
    private String name;
    @Column(name = "age",nullable = true,length = 4)
    private Integer age;

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
