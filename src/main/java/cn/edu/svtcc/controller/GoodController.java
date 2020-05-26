package cn.edu.svtcc.controller;

import cn.edu.svtcc.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author demo
 * @title GoodController
 * @description
 * @date 2020/05/26/7:24
 */

@Controller
public class GoodController {
    private GoodService service;

    /**
     * 通过set注入容器
     * @param service goodService
     */
    @Autowired
    public void setService(GoodService service) {
        this.service = service;
    }

    /**
     * 测试
     * @param model model
     * @return hh.html
     */
    @RequestMapping("/hh")
    public String hh(@NonNull Model model) {
        model.addAttribute("demo", service.selectAllGoods());
        model.addAttribute("buy",service.selectBuyGoods());
        return "hh";
    }


    /**
     * 从数据库中获取图片的地址
     * @param model model
     * @return index.html
     */
    @RequestMapping("/index")
    public String index(@NonNull Model model) {
        model.addAttribute("abc", service.selectAllGoods());
        model.addAttribute("hot", service.selectGoods());
        model.addAttribute("buy",service.selectBuyGoods());

        return "index";
    }
}
