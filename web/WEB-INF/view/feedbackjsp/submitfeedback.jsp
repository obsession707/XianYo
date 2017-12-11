<%--
  Created by IntelliJ IDEA.
  User: 39409
  Date: 2017/9/15
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>反馈</title>
    <link rel="shortcut icon " type="images/x-icon" href="../../static/icon/fish.ico">
    <link rel="stylesheet" href="../../static/css/sendblog.css"/>
    <script src="../../static/js/keypress.js"></script>
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script src="../../static/js/buttonclick.js"></script>
</head>
<body>
<button onclick="document.getElementById('feedbackPage').style.display='block'"
        style="width:auto;background-color:rgba(94, 163, 129, 1)">反馈问题</button>

<div id="feedbackPage" class="modal">
    <form class="modal-content animate" id="messageForm" method="post" action="feedback.user" enctype="multipart/form-data">

        <div class="imgcontainer">
            <span onclick="document.getElementById('feedbackPage').style.display='none'" class="close" title="Close Modal">&times;</span>
            <img src="../../static/image/write.png" alt="Avatar" class="avatar">
        </div>

        <div class="contextContainer">
            <label><b>跟我们反馈吧：）</b></label><br/>
            <label><b>标题/问题概要</b></label><br/><br/>
            <input type="text" name="feedbacktitle"><br/>
            <label><b>反馈内容</b></label><br/><br/>
            <textarea id="message" name="feedbackcontext"></textarea>
            <div id="charactersLeft">180 characters</div>
            <div id="lastKey"></div>
        </div>

        <div class="container" style="background-color:#f1f1f1; white-space: nowrap;">
            <button type="submit" id="fasong" style="width: auto; background-color:rgba(94, 163, 129, 1)">提交反馈</button>
            <button type="button" style="width: auto;" onclick="document.getElementById('feedbackPage').style.display='none'" class="cancelbtn">Cancel</button>
        </div>
    </form>
</div>


    <form action="feedbackno.user">
        <input type="hidden" name="state" value="0">
        <button type="submit" >查看未审核反馈</button>
    </form>
    <form action="feedbackal.user">
        <input type="hidden" name="state" value="1">
        <button type="submit" >查看已审核反馈</button>
    </form>
</body>
</html>
