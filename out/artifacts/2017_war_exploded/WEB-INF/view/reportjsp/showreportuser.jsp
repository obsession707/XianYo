<%--
  Created by IntelliJ IDEA.
  User: 39409
  Date: 2017/9/18
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="function" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script src="../../static/js/showreportforuser.js"></script>
    <title>查看我的举报信息</title>
</head>
<body>
<div id="show">
    <h1>举报信息：</h1>
    <c:if test="${reportData!=null&&function:length(reportData)>0}">
        <c:forEach var="reportDataList" items="${reportData}" varStatus="st" >
            <div class="report${st.count}">
                <b>Report Reason :</b> ${reportDataList.reportreason}<br/>
                user name: ${username}<br/>
                report time: <fmt:formatDate value="${reportDataList.date}"
                                               pattern="yyyy-MM-dd HH:mm:ss"/><br/>
                aim id:${reportDataList.aimid}<br/>
                <input type="hidden" name="reportid" value="${reportDataList.reportid}"/>
                <button type="submit" class="delete" id="${st.count}" onclick="Delete(this)">删除</button>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
