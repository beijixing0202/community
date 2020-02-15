package net.bill99.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 23:19 2020/2/13
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("first")
    @ResponseBody
    public String getFirst(){
        return "first";
    }
}
