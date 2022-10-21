package com.etc.ticket.interceptor;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.LinkedList;


public class FileUploadInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //将其强转成 MultipartHttpServletRequest 对象
        MultipartHttpServletRequest request2= (MultipartHttpServletRequest) httpServletRequest;
        //通过表单中上传文件的name获取提交的文件对象
        LinkedList<MultipartFile> list= (LinkedList<MultipartFile> ) request2.getMultiFileMap().get("userlogo");
        //获取具体的文件名称
        System.out.println("获取的文件名称："+ list.get(0).getOriginalFilename());
        //判断文件是否是“”或者是由具体的值
       if("".equals(list.get(0).getOriginalFilename())){
           return true;  //继续往下执行（不修改头像的情况下保存用户）
       }else{
           //验证修改头像的文件后缀是否是图片文件
           String filename=list.get(0).getOriginalFilename();
           if(filename.endsWith(".jpg")||filename.endsWith(".png")||filename.endsWith(".gif")||filename.endsWith(".jpeg")){
               return true;
           }else{
               //通常做法是给提示然后再跳转
               httpServletResponse.setContentType("text/html;charset=utf-8");
               PrintWriter out= httpServletResponse.getWriter();
               out.print("<script>alert('上传的文件不是图片类型，请重新修改');history.go(-1);</script>");
               out.flush();
               out.close();
              return false;
           }

       }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
