package com.suhang.springmvc.controller;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;


import com.suhang.springmvc.controller.validation.ValidGroup1;
import com.suhang.springmvc.controller.validation.ValidGroup2;
import com.suhang.springmvc.exception.CustomException;
import com.suhang.springmvc.po.ItemsCustomer;
import com.suhang.springmvc.po.ItemsCustomerVo;
import com.suhang.springmvc.serivice.ItemsService;

/**
 * @author hang.su
 * @since 2017-09-27 12:02
 */
@Controller
@RequestMapping("/Items")
public class ItemController1 {

    @Autowired
    private ItemsService itemsService;

    @ModelAttribute("itemtypes")
    public Map<String, String> getItemTypes() {
        Map<String, String> itemtypes = new HashMap<String, String>();
        itemtypes.put("101", "电脑");
        itemtypes.put("102", "手机");
        return itemtypes;
    }

    @RequestMapping("/queryitem")
    public ModelAndView queryitem(HttpServletRequest request, ItemsCustomerVo itemsCustomerVo) throws Exception {
        System.out.println(request.getParameter("id"));
        List<ItemsCustomer> itemsList = itemsService.findItemsList(itemsCustomerVo);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("items/queryitem");
        return modelAndView;
    }

    @RequestMapping(value = "/editItems")
    public ModelAndView editItems(@RequestParam("id") Integer id, ItemsCustomerVo itemsCustomerVo) throws Exception {
        ItemsCustomer itemsCustomer = itemsService.findItemsById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsCustomer", itemsCustomer);
        modelAndView.setViewName("items/editItems");
        return modelAndView;
    }

    @RequestMapping(value = "/editItemsSubmit", method = {RequestMethod.POST})
    public String editItemsSubmit(HttpServletRequest request,
        Integer id, Model model,
        @ModelAttribute("itemsCustomer") @Validated(value = {ValidGroup1.class}) ItemsCustomer itemsCustomer,
        BindingResult bindingResult, MultipartFile items_pic) throws Exception {

        request.getParameter("itemsCustomer");
        System.out.println(itemsCustomer);
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors", allErrors);
            return "forward:/Items/editItems";
        }
        String originalFilename = items_pic.getOriginalFilename();
        if (items_pic!=null &&originalFilename.length()>0&& originalFilename!=null){
            String pic_path ="E:\\develop\\upload\\temp\\";
            String newFile_Name =UUID.randomUUID()+originalFilename.substring(0,originalFilename.length()-5);
            File newFile = new File(pic_path+newFile_Name);
            items_pic.transferTo(newFile);
            itemsCustomer.setPic(newFile_Name);
        }
        itemsService.updateItems(id, itemsCustomer);
        return "success";

    }

    @RequestMapping("/itemsView/{id}")
    public @ResponseBody
    ItemsCustomer itemsView(@PathVariable("id") Integer id) throws Exception {
        ItemsCustomer itemsCustomer = itemsService.findItemsById(id);
        return itemsCustomer;
    }

    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id) throws Exception {
        itemsService.deleteItems(items_id);
        return "success";
    }

    @RequestMapping("/editeItemsList")
    public ModelAndView editeItemsList(ItemsCustomerVo itemsCustomerVo) throws Exception {
        List<ItemsCustomer> itemsList = itemsService.findItemsList(null);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("items/editeItemsList");

        return modelAndView;
    }

    @RequestMapping("/editeItemsListSubmit")
    public String editeItemsListSubmit(HttpServletRequest request,
        ItemsCustomerVo itemsCustomerVo) throws Exception {
        request.getParameter("itemsCustomerVo");
        List<ItemsCustomer> customerList = itemsCustomerVo.getItemsList();
        itemsService.updateItemsList(customerList);
        return "success";
    }

}
