package com.liu.exceptionResolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 异常对象
     * @return 跳转到错误视图,并且可以更改某些数据
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mav=new ModelAndView();
        if (e instanceof Exception){
            mav.addObject("Customer","类型转换");
            mav.setViewName("error");
        }
        return mav;
    }
}
