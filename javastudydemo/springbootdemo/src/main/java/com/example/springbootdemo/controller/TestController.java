package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.Article;
import com.example.springbootdemo.pojo.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/*定义一个接口*/
@RestController
public class TestController {
    @GetMapping("/index")
    public String index(){
        return "helloworld";
    }
    @GetMapping("/Article/{id}")
    public ResultData<Article> getArticle(@PathVariable Integer id){
        Article article=new Article(100,"我为什么喜欢蕾姆","小七",520,52013.14);
        System.out.println("id=="+id);
        if (id.intValue()==article.getId().intValue()){
            return new ResultData<>(200,"成功",article);
        }
        return new ResultData<>(200,"没有这个值",null);
    }




}
