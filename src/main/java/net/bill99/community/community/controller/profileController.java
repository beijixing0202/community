package net.bill99.community.community.controller;

import net.bill99.community.community.dto.PaginationDto;
import net.bill99.community.community.dto.QuestionDto;
import net.bill99.community.community.entity.User;
import net.bill99.community.community.mapper.UserMapper;
import net.bill99.community.community.server.QuestionDtoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 15:10 2020/3/22
 */
@Controller
public class profileController {
/*    @Autowired
    private UserMapper userMapper;*/
    @Autowired
    private QuestionDtoServer questionDtoServer;
    @GetMapping("profile/{action}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "action") String action ,
                          Model model,
                          @RequestParam(name = "page" ,defaultValue = "1") Integer page,
                          @RequestParam(name="size",defaultValue = "5") Integer size){
       /* User user=null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null & cookies.length != 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.getByToekn(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }*/
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return "redirect:/";
        }
        if("question".equals(action)){
            model.addAttribute("section","question");
            model.addAttribute("sectionName","我的提问");
        }
        if("replise".equals(action)){
            model.addAttribute("section","replise");
            model.addAttribute("sectionName","最近回复");
        }
        PaginationDto pagination = questionDtoServer.list(user.getId(), page, size);
        model.addAttribute("pagination",pagination);
        return "profile";
    }
}
