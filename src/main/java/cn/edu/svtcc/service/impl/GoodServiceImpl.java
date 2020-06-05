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
    GoodMapper mapper;

    @Autowired
    public void setMapper(GoodMapper mapper) {
        this.mapper = mapper;
    }

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


    @Override
    public int findTotalGoods() {
        return mapper.findTotalGoods();
    }

    @Override
    public int deleteGood(int ids) {
        return mapper.deleteGood(ids);
    }

    @Override
    public int addGood(Good good) {
        return mapper.addGood(good);
    }
}
