<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/10/14
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    function myloginout(){
        if(confirm("是否注销当前用户？")){
          $.ajax({
              url:"loginout.do",
              dataType:"json",
              success:function(msg){
                  if(msg.flag==1){
                      //注销成功
                      alert("注销成功");
                      //刷新当前页面
                      location.reload();
                  }
              }
          });
        }
    }
</script>

<script>
$(document).ready(function(){
  $.ajax({
  url:"getShopCarNum.do",
  dataType:"json",
  success:function(msg){
      $("#myshopcount").html(msg.data);
  }
  });
});

</script>

<div class="w1002" style="overflow:visible; height:105px;">

    <div class="header_top">
        <c:if test="${sessionScope.loginuser==null}">
            <a href="login.jsp" class="dl">用户登录</a><a href="register.jsp" class="dl">注册用户</a>
        </c:if>
        <c:if test="${sessionScope.loginuser!=null}">
           欢迎你,${sessionScope.loginuser.user_name} &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:myloginout()" class="dl">注销用户</a>
        </c:if>
        |<a href="admin/userinfo.jsp">我的梦田</a><span><a href="#">购物车</a> <b class="dl" id="myshopcount">0</b> 件</span><a href="javascript:void(0)">梦田导航</a><a href="javascript:void(0)">帮助中心</a><a href="javascript:void(0)" class="phone">手机购票</a><a href="javascript:void(0)" class="jm">演出剧目</a><a href="javascript:void(0)" class="cx">真伪查询</a>
    </div>

    <div class="site_logo floatl">
        <a href="javascript:void(0)"><img src="images/site_logo.gif" width="170" height="65"></a>
    </div>

    <div class="header_city floatl search_box">
        <h3>长 沙</h3>
        <div id="changeCity">切换城市</div>
        <div class="selCity" id="allCity" style="DISPLAY: none">
            <div class="area">
                <a href="javascript:void(0)">上海</a>
                <a href="javascript:void(0)">上海</a>
                <a href="javascript:void(0)">上海</a>
                <a href="javascript:void(0)">上海</a>
                <a href="javascript:void(0)">上海</a>
                <a href="javascript:void(0)">上海</a>
            </div>
        </div>
    </div>


    <div class="header_search floatl">
        <p class="hot">热门搜索：<a href="javascript:void(0)">刘德华</a>|<a href="javascript:void(0)">周杰伦</a>|<a href="javascript:void(0)">五月天</a>|<a href="javascript:void(0)">何韵诗</a>|<a href="javascript:void(0)">许巍</a>|<a href="javascript:void(0)">陶喆</a>|<a href="javascript:void(0)">更多</a></p>
        <form id="form1" name="form1" method="post" action="">
            <div><input type="text" name="textfield" id="textfield" class="input_style"><input type="submit" name="button" id="button" value=" " class="but_tj"></div>
        </form>
    </div>
</div>
