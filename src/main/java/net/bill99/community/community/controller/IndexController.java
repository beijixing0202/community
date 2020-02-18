package net.bill99.community.community.controller;

import net.bill99.community.community.mapper.UserMapper;
import net.bill99.community.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wsy
 * @Description:
 * @Date: Create in 23:19 2020/2/13
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie :cookies){
            if(cookie.equals("token")){
                String token = cookie.getValue();
                User user = userMapper.getByToekn(token);
                if(user !=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        return "index";
    }
}
