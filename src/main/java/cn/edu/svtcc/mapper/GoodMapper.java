package cn.edu.svtcc.mapper;

import cn.edu.svtcc.entity.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author demo
 */
@Mapper

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

}
