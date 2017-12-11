<%--
  Created by IntelliJ IDEA.
  User: 32936
  Date: 2017/9/8
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>问题评论区</title>
</head>
<body>
    <form action="writeAnswer.comment" method="post">
        <input type="text" name="comment" placeholder="请写下你的评论" size="50">
        <input type="submit" value="发表评论">
    </form>

    <% for(int i=0;i<3;i++) {%>
    <table aria-setsize="50">
        <tr>
            <th>
                <input type="text" readonly="readonly" value="评论者"/>
            </th>
            <th>
                <input type="text" readonly="readonly" value="${person}"/>
            </th>
            <th>
                <input type="text" readonly="readonly" value="被赞次数"/>
            </th>
            <th>
                <input type="text" readonly="readonly" value="${praiseTime}"/>
            </th>
            <th>
                <input type="text" readonly="readonly" value="举报次数"/>
            </th>
            <th>
                <input type="text" readonly="readonly" value="${reportTime}"/>
            </th>
        </tr>
        <tr>
            <td colspan="6">
                <input type = "text" readonly = "readonly"
                       value = "${newCommentMessage}" size = "64"/><br/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <form action="praise.comment" method="post">
                    <input type="submit" value="点赞"/>
                </form>
            </td>
            <td colspan="2">
                <form action="comment.comment" method="post">
                    <input type="submit" value="回复"/>
                </form>
            </td>
            <td colspan="2">
                <form action="report.comment" method="post">
                    <input type="submit" value="举报"/>
                </form>
            </td>
        </tr>
    </table>
    <% } %>
</body>
</html>
