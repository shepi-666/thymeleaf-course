package com.javadong.controller;


import com.javadong.model.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {

    // 第一个标准表达式
    @GetMapping("/expression1")
    public String expression(Model model) {
        model.addAttribute("site", "www.javadong.com");
        model.addAttribute("role", new Role(1, "展堂", "男", 23));

        // 指定视图
        return "expression1";
    }

    // 选择变量表达式
    @GetMapping("/expression2")
    public String expression2(Model model) {
        model.addAttribute("role", new Role(1, "展堂", "男", 23));

        // 指定视图
        return "expression2";
    }

    // 链接表达式
    @GetMapping("/expression3")
    public String expression3(Model model) {
        model.addAttribute("role", new Role(1, "展堂", "男", 23));
        // 指定视图
        return "expression3";
    }

    // 访问首页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    // 使用模板的属性
    @GetMapping("/property1")
    public String useProperty(Model model) {
        model.addAttribute("methodAttr", "post");
        model.addAttribute("id", "1001");
        model.addAttribute("name", "张三");
        model.addAttribute("age", "34");
        return "property1";
    }

    // 使用模板的属性
    @GetMapping("/eachlist")
    public String forList(Model model) {

        List<Role> roles = new ArrayList<>();
        roles.add(new Role(1, "白展堂", "男", 23));
        roles.add(new Role(2, "佟湘玉", "女", 28));
        roles.add(new Role(3, "郭芙蓉", "女", 21));
        roles.add(new Role(4, "吕轻侯", "男", 22));
        model.addAttribute("roles", roles);
        return "role_list";
    }

    // 数组的循环
    @GetMapping("/eacharray")
    public String eachArray(Model model) {
        Role[] roles = new Role[3];
        roles[0] = new Role(1, "白展堂", "男", 23);
        roles[1] = new Role(2, "佟湘玉", "女", 28);
        roles[2] = new Role(3, "郭芙蓉", "女", 21);
        model.addAttribute("roleArray", roles);
        return "role_list";
    }

    // Map的循环
    @GetMapping("/eachmap")
    public String eachMap(Model model) {
        Map<String, Role> roleMap = new HashMap<>();
        roleMap.put("role1", new Role(1, "白展堂", "男", 23));
        roleMap.put("role2",new Role(2, "佟湘玉", "女", 28));
        roleMap.put("role3",new Role(3, "郭芙蓉", "女", 21));
        model.addAttribute("roleMap", roleMap);
        return "role_list";
    }

    // if 和 unless的使用
    @GetMapping("/ifunless")
    public String ifUnless(Model model){
        model.addAttribute("sex", "male");
        model.addAttribute("isLogin", true);
        model.addAttribute("age", 20);
        model.addAttribute("name", "");
        model.addAttribute("isOld", null);
        return "ifunless";
    }

    // 内联text
    @GetMapping("/inlinetext")
    public String inline(Model model) {
        model.addAttribute("sex", "male");
        model.addAttribute("age", 20);
        model.addAttribute("name", "李大嘴");
        model.addAttribute("role", new Role(1, "展堂", "男", 23));
        return "inline";
    }

    @GetMapping("/baseobj")
    public String baseObj(HttpServletRequest request, Model model, HttpSession session) {
       model.addAttribute("name", "李四");
       request.setAttribute("requestData", "request作用域中的数据");
       session.setAttribute("sessionData", "session作用域中的数据");
        return "baseobj";
    }

    // 自定义模板
    @GetMapping("/customtpl")
    public String customTpl() {
        return "customtpl";
    }
}
