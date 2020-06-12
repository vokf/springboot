package cn.edu.svtcc.service;

import cn.edu.svtcc.entity.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author demo
 * @title GoodService
 * @description
 * @date 2020/05/26/10:40
 */


public interface GoodService {
    /**
     * 查询所有的商品信息
     *
     * @return goods
     */
    List<Good> selectAllGoods();

    /**
     * 查询商品
     *
     * @return goods
     */
    List<Good> selectGoods();


    /**
     * 查询买到的商品
     *
     * @return goods
     */
    List<Good> selectBuyGoods();


    /**
     * 查询数据条数
     *
     * @return int
     */
    int findTotalGoods();

    /**
     * 删除数据
     * @param ids id
     * @return int
     */
    int deleteGood(int ids);

    /**
     * 添加数据
     * @param good good
     * @return int
     */
    int addGood(Good good);

    /**
     * 通过商品名查询
     * @param goodName goodName
     * @return Good
     */
    Good findGoodByName(String goodName);
}
