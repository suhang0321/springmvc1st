package com.suhang.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hang.su
 * @since 2017-10-25 8:37
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, Object o, Exception e) {
        CustomException customException=null;
      if (e instanceof CustomException){
          customException=(CustomException) e;
      }else{
          customException = new CustomException("未知错误");
      }
       String message = customException.getMessage();
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.addObject("message",message);
      modelAndView.setViewName("error");
      return modelAndView;
    }
}
