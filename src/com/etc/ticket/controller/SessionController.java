package com.etc.ticket.controller;

import com.etc.ticket.dto.MyMessage;
import com.etc.ticket.dto.MySessionDto;
import com.etc.ticket.entity.Price;
import com.etc.ticket.entity.Session;
import com.etc.ticket.service.SessionService;
import com.etc.ticket.service.impl.SessionServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class SessionController {
    @Autowired
    private SessionService sessionService;

    public SessionService getSessionService() {
        return sessionService;
    }

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @RequestMapping("/getNewsSession")
    public void getNewsSession(Integer num, Integer type, HttpServletResponse response) throws  Exception{
        MyMessage my=new MyMessage();
        try{
            List<Session> list= sessionService.querySessionForNumsNewsByType(num,type);
            my.setData(list);
            my.setCode("200");
            if(list==null||list.size()==0){
                my.setFlag(0);
                my.setInfo("没有相应数据");
            }else{
                my.setFlag(1);
                my.setInfo("有相应数据");
            }
        }catch (Exception e){
            my.setCode("500");
            my.setInfo("服务器内部异常！！！！");
        }
        //将my转换成json字符串
        Gson gson=new Gson();
        String json=  gson.toJson(my);
        //输出到前端
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }


    @RequestMapping("/getSessionId")
    public void getSessionId(Integer sessionid, HttpServletResponse response, HttpServletRequest request) throws Exception{
     MySessionDto my= sessionService.querySessionById(sessionid);
     //判断my是否为空置
      if(my==null){
          response.setContentType("text/html;charset=utf-8");
          PrintWriter out=response.getWriter();
          out.print("<script>alert('查无次场次！');history.go(-1);</script>");
          out.flush();
          out.close();
      }else{
           //获取该场次的价格集合
           List<Price> list=my.getSession_prices();
           if(list!=null&&list.size()!=0){
               double maxprice=list.get(0).getPrice_price();
               double minprice=list.get(0).getPrice_price();
              for(Price price:list){
                   if(price.getPrice_price()>maxprice){
                       maxprice=price.getPrice_price();
                   }
                  if(price.getPrice_price()<minprice){
                      minprice=price.getPrice_price();
                  }
              }
              my.setMaxprice(maxprice);
              my.setMinprice(minprice);
           }
           //将my设置到请求域中，转发
            request.setAttribute("my",my);
           request.getRequestDispatcher("sessioninfo.jsp").forward(request,response);
      }
    }


}
