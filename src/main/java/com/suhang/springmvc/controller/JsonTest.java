package com.suhang.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suhang.springmvc.po.ItemsCustomer;

/**
 * @author hang.su
 * @since 2017-10-17 12:24
 */
@Controller
public class JsonTest {
   @RequestMapping("/requestjson")
    public @ResponseBody ItemsCustomer requestjson(@RequestBody ItemsCustomer itemsCustomer,HttpServletRequest request){
       request.getParameter("itemsCustomer");
        return itemsCustomer;
    }
    @RequestMapping("/requestkeyvalue")
    public @ResponseBody ItemsCustomer requestkeyvalue(ItemsCustomer itemsCustomer){
        return itemsCustomer;
    }


}
