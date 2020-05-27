package cn.edu.svtcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author demo
 * @title DataController
 * @description
 * @date 2020/05/26/20:33
 */
@Controller
public class DataController {
    @RequestMapping("/data")
    public String data(){
        return "data";
    }
}
