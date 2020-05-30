package cn.edu.svtcc.service.impl;

import cn.edu.svtcc.entity.PageVO;
import cn.edu.svtcc.entity.User;
import cn.edu.svtcc.mapper.UserMapper;
import cn.edu.svtcc.service.UserService;
import com.github.pagehelper.PageInfo;
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

    UserMapper mapper;

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

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
    public void register(User users) {
        mapper.register(users);
    }

    @Override
    public void updateUser(User users) {
        mapper.updateUser(users);
    }

    @Override
    public void deleteUser(int[] ids) {
        mapper.deleteUser(ids);
    }

    @Override
    public int findTotalUser() {
        return mapper.findTotalUser();
    }

    @Override
    public User selectByUserName(String userName) {
        return mapper.selectByUserName(userName);
    }


    @Override
    public PageVO<User> findAllUserByPage(int pageNum, int pageSize, String userName) {
        List<User> list = this.mapper.findAllUserByPage(pageNum, pageSize, userName);
        List<User> list2 = this.mapper.findAllUserByPage(pageNum, 1000, userName);
        PageInfo<User> page1 = new PageInfo(list);
        PageInfo<User> page2 = new PageInfo(list2);
        PageVO<User> pageVO = new PageVO();
        pageVO.setData(page1.getList());
        pageVO.setCode(0);
        pageVO.setCount(page2.getSize());
        return pageVO;
    }

    @Override
    public PageVO<User> findAllUserByPage(int pageNum, int pageSize) {
        List<User> list = this.mapper.findAllUserByPage2(pageNum, pageSize);
        List<User> list2 = this.mapper.findAllUserByPage2(0, 1000);
        PageInfo<User> page1 = new PageInfo(list);
        PageInfo<User> page2 = new PageInfo(list2);
        PageVO<User> pageVO = new PageVO();
        pageVO.setData(page1.getList());
        pageVO.setCode(0);
        pageVO.setCount(page2.getSize());
        return pageVO;
    }
}
