package cn.edu.svtcc.service;

import cn.edu.svtcc.entity.Good;

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
     * @return goods
     */
    List<Good> selectAllGoods();

    /**
     * 查询商品
     * @return goods
     */
    List<Good> selectGoods();


    /**
     * 查询买到的商品
     * @return goods
     */
    List<Good> selectBuyGoods();
}
