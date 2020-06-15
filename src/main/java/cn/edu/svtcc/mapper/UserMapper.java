package cn.edu.svtcc.mapper;

import cn.edu.svtcc.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author demo
 * @title UserMapper
 * @description
 * @date 2020/05/25/21:41
 */
@Repository
public interface UserMapper {
    /**
     * 查询所有
     *
     * @return user
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 通过userId查询用户
     *
     * @param userId userId
     * @return user
     */
    @Select("select * from user where userId = #{userId} ")
    User findByUserId(@Param("userId") Integer userId);

    /**
     * 登录
     * @param users users
     * @return user
     */
    @Select("select *from user u where u.userName=#{userName} && u.passWord=#{passWord}")
    User login(User users);

    /**
     * 用户注册
     * @param users user
     * @return int
     */
    @Insert({"insert into user(userId,userName,passWord,phoneNumber,age,email,address,role) " +
            "values (null,#{userName},#{passWord},#{phoneNumber},#{age} ,#{email},#{address},'1' )"})
    int register(User users);

    /**
     * 更新账户密码
     * @param users user
     * @return int
     */
    @Update("update user set userName=#{userName},passWord=#{passWord} where userId=#{userId}  ")
    int updateUser(User users);

    /**
     * 删除用户
     * @param ids id
     * @return int
     */
    @Delete("delete from user where userId =#{userId}")
    int deleteUser(int ids);

    /**
     * 查询用户总的数量
     *
     * @return 数量
     */
    @Select("select count(*) from user")
    int findTotalUser();

    /**
     * 查询用户
     * @param userName userName
     * @return user
     */
    @Select("select * from user where userName = #{userName}")
    User selectByUserName(@Param("userName") String userName);


    @Select("select * from user where userName = #{userName}")
    List<User>  selectByUserList(@Param("userName") String userName);


}
