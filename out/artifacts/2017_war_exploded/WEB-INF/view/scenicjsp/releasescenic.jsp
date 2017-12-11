<%--
  Created by IntelliJ IDEA.
  User: 39409
  Date: 2017/9/20
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>景 点</title>
    <link rel="stylesheet" href="../../static/css/c09.css"/>
    <link rel="shortcut icon " type="images/x-icon" href="../../static/icon/fish.ico">
    <link rel="stylesheet" href="../../static/css/pepper-grinder/jquery-ui-1.10.3.custom.min.css"/>
</head>
<body>
<header><h1>景 点 相 关</h1></header>
<h2>${scenciName}</h2>
<div class="third img"><img src="../../static/output/scenic/${scenicPicdir}" alt="Circuit boards"/></div>
<div class="two-thirds">
    <div id="prizes">
        <h3>1. 简介</h3>
        <div>
            <p>${scenicSynopsis}</p>
        </div>
        <h3>2. 吃的</h3>
        <div>
            <p>${scenicFood}</p>
        </div>
        <h3>3. 交通</h3>
        <div>
            <p>${scenicTraffic}</p>
        </div>
    </div><!-- #prizes -->
</div><!-- #two-thirds -->
<script src="../../static/js/jquery-1.11.0.min.js"></script>
<script src="../../static/js/jquery-ui.js"></script>
<script>
    $(function () {
        $('#prizes').accordion();
    });
</script>


<!-- 頁面底部 -->

<div id="u1" class="text" style="visibility: visible;">
    <p><span>咸鱼小组制作</span></p>
</div>

<div id="u2" class="text" style="visibility: visible;">
    <p><span>联系客服</span></p>
</div>

<!-- 飞机 -->
<div id="u3">
    <img class="img " src="../../static/image/u229.png"/>
</div>

<!-- Unnamed (垂直线) -->
<div id="u4">
    <img class="img " src="../../static/image/u231.png"/>
</div>

<!-- Unnamed (图片) -->
<div>
    <img id="u235" class="img " src="../../static/image/u235.png"/>
</div>

<!-- Unnamed (图片) -->
<div>
    <img id="u237" class="img " src="../../static/image/u235.png"/>
</div>

<!-- Unnamed (图片) -->
<div>
    <img id="u239" class="img " src="../../static/image/u235.png"/>
</div>

</body>
</html>
