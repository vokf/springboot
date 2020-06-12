package cn.edu.svtcc.service;

import cn.edu.svtcc.entity.PageVO;
import cn.edu.svtcc.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author demo
 * @title UserService
 * @description
 * @date 2020/05/25/22:14
 */

public interface UserService {
    /**
     * 查询所有
     *
     * @return user
     */
    List<User> findAll();

    /**
     * 通过userId查询用户
     *
     * @param userId userId
     * @return user
     */
    User findByUserId(@Param("userId") Integer userId);

    /**
     * 登录
     * @param users user
     * @return user
     */
    User login(User users);

    /**
     * 注册用户
     *
     * @param users user
     */
    int register(User users);

    /**
     * 更新用户信息
     *
     * @param users users
     */
    int updateUser(User users);

    /**
     * 删除用户
     *
     * @param
     */

    int deleteUser(int id);

    /**
     * 查询用户总的数量
     *
     * @return 数量
     */

    int findTotalUser();

    /**
     *
     * @param userName userName
     * @return
     */
    User selectByUserName(@Param("userName") String userName);



}
