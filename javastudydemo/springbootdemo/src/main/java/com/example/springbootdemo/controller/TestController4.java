package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.Article;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/templates")
public class TestController4 {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
    /*thymeleaf 显示普通文本 在mvc开发过程中，我们经常需要通过Controller将数据传递到页面，让页面进行动态显示
    *首先创建TestController4
    * 通过model方式进行数据传递
    * TestController4中Mode相当于为页面传递数据
    * show.html页面里面xmIns:th="http-l/www.thymeleaf.org"这个是thymeleaf模板的定义
    * 可以看到在p标签中有th:text属性，这个就是thymeleaf的语法，它表示显示一个普通的文本信息
    * html文件show.html
*/
    @GetMapping("/show")
    public String show(Model model){
        model.addAttribute("uid","001");
        model.addAttribute("uName","小七");
        model.addAttribute("uTel","19380504129");
        model.addAttribute("uLike","打游戏");
        return "show";
    }
    /*基础数学运算，直接通过（）进行基础数学运算
    *html文件calculation.html*/
    @GetMapping("/calculation")
    public String calculation(){
        return "calculation";
    }
    /*显示样式文本
    * 如果需要传递到页面的信息本身具有css样式，通过utext对<>进行转义
    * html文件styleUser.html*/
    @GetMapping("/styleUser")
    public String styleUser(Model model){
        model.addAttribute("UId","001");
        model.addAttribute("UName","<span style='color:red;'>小七</span>");
        return "styleUser";
    }
    /*前端展示Vo 类
    * 通过thymeleaf将一个bean实体类信息展示在前端页面中
    * html文件showArticle.html*/
    @GetMapping("/showArticle")
    public String showArticle(Model model){
        Article article=new Article(100,"我为什么喜欢蕾姆","小七",520,52013.14);
        model.addAttribute("article",article);
        return "showArticle";
    }
    /*数据处理
    * thymeleaf对集合数据进行处理
    * html文件showStudents.html*/
    @GetMapping("/showStudents")
    public String showStudents(Model model){
        List<Map<String,Object>> list =new ArrayList<>();
        Map<String,Object> map =new HashMap<String,Object>(){{
            put("sId","1001");
            put("sName","小七");
            put("sAge","23");
            put("sGrade","五年级六班");
            put("sCourses",new HashMap<String,Object>(){{
                put("cName","如何喜欢蕾姆,如何爱上蕾姆,如何了解蕾姆");
                put("sScore","100,99,98");
            }});
        }};
        list.add(map);
        map=new HashMap<String,Object>(){{
            put("sId","1002");
            put("sName","小七喵");
            put("sAge","24");
            put("sGrade","五年级七班");
            put("sCourses",new HashMap<String,Object>(){{
                put("cName","如何喜欢蕾姆1,如何爱上蕾姆1,如何了解蕾姆1");
                put("sScore","100,99,98");
            }});
        }};
        list.add(map);
        model.addAttribute("list",list);
        return "showStudents";
    }
    /*thymeleaf对数据集合list和map进行处理
    * 遍历list和map集合并显示在页面上
    * html文件showList.html和showMap.html*/
    @GetMapping("/showList")
    public String showList(Model model){
        List<Article> list =new ArrayList<>();
        for(int i=0;i<=10;i++){
            Article article=new Article(100,"我为什么喜欢蕾姆"+i,"小七",520+i*5,52013.14+i*2);
            list.add(article);
        }
        model.addAttribute("article",list);
        return "showList";
    }
    @GetMapping("/showMap")
    public String showMap(Model model){
        Map<String,Object> map =new HashMap();
        map.put("id","1001");
        map.put("name","蕾姆为什么天下第一？");
        map.put("author","小七");
        map.put("page","520");
        map.put("price","520.1314");
        model.addAttribute("map",map);
        return "showMap";

    }
    /*路径处理
    * springboot提供了更加简化的路径处理
    * 。引入js路径，通过@路径}语法实现
    * <script th:src="@(index.js}" type="text/javascript"></script>
    * 页面超链接跳转，通过@{路径}语法实现
    * <a th:href="e{ /api/v1/showStudent}">thymeleaf数据处理</ a>
    * html文件showUrl.html*/
    @GetMapping("/showUrl")
    public String showUrl(){
        return "showUrl";
    }
    /*操作内置对象
    * 模板开发框架里面不提倡使用内置对象
    * 很多情况任然需要使用内置对象进行处理
    * 在页面中如何使用jsp内置对象
    * html文件 showInnerObject.html*/
    @GetMapping("/showInnerObject")
    public String showInnerObject(Model model, HttpServletRequest request){
        request.setAttribute("attribute","springBoot.attribute");
        request.getSession().setAttribute("session","springBoot.session");
        request.getServletContext().setAttribute("context","springBoot.context");
        model.addAttribute("model","springBoot.model");
        return "showInnerObject";
    }


}
