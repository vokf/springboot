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
     * @return
     */
    @Override
    public List<User> findAll() {
        return mapper.findAll();
    }

    @Override
    public User findByUserId(Integer userId) {
        return mapper.findByUserId(userId);
    }

    @Override
    public User login(User users) {
        return mapper.login(users);
    }

    @Override
    public int register(User users) {
        return mapper.register(users);
    }

    @Override
    public int updateUser(User users) {
        return mapper.updateUser(users);
    }

    @Override
    public int deleteUser(int ids) {
        return mapper.deleteUser(ids);
    }

    @Override
    public int findTotalUser() {
        return mapper.findTotalUser();
    }

    @Override
    public User selectByUserName(String userName) {
        return mapper.selectByUserName(userName);
    }


}
