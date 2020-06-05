package cn.edu.svtcc.controller;

import cn.edu.svtcc.entity.Good;
import cn.edu.svtcc.entity.ResultBean;
import cn.edu.svtcc.service.GoodService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 对商品进行管理
 * @author demo
 * @title GoodController
 * @description
 * @date 2020/05/26/7:24
 */
@Slf4j
// 事务
@Transactional(rollbackFor = Exception.class)
@Controller
// 允许跨域访问
@CrossOrigin
public class GoodController {
    /**
     * 用到GoodService
     */
    private GoodService service;

    /**
     * 通过set注入容器
     *
     * @param service goodService
     */
    @Autowired
    public void setService(GoodService service) {
        this.service = service;
    }

    /**
     * 测试
     *
     * @param model model
     * @return hh.html
     */
    @RequestMapping("/hh")
    public String hh(@NonNull Model model) {
        model.addAttribute("demo", service.selectAllGoods());
        model.addAttribute("buy", service.selectBuyGoods());
        return "hh";
    }


    /**
     * 从数据库中获取图片的地址
     *
     * @param model model
     * @return index.html
     */
    @RequestMapping("/index")
    public String index(@NonNull Model model) {
        model.addAttribute("abc", service.selectAllGoods());
        model.addAttribute("hot", service.selectGoods());
        model.addAttribute("buy", service.selectBuyGoods());

        return "index";
    }

    /**
     * 查询数据库里面的所有
     * @return List
     */
    @ResponseBody
    @RequestMapping("/findAll")
    public List<Good> findAll() {
        log.info("查询所有");
        return service.selectAllGoods();
    }

    /**
     * 用于获取数据库表 goods的行数
     * @return int
     */
    @RequestMapping("/totalGood")
    @ResponseBody
    public int totalUser() {
        return this.service.findTotalGoods();
    }

    /**
     * 删除数据库中的数据
     * 通过id删除
     * @param id id
     * @return ResultBean
     */
    @ResponseBody
    @RequestMapping("/deleteGood")
    public ResultBean deleteUser(Integer id) {

        int i = service.deleteGood(id);
        if (i > 0) {
            return ResultBean.success();
        } else {
            return ResultBean.fail();
        }
    }

    /**
     * 添加商品
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ResultBean
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResultBean add(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("html/text;charset=utf-8");
        Good good = new Good();
        String goodName = request.getParameter("goodName");
        good.setGoodName(goodName);
        int goodPrice = Integer.parseInt(request.getParameter("goodPrice"));
        good.setGoodPrice(goodPrice);
        String goodImage = request.getParameter("goodImage");
        good.setGoodImage(goodImage);
        String brand = request.getParameter("brand");
        good.setBrand(brand);
        String hotGood = request.getParameter("hotGood");
        good.setHotGood(hotGood);
        int add = this.service.addGood(good);
        if (add > 0) {
            return ResultBean.success();
        } else {
            return ResultBean.fail();
        }

    }

    @ResponseBody
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public ResultBean addItem(@RequestBody String json) {
        System.out.println(json);
        Good good = JSON.parseObject(json, Good.class);
        int i = this.service.addGood(good);
        if (i > 0) {
            return ResultBean.success();
        } else {
            return ResultBean.fail();
        }
    }

}
