package com.example.springbootdemo.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.regex.Pattern;

public class User {
    //JsonProperty:定义返回的数据的属性名字，即定义属性的别名
    @JsonProperty("user_id")
    private Integer id;

    //JsonIgnore框架 将属性不进行序列化 作用在字段或方法上，用来完全忽略被注解的字段和方法对应的属性。实体类中某些属性只在代码中有用，序列化不想带出来，浪费流量
    @JsonIgnore
    private String pwd;

    @JsonProperty("user_phone")
    //JsonInclude:有些值为NULL不想传过去，往往还得在SQL或者代码做循环判断，损耗性能
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String telNumber;

    @JsonProperty("user_time")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")//JsonFormat:实体类/属性使用的注解，在序列化或者反序列化的时候，指定属性格式化日期/时间
    private Date createTime;

    public User() {
    }

    public User(Integer id, String pwd, String telNumber, Date createTime) {
        this.id = id;
        this.pwd = pwd;
        this.telNumber = telNumber;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
