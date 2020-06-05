package cn.edu.svtcc.controller;

import cn.edu.svtcc.entity.ResultBean;
import cn.edu.svtcc.entity.User;
import cn.edu.svtcc.service.UserService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author demo
 * @title UserController
 * @description
 * @date 2020/05/25/21:46
 */
@CrossOrigin
@Controller
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserController {

    UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @NonNull
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultBean login(@NonNull @RequestBody(required = true) String json, @NonNull HttpServletRequest request, @NonNull HttpServletResponse response) {
        log.info("进入验证");
        //将从页面传来的json转换成users
        User users = JSON.parseObject(json, User.class);
        //调用service层的login方法
        User getUser = this.service.login(users);
        //通过resultBean中的success方法 或者 fail 方法 给前端响应
        ResultBean bean = getUser != null ? ResultBean.success() : ResultBean.fail();
        //将用户的登录信息保存在session中
        request.getSession().setAttribute("user_login", bean);
        response.setHeader("token", String.valueOf(System.currentTimeMillis()));
        log.info("登录成功");
        return bean;
    }


    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultBean register(@RequestBody String json) {
        System.out.println(json);
        log.info("注册开始");
        User users = JSON.parseObject(json, User.class);
        int register = this.service.register(users);
        if (register > 0) {
            return ResultBean.success();
        } else {
            return ResultBean.fail();
        }

    }

    @RequestMapping("/index2")
    public String index() {
        return "userLogin";
    }

    /**
     * 查询所有
     *
     * @return user
     */
    @ResponseBody
    @RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
    public List<User> findAllUser() {
        return service.findAll();
    }


    @RequestMapping("/findUserByUserName")
    public ResultBean findUserByUserName(@RequestBody String json) {
        //强制转换
        String userName = (String) JSON.parse(json);
        User user = this.service.selectByUserName(userName);
        return user != null ? ResultBean.success() : ResultBean.fail();
    }

    @RequestMapping("/total")
    @ResponseBody
    public int totalUser() {
        return this.service.findTotalUser();
    }

    /**
     * 删除用户
     *
     * @param userId userId
     * @return ResultBean
     */
    @ResponseBody
    @RequestMapping("/deleteUser")
    public ResultBean deleteUser(Integer userId) {

        int i = service.deleteUser(userId);
        if (i > 0) {
            return ResultBean.success();
        } else {
            return ResultBean.fail();
        }
    }

    /**
     * 更新用户
     *
     * @param request  request
     * @param response response
     * @return result
     */
    @ResponseBody
    @RequestMapping("/updateUserName")
    public ResultBean updateUserName(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("userId"));
        System.out.println("id" + id);
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("password");
        User user = new User();
        user.setUserName(userName);
        user.setUserId(id);
        user.setPassWord(passWord);
        int i = service.updateUser(user);
        if (i > 0) {
            return ResultBean.success();
        } else {
            return ResultBean.fail();
        }

    }
}
