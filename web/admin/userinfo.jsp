<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/10/17
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>梦田票务</title>
    <link href="../css/header.css" rel="stylesheet" type="text/css" />
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <script type=text/javascript src="../js/jquery-1.7.1.min.js"></script>
    <script type=text/javascript src="../js/ifocus.js"></script>
    <script type="text/javascript" src="../js/scool.js"></script>
    <script type="text/javascript" src="../js/imgp.js"></script>
    <script type="text/javascript" src="../js/jquery.switchable%5Ball%5D.min.js"></script>
    <script type="text/javascript" src="../js/jquery.jcarousel.pack.js"></script>
    <script type="text/javascript" src="../js/datepicker.js"></script>
    <script type="text/javascript" src="../js/jquery.fancybox-1.3.4.pack.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/jquery.fancybox-1.3.4.css" media="screen" />
    <script type="text/javascript" src="../js/jquery.ad-gallery.js"></script>
    <script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
    <script src="../js/foucsbox.js" type="text/javascript"></script>
    <script type="text/javascript" src="../js/bigpicroll.js"></script>
    <script type="text/javascript" src="../js/menu.js"></script>

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


    <!--[if IE 6]>
    <script src="js/DD_belatedPNG.js"></script>
    <script>
        DD_belatedPNG.fix('.but_gp,.rslides');
    </script>
    <![endif]-->

    <script>
        function previewFile() {
            var preview = document.getElementById("mylogo");
            // var preview2 = document.getElementById("mylogo2");
            var file  = document.querySelector('input[type=file]').files[0];
            var reader = new FileReader();
            reader.onloadend = function () {
                preview.src = reader.result;
                //  preview2.src = reader.result;
            }
            if (file) {
                reader.readAsDataURL(file);
            } else {
                preview.src = "";
                // preview2.src = "";
            }
        }

    </script>
</head>
<body>
<div id="header">
 <jsp:include page="${applicationScope.basePath}head.jsp"/>


    <div id="site_nav">
        <div class="clearfix nav_post">
            <span><a href="#">精彩专题</a>|<a href="#">最新动态</a></span><p class="yahei"><a href="#">首 页</a><a href="#">巡 演</a><a href="#">订 票</a><a href="#">售票场馆</a></p>
        </div>
    </div>
</div>




<div class="inside_member">
    <div class="member_leftnav">
        <h3><strong>会员中心</strong></h3>
        <h4>交易管理</h4>
        <ul>
            <li><a href="#">订单管理</a></li>
            <li><a href="#">我的积分</a></li>
            <li><a href="#">缺货登记</a></li>
            <li><a href="#">预定登记</a></li>
            <li><a href="#">演出通知</a></li>
            <li><a href="#">我的收藏</a></li>
        </ul>


        <h4>账户中心</h4>
        <ul>
            <li><a href="#">订单管理</a></li>
            <li><a href="#">我的积分</a></li>
            <li><a href="#">缺货登记</a></li>
            <li><a href="#">预定登记</a></li>
            <li><a href="#">演出通知</a></li>
            <li><a href="#">我的收藏</a></li>
        </ul>


    </div>



    <div class="member_rightc">
        <div class="xiugaimima member_boxsty">
            <p class="stitle"><strong>个人信息</strong></p>
            <form id="form2" name="form2" method="post" action="${applicationScope.basePath}saveUser.do" enctype="multipart/form-data">
               <input type="hidden" value="${sessionScope.loginuser.user_id}" name="userid">
                <table width="337" height="141" border="0" cellpadding="0" cellspacing="0" class="ziliao_table">
                    <tr>
                        <td width="65">登录账号：</td>
                        <td width="272">
                            <label>
                                <input type="text" name="username" id="username" readonly="readonly" class="input-text-2" value="${sessionScope.loginuser.user_name}"/>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>登录密码：</td>
                        <td><input type="password" name="userpwd" id="userpwd" class="input-text-2"  value="${sessionScope.loginuser.user_pwd}"/></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input type="password" name="checkpwd" id="checkpwd" class="input-text-2" value="${sessionScope.loginuser.user_pwd}"/></td>
                    </tr>
                    <tr>
                        <td>性　　别：</td>
                        <td>
                         <c:if test="${loginuser.user_sex=='男'}">
                             <label class="radio">
                                 <input type="radio"  value="男" name="sex"  checked="checked" /><span class="m">男</span>
                             </label>
                             <label class="radio">
                                 <input type="radio"  value="女" name="sex"  /><span class="f">女</span>
                             </label>
                             &nbsp;
                         </c:if>
                            <c:if test="${loginuser.user_sex=='女'}">
                                <label class="radio">
                                    <input type="radio"  value="男" name="sex"   /><span class="m">男</span>
                                </label>
                                <label class="radio">
                                    <input type="radio"  value="女" name="sex" checked="checked" /><span class="f">女</span>
                                </label>
                                &nbsp;
                            </c:if>

                        </td>
                    </tr>


                    <tr>
                        <td>出生日期：</td>
                        <td>
                            <input type="">
                        </td>
                    </tr>



                    <tr>
                        <td>用户邮箱：</td>
                        <td> <input type="text" class="input-text-2" name="useremail" value="${sessionScope.loginuser.user_email}" /></td>
                    </tr>

                    <tr>
                        <td>用户积分：</td>
                        <td><input id="userscore" type="text" class="input-text-2"  name="userscore" value="${sessionScope.loginuser.user_score}" readonly="readonly"/></td>
                    </tr>
                    <tr>
                        <td>用户头像：</td>
                        <td><input id="userlogo" type="file"   name="userlogo" value="" onchange="previewFile()"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <c:if test="${sessionScope.loginuser.user_logo==null}">
                                <img src="../images/1.jpg" id="mylogo" width="280" height="150">
                            </c:if>
                            <c:if test="${sessionScope.loginuser.user_logo!=null}">
                                <img src="../upload/${sessionScope.loginuser.user_logo}" id="mylogo" width="280" height="150">
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td> <input type="submit" name="button2" id="button2" value="保存" class="tj_buts" style="margin-left:0;" /></td>
                    </tr>
                </table>


            </form>
        </div>

    </div>



</div>




<div class="clear"></div>






</div>









<div class="changguan_focus"></div>
<jsp:include page="${applicationScope.basePath}foot.jsp"/>













</body>
</html>
