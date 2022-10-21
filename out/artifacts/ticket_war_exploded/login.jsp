<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/10/14
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>梦田票务</title>
    <link href="css/header.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type=text/javascript src="js/jquery-1.7.1.min.js"></script>
    <script type=text/javascript src="js/ifocus.js"></script>
    <script type="text/javascript" src="js/scool.js"></script>
    <script type="text/javascript" src="js/imgp.js"></script>
    <script type="text/javascript" src="js/jquery.switchable[all].min.js"></script>
    <script type="text/javascript" src="js/jquery.jcarousel.pack.js"></script>
    <script type="text/javascript" src="js/datepicker.js"></script>
    <script type="text/javascript" src="js/jquery.fancybox-1.3.4.pack.js"></script>
    <link rel="stylesheet" type="text/css" href="css/jquery.fancybox-1.3.4.css" media="screen" />
    <script type="text/javascript" src="js/jquery.ad-gallery.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script src="js/foucsbox.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/bigpicroll.js"></script>

    <script type="text/javascript">
        $(function() {

            var galleries = $('.ad-gallery').adGallery();
            $('#switch-effect').change(
                function() {
                    galleries[0].settings.effect = $(this).val();
                    return false;
                }
            );
            $('#toggle-slideshow').click(
                function() {
                    galleries[0].slideshow.toggle();
                    return false;
                }
            );
            $('#toggle-description').click(
                function() {
                    if(!galleries[0].settings.description_wrapper) {
                        galleries[0].settings.description_wrapper = $('#descriptions');
                    } else {
                        galleries[0].settings.description_wrapper = false;
                    }
                    return false;
                }
            );
        });
    </script>
   <script>
       function login(){
         //获取用户名和密码
         var name=$("#name").val();
         var pwd=$("#pwd").val();

         $.ajax({
             url:"checkLogin.do",
             data:{name:name,pwd:pwd},
             dataType:"text",
             success:function(msg){
                 if(msg==1){
                   alert('登录成功');
                   location.href="index.jsp";
                 }else{
                     alert('账号名称或者密码错误');
                 }
             }
         });


       }


   </script>

    <!--[if IE 6]>
    <script src="js/DD_belatedPNG.js"></script>
    <script>
        DD_belatedPNG.fix('.but_gp,.rslides');
    </script>
    <![endif]-->
</head>
<body>
<div id="header">
   <jsp:include page="head.jsp"></jsp:include>


    <div id="site_nav">
        <div class="clearfix nav_post">
            <span><a href="#">精彩专题</a>|<a href="#">最新动态</a></span><p class="yahei"><a href="#">首 页</a><a href="#">巡 演</a><a href="#">订 票</a><a href="#">售票场馆</a></p>
        </div>
    </div>
</div>



<div id="login_mainbox">

    <div class="left">

    </div>
    <div class="right">
        <div class="cont">
            <form id="form2" name="form2" method="post" action="">
                <p>账　号：<input type="text" name="name" id="name"  class="input_sty" /></p>

                <p>密　码：<input type="text" name="pwd"  id="pwd"  class="input_sty" /></p>
                <p>验证码：<input type="text" name="textfield2"  class="input_sty2" /></p>
                <p class="mdl">
                    <label>
                        <input type="checkbox" name="checkbox" id="checkbox" />
                    </label>
                    十天内免登陆</p>
                <p class="dl">
                    <label>
                        <input type="button" name="button2" id="button2" value="登 陆" onclick="login()" /><span><a href="#">忘记密码?</a></span>
                    </label>
                </p>
            </form>
            <p class="zc"><a href="#"><img src="images/icon_zc.gif" width="151" height="27" /></a></p>
        </div>

    </div>

    <div class="clear"></div>




</div>





<div class="changguan_focus"></div>
<jsp:include page="foot.jsp"></jsp:include>


</body>
</html>
