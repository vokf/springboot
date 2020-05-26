package cn.edu.svtcc.mapper;

import cn.edu.svtcc.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

/**
 * @author demo
 * @title UserMapper
 * @description
 * @date 2020/05/25/21:41
 */
@Mapper

public interface UserMapper {
    /**
     * 查询所有
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


    @Select("select *from user u where u.userName=#{userName} && u.passWord=#{passWord}")
    User login(User users);

    /**
     * 注册用户
     *
     * @param users user
     */
    @Insert({"insert into user(userId,userName,passWord,phoneNumber) values (null,#{userName},#{passWord},#{phoneNumber} )"})
    void register(User users);

    /**
     * 更新用户信息
     *
     * @param users users
     */
    @Update("update user set userId = #{userId},userName = #{userName},passWord = #{passWord},phoneNumber = #{phoneNumber}")
    void updateUser(User users);

    /**
     * 删除用户
     *
     * @param ids id
     *
     */
    @Delete("delete from user where userId =#{userId}")
    void deleteUser(int[] ids);

    /**
     * 查询用户总的数量
     *
     * @return 数量
     */
    @Select("select count(*) from user")
    int findTotalUser();

    @Select("select * from user where userName = #{userName}")
    User selectByUserName (@Param("userName") String userName);

}
