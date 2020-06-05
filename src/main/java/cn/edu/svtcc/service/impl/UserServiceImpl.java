package cn.edu.svtcc.service.impl;

import cn.edu.svtcc.entity.User;
import cn.edu.svtcc.mapper.UserMapper;
import cn.edu.svtcc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author demo
 * @title UserServiceImpl
 * @description
 * @date 2020/05/25/22:15
 */
@Transactional(rollbackFor = Exception.class)
@Service("UserService")
public class UserServiceImpl implements UserService {
    /**
     * mapper
     */
    private UserMapper mapper;

    /**
     * set注入
     * @param mapper mapper
     */
    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    /**
     *
     * 查询所有
     * @return List
     *
     */
    @Override
    public List<User> findAll() {
        return mapper.findAll();
    }

    /**
     * 通过id查询
     * @param userId userId
     * @return user
     */
    @Override
    public User findByUserId(Integer userId) {
        return mapper.findByUserId(userId);
    }

    /**
     * 登录方法
     * @param users user
     * @return user
     */
    @Override
    public User login(User users) {
        return mapper.login(users);
    }

    /**
     * 注册方法
     * @param users user
     * @return int
     */
    @Override
    public int register(User users) {
        return mapper.register(users);
    }

    /**
     * 更新用户
     * @param users users
     * @return int
     */
    @Override
    public int updateUser(User users) {
        return mapper.updateUser(users);
    }

    /**
     * 删除 通过id
     * @param ids id
     * @return int
     */
    @Override
    public int deleteUser(int ids) {
        return mapper.deleteUser(ids);
    }

    /**
     * 查询所有数据的条数
     * @return int
     */
    @Override
    public int findTotalUser() {
        return mapper.findTotalUser();
    }

    /**
     * 查询 用户
     * @param userName name
     * @return
     */
    @Override
    public User selectByUserName(String userName) {
        return mapper.selectByUserName(userName);
    }


}
