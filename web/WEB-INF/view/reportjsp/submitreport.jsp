<%--
  Created by IntelliJ IDEA.
  User: 39409
  Date: 2017/9/18
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>举报</title>
    <link rel="shortcut icon " type="images/x-icon" href="../../static/icon/fish.ico">
    <link rel="stylesheet" href="../../static/css/sendblog.css"/>
    <script src="../../static/js/keypress.js"></script>
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script src="../../static/js/buttonclick.js"></script>
</head>
<body>
<button onclick="document.getElementById('reportPage').style.display='block'"
        style="width:auto;background-color:rgba(94, 163, 129, 1)">举报</button>
<div id="reportPage" class="modal">
    <form class="modal-content animate" id="messageForm" method="post" action="report.user" enctype="multipart/form-data">

        <div class="imgcontainer">
            <span onclick="document.getElementById('reportPage').style.display='none'" class="close" title="Close Modal">&times;</span>
            <img src="../../static/image/write.png" alt="Avatar" class="avatar">
        </div>

        <div class="contextContainer">
            <label><b>有事记得举报：）</b></label><br/>
            <label><b>这里是根据aim id显示的被举报内容,先填aim id</b></label><br/><br/>
            <input type="text" name="aimid"><br/>
            <label><b>举报原因</b></label><br/><br/>
            <textarea id="message" name="reportreason"></textarea>
            <div id="charactersLeft">180 characters</div>
            <div id="lastKey"></div>
        </div>

        <div class="container" style="background-color:#f1f1f1; white-space: nowrap;">
            <button type="submit" id="fasong" style="width: auto; background-color:rgba(94, 163, 129, 1)">举报</button>
            <button type="button" style="width: auto;" onclick="document.getElementById('reportPage').style.display='none'" class="cancelbtn">Cancel</button>
        </div>
    </form>
</div>

<h1>${message}</h1>
<form action="reportno.user">
    <input type="hidden" name="state" value="0">
    <button type="submit" >查看未审核举报</button>
</form>
<form action="reportal.user">
    <input type="hidden" name="state" value="1">
    <button type="submit" >查看已审核举报</button>
</form>
</body>
</html>
