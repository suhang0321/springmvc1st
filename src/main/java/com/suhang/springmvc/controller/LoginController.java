package com.suhang.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hang.su
 * @since 2017-10-18 16:23
 */
@Controller
public class LoginController {
@RequestMapping("/Login")
    public String Login(HttpSession session,String username, String password)throws Exception{
        session.setAttribute("username" ,username);
        return "redirect: Items/queryitem.action";
    }
    public String Logout(HttpSession session)throws Exception{
        session.invalidate();
        return "redirect:Items/queryitem.action";
    }
}
