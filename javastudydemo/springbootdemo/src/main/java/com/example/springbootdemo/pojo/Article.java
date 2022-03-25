package com.example.springbootdemo.pojo;

import java.io.Serializable;

/*模型*/
//rpc数据通信的时候需要做序列化：implements Serializable
public class Article implements Serializable {
    private Integer id;
    private String name;
    private String author;
    private Integer page;
    private Double price;
    public Article() {
    }

    public Article(Integer id, String name, String author, Integer page, Double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.page = page;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
