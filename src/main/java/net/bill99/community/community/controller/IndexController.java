package net.bill99.community.community.controller;

import net.bill99.community.community.dto.QuestionDto;
import net.bill99.community.community.entity.Question;
import net.bill99.community.community.mapper.QuestionMapper;
import net.bill99.community.community.mapper.UserMapper;
import net.bill99.community.community.entity.User;
import net.bill99.community.community.server.QuestionDtoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 23:19 2020/2/13
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionDtoServer questionDtoServer;
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        if (cookies != null & cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.getByToekn(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        List<QuestionDto> questions = questionDtoServer.list();
        model.addAttribute("questions",questions);
        return "index";
    }
}
