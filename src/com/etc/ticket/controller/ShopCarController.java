package com.etc.ticket.controller;

import com.etc.ticket.dto.MyMessage;
import com.etc.ticket.dto.ShopCarDto;
import com.etc.ticket.entity.Price;
import com.etc.ticket.entity.ShopCar;
import com.etc.ticket.entity.User;
import com.etc.ticket.service.PriceService;
import com.etc.ticket.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class ShopCarController {

    @Autowired
    private ShopCarService shopCarService;
    @Autowired
    private PriceService priceService;

    public PriceService getPriceService() {
        return priceService;
    }

    public void setPriceService(PriceService priceService) {
        this.priceService = priceService;
    }

    public ShopCarService getShopCarService() {
        return shopCarService;
    }

    public void setShopCarService(ShopCarService shopCarService) {
        this.shopCarService = shopCarService;
    }

    @RequestMapping("/getShopCarNum")
    @ResponseBody
    public MyMessage getShopCarNum(HttpSession session){
        MyMessage my=new MyMessage();
       User user= (User) session.getAttribute("loginuser");
       if(user==null){
          //还没有登录
           my.setData(0);
       }else{
         //如果有登录，查询购物车表中当前用户id且状态是待支付状态
           Integer userid=user.getUser_id();
           String status="待支付";
            List<ShopCar> list= shopCarService.queryNumByUseridAndStatus(userid,status);
           //判断list长度，如果为0，则my.setData(0)，如果不为0，遍历，取出数量累加，my.setData(累加后的值)
           if(list==null||list.size()==0){
               my.setData(0);
           }
           else{
               int count=0;
               for(int i=0;i<list.size();i++){
                   count=count+list.get(i).getShopcar_num();
               }
               my.setData(count);
           }
       }
        return my;
    }


    @RequestMapping("/addshopcar")
    public void addshopcar(Integer num, Double price, Integer sessionid, HttpSession session, HttpServletResponse response) throws  Exception{
          //判断当前用户是否已经登录
           User user= (User) session.getAttribute("loginuser");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
           if(user==null){
               //如果没有登录则弹出提示信息并跳转到登录页面
             out.print("<script>alert('您尚未登录，请先登录！');location.href='login.jsp';</script>");
           }
           else if(num==null||num<=0){
               out.print("<script>alert('请添加合理的购买数量！');history.go(-1);</script>");
           }
           else{
               //如果有登录，获取当前登录用户的id
               Integer user_id=user.getUser_id();
               //根据price和sessionid 查询t_price 中的price_id
              Price p= priceService.queryPriceBySessionIdAndPrice(price,sessionid);
              if(p==null){
              out.print("<script>alert('参数异常，请重新再试！');location.href='login.jsp';</script>");
              }else{
                  Integer price_id=p.getPrice_id();
                  //将数量，用户id，价格id 状态是待支付 添加到t_shopcar表中
                  ShopCarDto dto=new ShopCarDto();
                  dto.setShopcar_num(num);
                  dto.setShopcar_price(price_id);
                  dto.setShopcar_user(user_id);
                  dto.setShopcar_status("待支付");
                  //在根据是否添加成功给出对应的提示
                if(shopCarService.addShopCar(dto)){
                    out.print("<script>alert('成功添加商品到购物车！');location.href='index.jsp';</script>");
                }else{
                    out.print("<script>alert('添加购物车失败！');history.go(-1);</script>");
                }
              }

           }
             out.flush();
             out.close();
    }


}
