package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.Article;
import com.example.springbootdemo.pojo.ResultData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController2 {
   @GetMapping("/Articles")
    public ResultData<List> findBookMassage(){
       List<Article> list=new ArrayList<>();
       Article article1=new Article(100,"我为什么喜欢蕾姆","小七",520,52013.14);
       Article article2=new Article(101,"我为什么喜欢蕾姆1","小七",520,52013.14);
       Article article3=new Article(102,"我为什么喜欢蕾姆2","小七",520,52013.14);
       Article article4=new Article(103,"我为什么喜欢蕾姆3","小七",520,52013.14);
       Article article5=new Article(104,"我为什么喜欢蕾姆4","小七",520,52013.14);
       list.add(article1);
       list.add(article2);
       list.add(article3);
       list.add(article4);
       list.add(article5);
       return new ResultData<>(200,"成功",list);
   }
   @PutMapping("/Article/{id}")
    public ResultData<Article> updateBookMassage(@PathVariable Integer id){
       Article article=new Article(100,"我为什么喜欢蕾姆","小七",520,52013.14);
       if (id.intValue()==article.getId().intValue()){
           return new ResultData<>(200,"更新成功",article);
       }
       return new ResultData<>(200,"更新不成功",null);
   }
   //客户端通过AJAX提交一个json数据，接口参数需要能够处理一个json
    //如何去实现接口数据的编写
    //如果传来是json数据串，需要用produces申明清楚文件格式
    //序列化：把对象变成json数据，反序列化：把json数据变成对象
   @PutMapping(value = "/Article",produces = "Application/JSON")
    public ResultData<Article> updateBookMassage(@RequestBody Article article){
       return new ResultData<>(200,"更新成功",article);
   }
   @PostMapping(value = "/Article",produces = "Application/JSON")
    public ResultData<Article> saveArticle(@RequestBody Article article){
       return new ResultData<>(200,"保存成功",article);
   }
   @DeleteMapping(value = "Article/{id}")
    public ResultData<Article> deleteArticle(@PathVariable Integer id){
       Article article=new Article(100,"我为什么喜欢蕾姆","小七",520,52013.14);
       if (id.intValue()==article.getId().intValue()){
           return new ResultData<>(200,"删除成功",article);
       }
       return new ResultData<>(200,"删除不成功",null);
   }
}
