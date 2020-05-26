package cn.edu.svtcc.controller;

import cn.edu.svtcc.entity.ResultBean;
import cn.edu.svtcc.entity.User;
import cn.edu.svtcc.service.UserService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author demo
 * @title UserController
 * @description
 * @date 2020/05/25/21:46
 */
@Controller
@Slf4j
public class UserController {

    UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultBean login(@NonNull @RequestBody(required = true) String json, @NonNull HttpServletRequest request) {
        log.info("进入验证");
        //将从页面传来的json转换成users
        User users = JSON.parseObject(json, User.class);
        //调用service层的login方法
        User getUser = this.service.login(users);
        //通过resultBean中的success方法 或者 fail 方法 给前端响应
        ResultBean bean = getUser != null ? ResultBean.success(getUser) : ResultBean.fail();
        //将用户的登录信息保存在session中
        request.getSession().setAttribute("user_login", bean);
        log.info("登录成功");
        return bean;
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultBean register(@RequestBody String json, Throwable t) {
        log.info("注册开始");
        User users = JSON.parseObject(json, User.class);
        this.service.register(users);
        return ResultBean.success();


    }

    @RequestMapping("/index2")
    public String index() {
        return "userLogin";
    }

}
