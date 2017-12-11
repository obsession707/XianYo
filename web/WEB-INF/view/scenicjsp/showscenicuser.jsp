<%--
  Created by IntelliJ IDEA.
  User: 39409
  Date: 2017/9/18
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="function" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script src="../../static/js/showscenicforuser.js"></script>
    <title>查看我发送的景点信息</title>
</head>
<body>
<div id="show">
    <h1>景点信息：</h1>
    <c:if test="${scenicDatas!=null&&function:length(scenicDatas)>0}">
        <c:forEach var="scenicDataLists" items="${scenicDatas}" varStatus="st" >
            <div class="scenic${st.count}">
                <b>Scenic name :</b> ${scenicDataLists.scenicname}<br/>
                user name: ${username}<br/>
                <b>Scenic description :</b> ${scenicDataLists.scenicsynopsis}<br/>
                <b>Scenic traffic :</b> ${scenicDataLists.scenictraffic}<br/>
                <b>Scenic food :</b> ${scenicDataLists.scenicfood}<br/>
                <b>Scenic iamge: <img src="../../static/output/scenic/${scenicDataLists.scenicpicdir}" ></b><br/>
                submit time: <fmt:formatDate value="${scenicDataLists.date}"
                                             pattern="yyyy-MM-dd HH:mm:ss"/><br/>
                <input type="hidden" name="scenicid" value="${scenicDataLists.scenicid}"/>
                <button type="submit" class="delete" id="${st.count}" onclick="Delete(this)">删除</button>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
