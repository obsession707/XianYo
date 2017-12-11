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
                    <input type="password" class="form-control" id="inputPassword"
                           placeholder="请输入新密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPasswordAgain"
                           placeholder="请再次确认输入的密码">
                </div>
            </div>
        </form>
    </div>
</div>
<div class="center-block" style="width: 170px">
    <p>
        <button type="button" class="btn btn-default btn-lg" style="background-color:rgba(94, 163, 129, 1) ;width: 150px;color: white;">确定修改</button>
    </p>
</div>
</body>
</html>
