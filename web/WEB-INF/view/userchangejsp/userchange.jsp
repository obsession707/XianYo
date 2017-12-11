<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 39409
  Date: 2017/9/19
  Time: 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../../static/css/regist.css" rel="stylesheet" type="text/css">
    <link href="../../static/css/login.css" rel="stylesheet" type="text/css">
    <link href="../../static/css/amazeui.cropper.css" rel="stylesheet" type="text/css">
    <link href="../../static/css/amazeui.min.css" rel="stylesheet" type="text/css">
    <link href="../../static/css/custom_up_img.css" rel="stylesheet" type="text/css">
    <link href="../../static/icon/fish.ico" rel="shortcut icon " type="images/x-icon">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <script src="../../static/js/loginandregister.js"></script>
    <script src="../../static/js/buttonclick.js"></script>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="https://cdn.bootcss.com/amazeui/2.7.2/js/amazeui.min.js" charset="utf-8"></script>
    <script src="../../static/js/cropper.min.js" charset="utf-8"></script>
    <script src="../../static/js/custom_up_img.js" charset="utf-8"></script>
    <script type="text/javascript">
    </script>
    <title>修改用户信息</title>
</head>
<body>
<%--修改--%>

<button onclick="document.getElementById('id02').style.display='block'" style="width:auto;background-color:rgba(94, 163, 129, 1)">修改用户信息</button>
<div id="id02" style="display: none;">

    <form class="modal-content animate" action="user.change" method="post">
        <div class="imgcontainer">
            <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Close Modal">&times;</span>
            <div class="up-img-cover"  id="up-img-touch" >
                <img class="am-circle"  id="myHead" name="myHead" alt="点击图片上传" src="../../static/image/fishme.png"
                     data-am-popover="{content: '点击上传头像', trigger: 'hover focus'}" style="width: 100px;height: 100px;">
            </div>
            <%--<img src="../../static/image/fishme.png" alt="Avatar" class="avatar">--%>
            <%--<div id="id03" style="display: block;z-index: 999">--%>
                <%--<!--图片上传框-->--%>
                <div class="am-modal am-modal-no-btn up-modal-frame" tabindex="-1" id="up-modal-frame">
                    <div class="am-modal-dialog up-frame-parent up-frame-radius">
                        <div class="am-modal-hd up-frame-header">
                            <label>修改头像</label>
                            <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
                        </div>
                        <div class="am-modal-bd  up-frame-body">
                            <div class="am-g am-fl">
                                <div class="am-form-group am-form-file">
                                    <div class="am-fl">
                                        <button type="button" class="am-btn am-btn-default am-btn-sm">
                                            <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
                                    </div>
                                    <input type="file" class="up-img-file">
                                </div>
                            </div>
                            <div class="am-g am-fl">
                                <div class="up-pre-before up-frame-radius">
                                    <img alt="" src="" class="up-img-show" id="up-img-show" >
                                </div>
                                <div class="up-pre-after up-frame-radius" id="Headshot"></div>
                            </div>
                            <div class="am-g am-fl">
                                <div class="up-control-btns">
                                    <span class="am-icon-rotate-left"   id="up-btn-left"></span>
                                    <span class="am-icon-rotate-right"  id="up-btn-right"></span>
                                    <span class="am-icon-check up-btn-ok" url="headshot.change"
                                          parameter="{width:'100',height:'100'}"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%--<!--加载框-->--%>
                <div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="up-modal-loading">
                    <div class="am-modal-dialog">
                        <div class="am-modal-hd">正在上传...</div>
                        <div class="am-modal-bd">
                            <span class="am-icon-spinner am-icon-spin"></span>
                        </div>
                    </div>
                </div>
                <%--<!--警告框-->--%>
                <div class="am-modal am-modal-alert" tabindex="-1" id="up-modal-alert">
                    <div class="am-modal-dialog">
                        <div class="am-modal-hd">信息</div>
                        <div class="am-modal-bd"  id="alert_content">
                            成功
                        </div>
                        <div class="am-modal-footer">
                            <span class="am-modal-btn">确定</span>
                        </div>
                    </div>
                </div>
        <%--</div>--%>

        <div class="container">
            <label><b>修改绑定邮箱：${sessionScope.User.email}</b></label>
            <input type="text" placeholder="Enter Email" name="email"
                   id="mail">
            <span id="checkmail"></span><br/>
            <span id="mailya"></span>
            <br/>

            <label><b>修改个性签名：${sessionScope.User.selfintroduce}</b></label>
            <input type="text" placeholder="Enter selfIntroduce" name="selfIntroduce" id="selfintroduce"><br/>

            <label><b>修改绑定手机号码：${sessionScope.User.phonenumber}</b></label>
            <input type="text" placeholder="Enter phone number" name="phonenumber"
                   id="phonenumber" >
            <span id="checkphonenumber"></span><br/>
            <span id="phonenumberya"></span>
            <br/>

            <label><b>修改用户名：${sessionScope.User.username}</b></label>
            <input type="text" placeholder="Enter Username" name="username"
                   id="regname" />
            <span id="checkname"></span><br/>
            <label><b>修改密码</b></label>

            <input type="password" placeholder="Enter Password" name="password" id="thepassword" required>

            <label><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="password-repeat"
                   id="secondpassword" onkeyup="checkpassword()" required>
            <span id="checkpassword"></span>


        </div>

        <div class="container" style="background-color:#f1f1f1; white-space: nowrap;">
            <button type="submit" style="width: auto;background-color:rgba(94, 163, 129, 1)" onclick="warn()">确认修改</button>
            <button type="button"  style="width: auto;" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
