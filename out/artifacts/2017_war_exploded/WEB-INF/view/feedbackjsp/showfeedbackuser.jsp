<%--
  Created by IntelliJ IDEA.
  User: 39409
  Date: 2017/9/16
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="function" %>
<html>
<head>
    <title>查看我的反馈信息</title>
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script src="../../static/js/showfeedbackforuser.js"></script>
</head>
<body>
    <div id="show">
        <h1>反馈信息：</h1>
<c:if test="${feedbackData!=null&&function:length(feedbackData)>0}">
    <c:forEach var="feedbackDataList" items="${feedbackData}" varStatus="st" >
        <div class="feedback${st.count}">
        <b>Feedback Title :</b> ${feedbackDataList.feedbacktitle}<br/>
        user name: ${username}<br/>
        feedback time: <fmt:formatDate value="${feedbackDataList.date}"
                                      pattern="yyyy-MM-dd HH:mm:ss"/><br/>
        feedback context: ${feedbackDataList.feedbackcontext}<br/>
        <input type="hidden" name="feedbackid" value="${feedbackDataList.feedbackid}"/>
        <button type="submit" class="delete" id="${st.count}" onclick="Delete(this)">删除</button>
        <img src="../../static/output/${imagesName}" alt="no images"><br/>
        </div>
        <%--<button type="submit" id="${2*st.count}" onclick="praise(this)">点赞</button>--%>
        <%--<button type="submit" id="${2*st.count+1}" style= "display : none" onclick="praise(this)">取消赞</button>--%>

        <%--<button type="submit" id="${st.count}" onclick="complaint">举报</button>--%>
        <%--<button type="submit" id="${st.count}" onclick="collect">收藏</button>--%>
        <%--<br/>--%>
    </c:forEach>
</c:if>
    </div>

</body>
</html>
