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
     * @param e �쳣����
     * @return ��ת��������ͼ,���ҿ��Ը���ĳЩ����
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mav=new ModelAndView();
        if (e instanceof Exception){
            mav.addObject("Customer","����ת��");
            mav.setViewName("error");
        }
        return mav;
    }
}
