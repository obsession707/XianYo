<%--
  Created by IntelliJ IDEA.
  User: 39409
  Date: 2017/9/18
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="shortcut icon " type="images/x-icon" href="../../static/icon/fish.ico">
    <link rel="stylesheet" href="../../static/css/sendblog.css"/>
    <script src="../../static/js/inputblog.js"></script>
    <script src="../../static/js/keypress.js"></script>
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script src="../../static/js/buttonclick.js"></script>
</head>
<body>
<button onclick="document.getElementById('scenicPage').style.display='block'"
        style="width:auto;background-color:rgba(94, 163, 129, 1)">发个景点</button>

<div id="scenicPage" class="modal">
    <form class="modal-content animate" id="messageForm" method="post" action="scenic.user" enctype="multipart/form-data">

        <div class="imgcontainer">
            <span onclick="document.getElementById('scenicPage').style.display='none'" class="close" title="Close Modal">&times;</span>
            <img src="../../static/image/write.png" alt="Avatar" class="avatar">
        </div>

        <div class="contextContainer">
            <label><b>发个景点吧：）</b></label><br/>
            <input type="text" name="scenicname"><br/>
            <label><b>景点概述</b></label><br/><br/>
            <textarea id="synopsis" name="scenicsynopsis"></textarea>
            <label><b>景点交通</b></label><br/><br/>
            <textarea id="traffic" name="scenictraffic"></textarea>
            <label><b>景点食物</b></label><br/><br/>
            <textarea id="food" name="scenicfood"></textarea>
            <label><b>加个图吧：D</b></label><br/>
            <div class="imagesContainer"onload="loadImageFile(this)">
                <input id="uploadImages" multiple type="file" name="scenicPhoto"
                       accept="image/*" onchange="loadImageFile(event)"/>
            </div>
            <div id="charactersLeft">180 characters</div>
            <div id="lastKey"></div>
        </div>

        <div class="container" style="background-color:#f1f1f1; white-space: nowrap;">
            <button type="submit" id="fasong" style="width: auto; background-color:rgba(94, 163, 129, 1)">提交景点</button>
            <button type="button" style="width: auto;" onclick="document.getElementById('scenicPage').style.display='none'" class="cancelbtn">Cancel</button>
        </div>
    </form>
</div>


<form action="scenicno.user">
    <input type="hidden" name="state" value="0">
    <button type="submit" >查看未审核景点</button>
</form>
<form action="scenical.user">
    <input type="hidden" name="state" value="1">
    <button type="submit" >查看已审核景点</button>
</form>
</body>
</html>
