package net.bill99.community.community.controller;

import net.bill99.community.community.entity.Question;
import net.bill99.community.community.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 20:41 2020/2/18
 */
@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    @GetMapping("/publish")
    public String getPublish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(name="title") String title,
            @RequestParam(name="description") String description,
            @RequestParam(name="tag") String tag){
        questionMapper.create(new Question());
        return "publish";
    }
}
