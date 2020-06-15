package cn.edu.svtcc.controller;

import cn.edu.svtcc.entity.ResultBean;
import cn.edu.svtcc.entity.User;
import cn.edu.svtcc.service.UserService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

@Slf4j
@Transactional(rollbackFor = Exception.class)
@RestController
public class UserController {

    UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @NonNull

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


    /**
     * 查询所有
     *
     * @return user
     */

    @RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
    public List<User> findAllUser() {
        return service.findAll();
    }




    @RequestMapping("/total")

    public int totalUser() {
        return this.service.findTotalUser();
    }

    /**
     * 删除用户
     *
     * @param userId userId
     * @return ResultBean
     */

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


    @RequestMapping("/findUserByName")

    public User findUserByUserName( String userName) {
        return this.service.selectByUserName(userName);
    }



    @RequestMapping("/findUserList")

    public List<User> findUserByList( String userName) {
        return this.service.selectByUserList(userName);
    }
}
