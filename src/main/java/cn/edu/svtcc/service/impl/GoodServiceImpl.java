package cn.edu.svtcc.service.impl;

import cn.edu.svtcc.entity.Good;
import cn.edu.svtcc.mapper.GoodMapper;
import cn.edu.svtcc.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author demo
 * @title GoodServiceImpl
 * @description
 * @date 2020/05/26/10:40
 */
@Service("GoodService")
@Transactional(rollbackFor = Exception.class)
public class GoodServiceImpl implements GoodService {
    private GoodMapper mapper;

    /**
     * set注入
     * @param mapper mapper
     */
    @Autowired
    public void setMapper(GoodMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 查询商品
     * @return
     */
    @Override
    public List<Good> selectAllGoods() {
        return mapper.selectAllGoods();
    }

    @Override
    public List<Good> selectGoods() {
        return mapper.selectGoods();
    }

    @Override
    public List<Good> selectBuyGoods() {
        return mapper.selectBuyGoods();
    }


    /**
     * 查询数据的条数
     * @return int
     */
    @Override
    public int findTotalGoods() {
        return mapper.findTotalGoods();
    }

    /**
     * 通过id删除商品
     * @param ids id
     * @return int
     */
    @Override
    public int deleteGood(int ids) {
        return mapper.deleteGood(ids);
    }

    /**
     * 添加 good
     * @param good good
     * @return int
     */
    @Override
    public int addGood(Good good) {
        return mapper.addGood(good);
    }

    @Override
    public Good findGoodByName(String goodName) {
        return mapper.findGoodByName(goodName);
    }
}
