<%--
  Created by IntelliJ IDEA.
  User: 39409
  Date: 2017/9/21
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员找回密码</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron" style="background-color:rgba(94, 163, 129, 1)">
    <h1 style="color:white;margin-left: 40px;">找回密码</h1>

    <div class="center-block" style="width:570px" >
        <form class="form-horizontal" role="form" style="width: 600px;margin-top: 200px;">
            <div class="form-group">
                <div class="col-sm-10">
                    <div style="float: left;"><input type="text" class="form-control" id="inputNuorEm"
                                                     placeholder="请输入注册用手机号或邮箱" style="width: 397px">
                    </div>
                    <div style="float: left;">
                        <button type="submit" class="btn btn-default" >获取验证码</button>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-10" style="width: 426px">
                    <input type="number" class="form-control" id="inputPassword"
                           placeholder="请输入验证码">
                </div>
            </div>
        </form>
    </div>
</div>
<div class="center-block" style="width: 170px">
    <p>
        <button type="button" class="btn btn-default btn-lg" style="background-color:rgba(94, 163, 129, 1) ;width: 150px;color: white;" onclick="{location.href='找回密码2.html'}">确定</button>
    </p>
</div>
</body>
</html>
