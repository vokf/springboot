package cn.edu.svtcc.mapper;

import cn.edu.svtcc.entity.Good;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author demo
 */

@Repository
public interface GoodMapper {
    /**
     * 查询所有商品
     *
     * @return 商品集合
     */
    @Select("select * from goods")
    @Results({
            @Result(column = "good_name", property = "goodName"),
            @Result(column = "good_price", property = "goodPrice"),
            @Result(column = "good_image", property = "goodImage"),
            @Result(column = "hot", property = "hotGood")
    })
    List<Good> selectAllGoods();

    /**
     * 查询热销产品
     * @return goods
     */
    @Select("select * from hot_goods")
    @Results({
            @Result(column = "good_name", property = "goodName"),
            @Result(column = "good_price", property = "goodPrice"),
            @Result(column = "good_image", property = "goodImage"),
            @Result(column = "hot", property = "hotGood")
    })
    List<Good> selectGoods();

    /**
     * 查询
     * @return goods
     */
    @Select("select * from buy_goods")
    @Results({
            @Result(column = "good_name", property = "goodName"),
            @Result(column = "good_price", property = "goodPrice"),
            @Result(column = "good_image", property = "goodImage"),
            @Result(column = "hot", property = "hotGood")
    })
    List<Good> selectBuyGoods();

    /**
     *  查询数据表中的数据的条数
     * @return int
     */
    @Select("select count(*) from goods")
    int findTotalGoods();

    /**
     * 通过id删除
     * @param ids id
     * @return 成功
     */
    @Delete("delete from goods where id =#{id}")
    int deleteGood(int ids);

    /**
     * 添加商品
     * @param good good
     * @return Good
     */
    @Results({
            @Result(column = "good_name", property = "goodName"),
            @Result(column = "good_price", property = "goodPrice"),
            @Result(column = "good_image", property = "goodImage"),
            @Result(column = "hot", property = "hotGood")

    })
    @Insert("insert into goods values (null,#{goodName},#{goodPrice},null,#{brand},#{hotGood} )")
    int addGood(Good good);

    /**
     * 通过商品名字查询
     * @param goodName
     * @return
     */
    @Results({
            @Result(column = "good_name", property = "goodName"),
            @Result(column = "good_price", property = "goodPrice"),
            @Result(column = "good_image", property = "goodImage"),
            @Result(column = "hot", property = "hotGood")
    })
    @Select("select * from goods where good_name = #{goodName}")
    Good findGoodByName(@Param("goodName") String goodName);


    /**
     * 更新账户密码
     * @param good g
     * @return int
     */
    @Results({
            @Result(column = "good_name", property = "goodName"),
            @Result(column = "good_price", property = "goodPrice"),
            @Result(column = "good_image", property = "goodImage"),
            @Result(column = "hot", property = "hotGood")
    })
    @Update("update goods set good_Name=#{goodName},good_price=#{goodPrice},brand=#{brand},hot=#{hotGood} where id=#{id}  ")
    int updateGood(Good good);

    @Results({
            @Result(column = "good_name", property = "goodName"),
            @Result(column = "good_price", property = "goodPrice"),
            @Result(column = "good_image", property = "goodImage"),
            @Result(column = "hot", property = "hotGood")
    })
    @Select("select * from goods where good_name = #{goodName}")
    List<Good> findGoodList(@Param("goodName") String goodName);
}
