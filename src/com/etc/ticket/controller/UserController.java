package com.etc.ticket.controller;

import com.etc.ticket.dto.MyMessage;
import com.etc.ticket.dto.MyUserDto;
import com.etc.ticket.entity.User;
import com.etc.ticket.service.UserService;
import com.etc.ticket.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.PrintWriter;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/addUser")
    public  void  addUser(User user, HttpServletResponse response) throws Exception{
      boolean flag=userService.addUser(user);
      response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
      if(flag){
        out.print("<script>alert('注册成功');location.href='login.jsp';</script>");
      }else{
          out.print("<script>alert('注册失败');history.go(-1);</script>");
      }
       out.flush();
       out.close();
    }

    @RequestMapping("/checkLogin")
    public void checkLogin(String name, String pwd, HttpSession session,HttpServletResponse response) throws  Exception{
       User user= userService.queryUserByNameAndPwd(name,pwd);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
       if(user!=null){
           //保存到会话域中
           session.setAttribute("loginuser",user);
           out.print(1);
       }else{
           out.print(0);
       }
        out.flush();
        out.close();
    }



    @RequestMapping("/loginout")
    public void loginout(HttpServletResponse response,HttpSession session) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        MyMessage my=new MyMessage();
        try{
           session.invalidate();
           my.setCode("200");
           my.setFlag(1);
           my.setInfo("注销成功");
       }catch (Exception e){
           my.setFlag(0);
           my.setInfo("注销时发生异常");
           my.setCode("500");
       }
        Gson gson=new Gson();
        out.print(gson.toJson(my));
        out.flush();
        out.close();
    }

    @RequestMapping("/saveUser")
    public void saveUser(MyUserDto dto, HttpServletResponse response, HttpServletRequest request) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
          //获取当前服务器所在的磁盘地址
        String path=  request.getServletContext().getRealPath("/upload");
        System.out.println("上传的地址path:"+path);
         //判断当前文件夹是否存在,不存在则创建
        File file =new File(path);
        if(!file.exists()){
           file.mkdirs();
       }

        //从会话中获取当前用户
        User user= (User) request.getSession().getAttribute("loginuser");
        String filename=null;
        if(dto.getUserlogo().getOriginalFilename().equals("")){
            filename= user.getUser_logo();
        }else{
            //获取当前上传的文件名
            filename=  dto.getUserlogo().getOriginalFilename();
            // 对该文件进行重命名   当前系统时间毫秒数+原文件名
            filename=System.currentTimeMillis()+"-"+filename;
            //获取要上传的文件的路径对象
            File file2=new File(path+"/"+filename);

            try{
                FileUtils.copyInputStreamToFile(dto.getUserlogo().getInputStream(),file2);
                System.out.println("文件上传成功！！！");
            }catch (Exception e){
                out.print("<script>alert('保存失败，发生了异常');history.go(-1);</script>");
            }
        }

      try{
         user.setUser_email(dto.getUseremail());
         user.setUser_logo(filename);
         user.setUser_pwd(dto.getUserpwd());
         user.setUser_sex(dto.getSex());
          //调用保存用户的业务逻辑
          if(userService.updateUser(user)){
              //重新设置session用户
              request.getSession().setAttribute("loginuser",user);
              out.print("<script>alert('保存成功');location.href='admin/userinfo.jsp';</script>");
          }
          else{
              out.print("<script>alert('保存失败');history.go(-1);</script>");
          }
      }catch (Exception e){
         e.printStackTrace();
          out.print("<script>alert('保存失败，发生了异常');history.go(-1);</script>");
      }
        out.flush();
        out.close();


    }



}
