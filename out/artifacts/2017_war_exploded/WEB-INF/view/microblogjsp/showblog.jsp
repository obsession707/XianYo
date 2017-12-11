<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="function" %>
<%--
  Created by IntelliJ IDEA.
  User: 39409
  Date: 2017/9/8
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>微博主页</title>
    <link rel="shortcut icon " type="images/x-icon" href="../../static/icon/fish.ico">
    <link rel="stylesheet" href="../../static/css/sendblog.css"/>
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script src="../../static/js/keypress.js"></script>
    <script src="../../static/js/showblog.js"></script>
    <script src="../../static/js/inputblog.js"></script>
    <script src="../../static/js/buttonclick.js"></script>
</head>
<body>

<button onclick="document.getElementById('blogPage').style.display='block'"
        style="width:auto;background-color:rgba(94, 163, 129, 1)">发个微博</button>

<div id="blogPage" class="modal">
    <form class="modal-content animate" id="messageForm" method="post" action="upload.blog" enctype="multipart/form-data">

        <div class="imgcontainer">
            <span onclick="document.getElementById('blogPage').style.display='none'" class="close" title="Close Modal">&times;</span>
            <img src="../../static/image/write.png" alt="Avatar" class="avatar">
        </div>

        <div class="contextContainer">
            <label><b>发个微博吧：）</b></label><br/>
            <label><b>share your emotions</b></label><br/><br/>
            <textarea id="message" name="message"></textarea>
            <div id="charactersLeft">180 characters</div>
            <div id="lastKey"></div>
        </div>

        <div class="container" style="background-color:#f1f1f1; white-space: nowrap;">
            <button type="submit" id="fasong" style="width: auto; background-color:rgba(94, 163, 129, 1)">确认发送</button>
            <button type="button" style="width: auto;" onclick="document.getElementById('blogPage').style.display='none'" class="cancelbtn">Cancel</button>
        </div>
    </form>
</div>


    <div id="show">
    <h2>微博信息：</h2>
<c:if test="${microblogData!=null&&function:length(microblogData)>0}">
    <c:forEach var="microblogDataList" items="${microblogData}" varStatus="st" >
        <div id="showblog" style="margin:0 auto">
        <b>Microblog Context :</b> ${microblogDataList.context}<br/>
        author name: ${authorName}<br/>
        publish time: <fmt:formatDate value="${microblogDataList.publishtime}"
                                      pattern="yyyy-MM-dd HH:mm:ss"/><br/>
        read time: ${microblogDataList.readtime}<br/>
        <div name="praiseTime">praise time:${microblogDataList.praisetime}</div><br/>
        <div name="collectTime">collect time:${microblogDataList.collecttime}</div><br/>
        <div name="complaintTime">complaint time:${microblogDataList.complainttime}</div><br/>
        <input type="hidden" name="microblogid" value="${microblogDataList.microblogid}"/>
        <img src="../../static/output/${imagesName}" alt="no images">
        <div class="container" id="button" style="width: 400px; background-color:#f1f1f1; white-space: nowrap" >
            <button style="width: 33%" type="submit" id="${2*st.count}" onclick="praise(this)">点赞</button>
            <button style="width: 33%;display: none" type="submit" id="${2*st.count+1}" style= "display : none" onclick="praise(this)">取消赞</button>
            <button style="width: 33%" type="submit" id="${st.count}" onclick="complaint">举报</button>
            <button style="width: 33%" type="submit" id="${st.count}" onclick="collect">收藏</button>
        </div>
        </div>
    </c:forEach>
</c:if>
    </div>
</body>
</html>


<%--<div class="imagesContainer"onload="loadImageFile(this)">--%>
<%--<input id="uploadImages" multiple type="file" name="myPhoto"--%>
<%--accept="image/*" onchange="loadImageFile(event)"/>--%>
<%--</div>--%>