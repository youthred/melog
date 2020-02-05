package net.add1s.controller;

import com.alibaba.fastjson.JSONObject;
import net.add1s.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mahoshojo
 */
@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signIn")
    public String loginPage() {
        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            // 非匿名用户，已登录，跳转到首页
            return "redirect:/";
        }
        return "sign/sign_in";
    }

    @GetMapping("/signUp")
    public String register() {
        return "sign/sign_up";
    }

    @GetMapping("/nickname")
    @ResponseBody
    public String nickname() {
        return userService.findUserByUsername(getUser().getUsername()).getNickname();
    }

    private User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
