<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="function" %>
<%--
  Created by IntelliJ IDEA.
  User: 39409
  Date: 2017/9/15
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员主页</title>
    <meta charset="utf-8">
    <link href="../../static/css/regist.css" rel="stylesheet" type="text/css">
    <link href="../../static/css/adminpage.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" >
    <script src="../../static/js/jquery-3.2.1.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../../static/js/loginandregister.js"></script>
    <script src="../../static/js/feedbackadmin.js"></script>
</head>
<body>

<div  style="background-color:rgba(94, 163, 129, 1);height: 100px; ">
    <div style="margin-left: 30px;width: 800px;float: left;margin-top: 40px;">
        <ul id="myTab" class="nav nav-tabs" style="width: 1000px;">
            <li class="dropdown">
                <a href="#" data-toggle="dropdown" class="dropdown-toggle"
                   style="color: white;" id="myTabDrop1">
                    <h4><font color="black"><b>查看用户反馈问题</b></font></h4>
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
                    <li><a href="#feedback" tabindex="-1" data-toggle="tab" >
                        <h5><font color="black"><b>所有反馈信息</b></font></h5></a>
                    </li>
                    <li><a href="#feedbackno" tabindex="-1" data-toggle="tab" >
                        <h5><font color="black"><b>未审核反馈信息</b></font></h5></a>
                    </li>
                    <li><a href="#feedbackal" tabindex="-1" data-toggle="tab">
                        <h5><font color="black"><b>已审核反馈信息</b></font></h5></a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" id="myTabDrop2" data-toggle="dropdown"
                   class="dropdown-toggle" style="color: white;">
                    <h4><font color="black"><b>管理举报信息</b></font></h4>
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop2">
                    <li><a href="#report" tabindex="-1" data-toggle="tab" >
                        <h5><font color="black"><b>所有举报信息</b></font></h5></a>
                    </li>
                    <li><a href="#reportno" tabindex="-1" data-toggle="tab" >
                        <h5><font color="black"><b>未审核举报信息</b></font></h5></a>
                    </li>
                    <li><a href="#reportal" tabindex="-1" data-toggle="tab">
                        <h5><font color="black"><b>已审核举报信息</b></font></h5></a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" id="myTabDrop3" class="dropdown-toggle"
                   data-toggle="dropdown" style="color: white;">
                    <h4><font color="black"><b>查看用户提交景点</b></font></h4><b class="caret"></b>
                </a>
                <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop3">
                    <li><a href="#scenic" tabindex="-1" data-toggle="tab">
                        <h5><font color="black"><b>所有用户提交景点信息</b></font></h5></a>
                    </li>
                    <li><a href="#scenicno" tabindex="-1" data-toggle="tab">
                        <h5><font color="black"><b>未审核景点信息</b></font></h5></a>
                    </li>
                    <li><a href="#scenical" tabindex="-1" data-toggle="tab">
                        <h5><font color="black"><b>已审核景点信息</b></font></h5></a>
                    </li>
                </ul>
            </li>
            <li><a href="#user" data-toggle="tab" style="color: white;"><h4><font color="black"><b>管理用户数据</b></font></h4></a></li>

            <li><a href="#travelnote" data-toggle="tab" style="color: white;"><h4><font color="black"><b>管理攻略信息</b></font></h4></a></li>

        </ul>
    </div>
    <div style="float: left;width: 100px;margin-left: 400px;margin-top: 10px;">
        <p style="color: white; font-size: 50px;">管理</p>
    </div>
</div>



<div id="myTabContent" class="tab-content">
    <div class="tab-pane fade in active" id="feedback">

        <table class="table table-striped">
            <caption><h3><b>用户反馈信息表</b></h3></caption>
            <thead>
            <tr>
                <th><h4><b>用户名</b></h4></th>
                <th><h4><b>反馈标题</b></h4></th>
                <th><h4><b>时间</b></h4></th>
                <th><h4><b>详细信息</b></h4></th>
            </tr>
            </thead>
<c:if test="${feedbackData!=null&&function:length(feedbackData)>0}">
    <c:forEach var="feedbackDataList" items="${feedbackData}" varStatus="st" >
            <tbody class="feedback${st.count}">
            <tr>
                <td>${username.get(st.count-1)}</td>
                <td>${feedbackDataList.feedbacktitle}</td>
                <td><fmt:formatDate value="${feedbackDataList.date}"
                                    pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>
                    <button onclick="document.getElementById('feedid'+${st.count}).style.display='block'"
                            style="width:auto;background-color:rgba(94, 163, 129, 1)">详细信息</button>
                    <div id="feedid${st.count}" class="modal" >

                        <form class="modal-content animate" action="reply.feedback" method="post">
                            <div class="imgcontainer">
                                <span onclick="document.getElementById('feedid'+${st.count}).style.display='none'" class="close" title="Close Modal">&times;</span>
                                <img src="../../../static/image/fishme.png" alt="Avatar" class="avatar">
                            </div>

                            <div class="container" id="feedbackinfo" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                <h4 style="text-align: center"><b>${feedbackDataList.feedbacktitle}</b></h4>
                                <br/>
                                <label><p>${feedbackDataList.feedbackcontext}</p></label>
                            </div>
                            <div class="container" id="feedreply1" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                <input type="hidden" name="feedbackid" value="${feedbackDataList.feedbackid}">
                                <label><b>Reply</b></label>
                                <input type="text" placeholder="Enter Reply" name="reply"
                                       id="replyfeed1"  required/>
                            </div>


                            <div class="container" id="feedbackbutton1" style="width: 400px; background-color:#f1f1f1; white-space: nowrap" >
                                <button type="button"style="width: 50%" onclick="document.getElementById('feedid'+${st.count}).style.display='none'" class="cancelbtn">Cancel</button>
                                <button type="submit" style="width:50%; background-color:rgba(94, 163, 129, 1)" id="feedbacksubmit1">回复</button>
                            </div>
                        </form>
                    </div>
                </td>
            </tr>
            </tbody>
    </c:forEach>
</c:if>
        </table>

    </div>
    <div class="tab-pane fade" id="feedbackno">

        <table class="table table-striped">
            <caption><h3><b>未审核用户反馈信息表</b></h3></caption>
            <thead>
            <tr>
                <th><h4><b>用户名</b></h4></th>
                <th><h4><b>反馈标题</b></h4></th>
                <th><h4><b>时间</b></h4></th>
                <th><h4><b>详细信息</b></h4></th>
            </tr>
            </thead>
            <c:if test="${feedbackData1!=null&&function:length(feedbackData1)>0}">
                <c:forEach var="feedbackDataNoList" items="${feedbackData1}" varStatus="st" >
                    <tbody class="feedback${st.count}">
                    <tr>
                        <td>${username1.get(st.count-1)}</td>
                        <td>${feedbackDataNoList.feedbacktitle}</td>
                        <td><fmt:formatDate value="${feedbackDataNoList.date}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <button onclick="document.getElementById('feedidno'+${st.count}).style.display='block'"
                                    style="width:auto;background-color:rgba(94, 163, 129, 1)">详细信息</button>
                            <div id="feedidno${st.count}" class="modal" >

                                <form class="modal-content animate" action="reply.feedback" method="post">
                                    <div class="imgcontainer">
                                        <span onclick="document.getElementById('feedidno'+${st.count}).style.display='none'" class="close" title="Close Modal">&times;</span>
                                        <img src="../../../static/image/fishme.png" alt="Avatar" class="avatar">
                                    </div>

                                    <div class="container" id="feedbacknoinfo" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <h4 style="text-align: center"><b>${feedbackDataNoList.feedbacktitle}</b></h4>
                                        <br/>
                                        <label><p>${feedbackDataNoList.feedbackcontext}</p></label>
                                    </div>
                                    <div class="container" id="feedreply2" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <input type="hidden" name="feedbackid" value="${feedbackDataNoList.feedbackid}">
                                        <label><b>Reply</b></label>
                                        <input type="text" placeholder="Enter Reply" name="reply"
                                               id="replyfeed2"  required/>
                                    </div>


                                    <div class="container" id="feedbackbutton2" style="width: 400px; background-color:#f1f1f1; white-space: nowrap" >
                                        <button type="button"style="width: 50%" onclick="document.getElementById('feedidno'+${st.count}).style.display='none'" class="cancelbtn">Cancel</button>
                                        <button type="submit" style="width:50%; background-color:rgba(94, 163, 129, 1)" id="feedbacksubmit2">回复</button>
                                    </div>
                                </form>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </c:if>
        </table>

    </div>
    <div class="tab-pane fade" id="feedbackal">

        <table class="table table-striped">
            <caption><h3><b>已审核用户反馈信息表</b></h3></caption>
            <thead>
            <tr>
                <th><h4><b>用户名</b></h4></th>
                <th><h4><b>反馈标题</b></h4></th>
                <th><h4><b>时间</b></h4></th>
                <th><h4><b>详细信息</b></h4></th>
            </tr>
            </thead>
            <c:if test="${feedbackData2!=null&&function:length(feedbackData2)>0}">
                <c:forEach var="feedbackDataAlList" items="${feedbackData2}" varStatus="st" >
                    <tbody class="feedback${st.count}">
                    <tr>
                        <td>${username2.get(st.count-1)}</td>
                        <td>${feedbackDataAlList.feedbacktitle}</td>
                        <td><fmt:formatDate value="${feedbackDataAlList.date}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <button onclick="document.getElementById('feedidal'+${st.count}).style.display='block'"
                                    style="width:auto;background-color:rgba(94, 163, 129, 1)">详细信息</button>
                            <div id="feedidal${st.count}" class="modal" >

                                <form class="modal-content animate" method="post">
                                    <div class="imgcontainer">
                                        <span onclick="document.getElementById('feedidal'+${st.count}).style.display='none'" class="close" title="Close Modal">&times;</span>
                                        <img src="../../../static/image/fishme.png" alt="Avatar" class="avatar">
                                    </div>

                                    <div class="container" id="feedbackalinfo" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <h4 style="text-align: center"><b>${feedbackDataAlList.feedbacktitle}</b></h4>
                                        <br/>
                                        <label><p>${feedbackDataAlList.feedbackcontext}</p></label>
                                    </div>
                                    <div class="container" id="feedreply3" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <label><b>${feedbackDataAlList.reply}</b></label>
                                    </div>


                                    <div class="container" id="feedbackbutton3" style="text-align:center; width: 400px; background-color:#f1f1f1; white-space: nowrap">
                                        <button type="button" style="margin:auto;" onclick="document.getElementById('feedidal'+${st.count}).style.display='none'" class="cancelbtn">Cancel</button>
                                    </div>
                                </form>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </c:if>
        </table>

    </div>

    <div class="tab-pane fade" id="report">

        <table class="table table-striped">
            <caption><h3><b>用户举报信息表</b></h3></caption>
            <thead>
            <tr>
                <th><h4><b>用户名</b></h4></th>
                <th><h4><b>举报信息</b></h4></th>
                <th><h4><b>时间</b></h4></th>
                <th><h4><b>详细信息</b></h4></th>
            </tr>
            </thead>
            <c:if test="${reportData!=null&&function:length(reportData)>0}">
                <c:forEach var="reportDataList" items="${reportData}" varStatus="st" >
                    <tbody class="report${st.count}">
                    <tr>
                        <td>${username3.get(st.count-1)}</td>
                        <td>${reportDataList.reportreason}</td>
                        <td><fmt:formatDate value="${reportDataList.date}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <button onclick="document.getElementById('reporid'+${st.count}).style.display='block'"
                                    style="width:auto;background-color:rgba(94, 163, 129, 1)">详细信息</button>
                            <div id="reporid${st.count}" class="modal" >

                                <form class="modal-content animate" action="reply.report" method="post">
                                    <div class="imgcontainer">
                                        <span onclick="document.getElementById('reporid'+${st.count}).style.display='none'" class="close" title="Close Modal">&times;</span>
                                        <img src="../../../static/image/fishme.png" alt="Avatar" class="avatar">
                                    </div>

                                    <div class="container" id="reportinfo" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <h4 style="text-align: center"><b>aimid: ${reportDataList.aimid}</b></h4><br/>
                                        <h4 style="text-align: center"><b><fmt:formatDate value="${reportDataList.date}"
                                                                                          pattern="yyyy-MM-dd HH:mm:ss"/></b></h4><br/>
                                        <label><p>reason: ${reportDataList.reportreason}</p></label>
                                    </div>
                                    <div class="container" id="reportreply1" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <input type="hidden" name="reportid" value="${reportDataList.reportid}">
                                        <label><b>Reply</b></label>
                                        <input type="text" placeholder="Enter Reply" name="reply"
                                               id="replyreport1"  required/>
                                    </div>


                                    <div class="container" id="reportbutton1" style="width: 400px; background-color:#f1f1f1; white-space: nowrap" >
                                        <button type="button"style="width: 50%" onclick="document.getElementById('reporid'+${st.count}).style.display='none'" class="cancelbtn">Cancel</button>
                                        <button type="submit" style="width:50%; background-color:rgba(94, 163, 129, 1)" id="reportsubmit1">回复</button>
                                    </div>
                                </form>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </c:if>
        </table>

    </div>
    <div class="tab-pane fade" id="reportno">

        <table class="table table-striped">
            <caption><h3><b>未审核用户举报信息表</b></h3></caption>
            <thead>
            <tr>
                <th><h4><b>用户名</b></h4></th>
                <th><h4><b>举报信息</b></h4></th>
                <th><h4><b>时间</b></h4></th>
                <th><h4><b>详细信息</b></h4></th>
            </tr>
            </thead>
            <c:if test="${reportData1!=null&&function:length(reportData1)>0}">
                <c:forEach var="reportDataNoList" items="${reportData1}" varStatus="st" >
                    <tbody class="report${st.count}">
                    <tr>
                        <td>${username4.get(st.count-1)}</td>
                        <td>${reportDataNoList.reportreason}</td>
                        <td><fmt:formatDate value="${reportDataNoList.date}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <button onclick="document.getElementById('reporidno'+${st.count}).style.display='block'"
                                    style="width:auto;background-color:rgba(94, 163, 129, 1)">详细信息</button>
                            <div id="reporidno${st.count}" class="modal" >

                                <form class="modal-content animate" action="reply.report" method="post">
                                    <div class="imgcontainer">
                                        <span onclick="document.getElementById('reporidno'+${st.count}).style.display='none'" class="close" title="Close Modal">&times;</span>
                                        <img src="../../../static/image/fishme.png" alt="Avatar" class="avatar">
                                    </div>

                                    <div class="container" id="reportinfono" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <h4 style="text-align: center"><b>aimid: ${reportDataNoList.aimid}</b></h4><br/>
                                        <h4 style="text-align: center"><b><fmt:formatDate value="${reportDataNoList.date}"
                                                                                          pattern="yyyy-MM-dd HH:mm:ss"/></b></h4><br/>
                                        <label><p>reason: ${reportDataNoList.reportreason}</p></label>
                                    </div>
                                    <div class="container" id="reportreply2" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <input type="hidden" name="reportid" value="${reportDataNoList.reportid}">
                                        <label><b>Reply</b></label>
                                        <input type="text" placeholder="Enter Reply" name="reply"
                                               id="replyreport2"  required/>
                                    </div>


                                    <div class="container" id="reportbutton2" style="width: 400px; background-color:#f1f1f1; white-space: nowrap" >
                                        <button type="button"style="width: 50%" onclick="document.getElementById('reporidno'+${st.count}).style.display='none'" class="cancelbtn">Cancel</button>
                                        <button type="submit" style="width:50%; background-color:rgba(94, 163, 129, 1)" id="reportsubmit2">回复</button>
                                    </div>
                                </form>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </c:if>
        </table>

    </div>
    <div class="tab-pane fade" id="reportal">

        <table class="table table-striped">
            <caption><h3><b>未审核用户举报信息表</b></h3></caption>
            <thead>
            <tr>
                <th><h4><b>用户名</b></h4></th>
                <th><h4><b>举报信息</b></h4></th>
                <th><h4><b>时间</b></h4></th>
                <th><h4><b>详细信息</b></h4></th>
            </tr>
            </thead>
            <c:if test="${reportData2!=null&&function:length(reportData2)>0}">
                <c:forEach var="reportDataAlList" items="${reportData2}" varStatus="st" >
                    <tbody class="report${st.count}">
                    <tr>
                        <td>${username5.get(st.count-1)}</td>
                        <td>${reportDataAlList.reportreason}</td>
                        <td><fmt:formatDate value="${reportDataAlList.date}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <button onclick="document.getElementById('reporidal'+${st.count}).style.display='block'"
                                    style="width:auto;background-color:rgba(94, 163, 129, 1)">详细信息</button>
                            <div id="reporidal${st.count}" class="modal" >

                                <form class="modal-content animate" method="post">
                                    <div class="imgcontainer">
                                        <span onclick="document.getElementById('reporidal'+${st.count}).style.display='none'" class="close" title="Close Modal">&times;</span>
                                        <img src="../../../static/image/fishme.png" alt="Avatar" class="avatar">
                                    </div>

                                    <div class="container" id="reportinfoal" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <h4 style="text-align: center"><b>aimid: ${reportDataAlList.aimid}</b></h4><br/>
                                        <h4 style="text-align: center"><b><fmt:formatDate value="${reportDataAlList.date}"
                                                                                          pattern="yyyy-MM-dd HH:mm:ss"/></b></h4><br/>
                                        <label><p>reason: ${reportDataAlList.reportreason}</p></label>
                                    </div>
                                    <div class="container" id="reportreply3" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <label><b>reply: ${reportDataAlList.reply}</b></label>
                                    </div>


                                    <div class="container" id="reportbutton3" style="text-align: center;width: 400px; background-color:#f1f1f1; white-space: nowrap" >
                                        <button type="button" style="margin:auto" onclick="document.getElementById('reporidal'+${st.count}).style.display='none'" class="cancelbtn">Cancel</button>
                                    </div>
                                </form>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </c:if>
        </table>

    </div>

    <div class="tab-pane fade" id="scenic">

        <table class="table table-striped">
            <caption><h3><b>景点信息表</b></h3></caption>
            <thead>
            <tr>
                <th><h4><b>景点名</b></h4></th>
                <th><h4><b>景点描述</b></h4></th>
                <th><h4><b>提交时间</b></h4></th>
                <th><h4><b>详细信息</b></h4></th>
            </tr>
            </thead>
            <c:if test="${scenicDatas!=null&&function:length(scenicDatas)>0}">
                <c:forEach var="scenicDataLists" items="${scenicDatas}" varStatus="st" >
                    <tbody class="scenic${st.count}">
                    <tr>
                        <td>${scenicDataLists.scenicname}</td>
                        <td>${scenicDataLists.scenicsynopsis}</td>
                        <td><fmt:formatDate value="${scenicDataLists.date}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <button onclick="document.getElementById('scenid'+${st.count}).style.display='block'"
                                    style="width:auto;background-color:rgba(94, 163, 129, 1)">详细信息</button>
                            <div id="scenid${st.count}" class="modal" style="overflow: scroll">

                                <form class="modal-content animate" action="reply.scenic" method="post">
                                    <div class="imgcontainer">
                                        <span onclick="document.getElementById('scenid'+${st.count}).style.display='none'" class="close" title="Close Modal">&times;</span>
                                        <img src="../../static/output/scenic/${scenicDataLists.scenicpicdir}" alt="Avatar" class="avatar">
                                    </div>

                                    <div class="container" id="scenicinfo" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <h4 style="text-align: center"><b>scenicname: ${scenicDataLists.scenicname}</b></h4><br/>
                                        <h4 style="text-align: center"><b>username: ${username6.get(st.count-1)}</b></h4><br/>
                                        <h4 style="text-align: center"><b><fmt:formatDate value="${scenicDataLists.date}"
                                                                                          pattern="yyyy-MM-dd HH:mm:ss"/></b></h4><br/>
                                        <label><p>description: ${scenicDataLists.scenicsynopsis}</p></label>
                                        <label><p>traffic: ${scenicDataLists.scenictraffic}</p></label>
                                        <label><p>food: ${scenicDataLists.scenicfood}</p></label>
                                    </div>
                                    <div class="container" id="scenicreply1" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <input type="hidden" name="scenicid" value="${scenicDataLists.scenicid}">
                                        <label><b>Reply</b></label>
                                        <input type="text" placeholder="Enter Reply" name="reply"
                                               id="replyscenic1"  required/>
                                    </div>


                                    <div class="container" id="scenicbutton1" style="width: 400px; background-color:#f1f1f1; white-space: nowrap" >
                                        <button type="button"style="width: 50%" onclick="document.getElementById('scenid'+${st.count}).style.display='none'" class="cancelbtn">Cancel</button>
                                        <button type="submit" style="width:50%; background-color:rgba(94, 163, 129, 1)" id="scenicsubmit1">回复</button>
                                    </div>
                                </form>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </c:if>
        </table>

    </div>
    <div class="tab-pane fade" id="scenicno">

        <table class="table table-striped">
            <caption><h3><b>未审核景点信息表</b></h3></caption>
            <thead>
            <tr>
                <th><h4><b>景点名</b></h4></th>
                <th><h4><b>景点描述</b></h4></th>
                <th><h4><b>提交时间</b></h4></th>
                <th><h4><b>详细信息</b></h4></th>
            </tr>
            </thead>
            <c:if test="${scenicDatas1!=null&&function:length(scenicDatas1)>0}">
                <c:forEach var="scenicDataLists1" items="${scenicDatas1}" varStatus="st" >
                    <tbody class="scenic${st.count}">
                    <tr>
                        <td>${scenicDataLists1.scenicname}</td>
                        <td>${scenicDataLists1.scenicsynopsis}</td>
                        <td><fmt:formatDate value="${scenicDataLists1.date}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <button onclick="document.getElementById('scenidno'+${st.count}).style.display='block'"
                                    style="width:auto;background-color:rgba(94, 163, 129, 1)">详细信息</button>
                            <div id="scenidno${st.count}" class="modal" style="overflow: scroll;">

                                <form class="modal-content animate" action="reply.scenic" method="post">
                                    <div class="imgcontainer">
                                        <span onclick="document.getElementById('scenidno'+${st.count}).style.display='none'" class="close" title="Close Modal">&times;</span>
                                        <img src="../../static/output/scenic/${scenicDataLists1.scenicpicdir}" alt="Avatar" class="avatar">
                                    </div>

                                    <div class="container" id="scenicinfono" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <h4 style="text-align: center"><b>scenicname: ${scenicDataLists1.scenicname}</b></h4><br/>
                                        <h4 style="text-align: center"><b>username: ${username7.get(st.count-1)}</b></h4><br/>
                                        <h4 style="text-align: center"><b><fmt:formatDate value="${scenicDataLists1.date}"
                                                                                          pattern="yyyy-MM-dd HH:mm:ss"/></b></h4><br/>
                                        <label><p>description: ${scenicDataLists1.scenicsynopsis}</p></label>
                                        <label><p>traffic: ${scenicDataLists1.scenictraffic}</p></label>
                                        <label><p>food: ${scenicDataLists1.scenicfood}</p></label>
                                    </div>
                                    <div class="container" id="scenicreply2" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <input type="hidden" name="scenicid" value="${scenicDataLists1.scenicid}">
                                        <label><b>Reply</b></label>
                                        <input type="text" placeholder="Enter Reply" name="reply"
                                               id="replyscenic2"  required/>
                                    </div>


                                    <div class="container" id="scenicbutton2" style="width: 400px; background-color:#f1f1f1; white-space: nowrap" >
                                        <button type="button"style="width: 50%" onclick="document.getElementById('scenidno'+${st.count}).style.display='none'" class="cancelbtn">Cancel</button>
                                        <button type="submit" style="width:50%; background-color:rgba(94, 163, 129, 1)" id="scenicsubmit2">回复</button>
                                    </div>
                                </form>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </c:if>
        </table>

    </div>
    <div class="tab-pane fade" id="scenical">

        <table class="table table-striped">
            <caption><h3><b>已审核景点信息表</b></h3></caption>
            <thead>
            <tr>
                <th><h4><b>景点名</b></h4></th>
                <th><h4><b>景点描述</b></h4></th>
                <th><h4><b>提交时间</b></h4></th>
                <th><h4><b>详细信息</b></h4></th>
                <th><h4><b>景点发布</b></h4></th>
            </tr>
            </thead>
            <c:if test="${scenicDatas2!=null&&function:length(scenicDatas2)>0}">
                <c:forEach var="scenicDataLists2" items="${scenicDatas2}" varStatus="st" >
                    <tbody class="scenic${st.count}">
                    <tr>
                        <td>${scenicDataLists2.scenicname}</td>
                        <td>${scenicDataLists2.scenicsynopsis}</td>
                        <td><fmt:formatDate value="${scenicDataLists2.date}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <button onclick="document.getElementById('scenidal'+${st.count}).style.display='block'"
                                    style="width:auto;background-color:rgba(94, 163, 129, 1)">详细信息</button>
                            <div id="scenidal${st.count}" class="modal" style="overflow: scroll;">

                                <form class="modal-content animate" action="reply.scenic" method="post">
                                    <div class="imgcontainer">
                                        <span onclick="document.getElementById('scenidal'+${st.count}).style.display='none'" class="close" title="Close Modal">&times;</span>
                                        <img src="../../static/output/scenic/${scenicDataLists2.scenicpicdir}" alt="Avatar" class="avatar">
                                    </div>

                                    <div class="container" id="scenicinfoal" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <h4 style="text-align: center"><b>scenicname: ${scenicDataLists2.scenicname}</b></h4><br/>
                                        <h4 style="text-align: center"><b>username: ${username8.get(st.count-1)}</b></h4><br/>
                                        <h4 style="text-align: center"><b><fmt:formatDate value="${scenicDataLists2.date}"
                                                                                          pattern="yyyy-MM-dd HH:mm:ss"/></b></h4><br/>
                                        <label><p>description: ${scenicDataLists2.scenicsynopsis}</p></label>
                                        <label><p>traffic: ${scenicDataLists2.scenictraffic}</p></label>
                                        <label><p>food: ${scenicDataLists2.scenicfood}</p></label>
                                    </div>
                                    <div class="container" id="scenicreply3" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <label><b>reply: ${scenicDataLists2.reply}</b></label>
                                    </div>


                                    <div class="container" id="scenicbutton3" style="text-align: center;width: 400px; background-color:#f1f1f1; white-space: nowrap" >
                                        <button type="button" style="margin:auto" onclick="document.getElementById('scenidal'+${st.count}).style.display='none'" class="cancelbtn">Cancel</button>
                                    </div>
                                </form>
                            </div>
                        </td>
                        <td>
                            <form action="release.scenic">
                                <button style="width:auto;background-color:rgba(94, 163, 129, 1)">发布景点</button>
                                <input type="hidden" name="Scenicid" value="${scenicDataLists2.scenicid}">
                            </form>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </c:if>
        </table>

    </div>


    <div class="tab-pane fade" id="user">

        <table class="table table-striped">
            <caption><h3><b>用户信息表</b></h3></caption>
            <thead>
            <tr>
                <th><h4><b>用户名</b></h4></th>
                <th><h4><b>手机号码</b></h4></th>
                <th><h4><b>邮箱</b></h4></th>
                <th><h4><b>详细信息</b></h4></th>
            </tr>
            </thead>
            <c:if test="${userData!=null&&function:length(userData)>0}">
                <c:forEach var="userDataList" items="${userData}" varStatus="st" >
                    <tbody class="user${st.count}">
                    <tr>
                        <td>${userDataList.username}</td>
                        <td>${userDataList.phonenumber}</td>
                        <td>${userDataList.email}</td>
                        <td>
                            <button onclick="document.getElementById('iduser'+${st.count}).style.display='block'"
                                    style="width:auto;background-color:rgba(94, 163, 129, 1)">详细信息</button>
                            <div id="iduser${st.count}" class="modal" >
                                <form class="modal-content animate" method="post">
                                    <div class="imgcontainer">
                                        <span onclick="document.getElementById('iduser'+${st.count}).style.display='none'" class="close" title="Close Modal">&times;</span>
                                        <img src="../../../static/image/fishme.png" alt="Avatar" class="avatar">
                                    </div>

                                    <div class="container" id="userinfo" style="width: 400px;padding-top: 0px;padding-bottom: 0px;">
                                        <h4 style="text-align: center"><b>aimid: ${userDataList.username}</b></h4><br/>
                                        <label><p>userID: ${userDataList.userid}</p></label><br/>
                                        <label><p>phonenumber: ${userDataList.phonenumber}</p></label>
                                        <label><p>email: ${userDataList.email}</p></label>
                                    </div>

                                    <div class="container" id="button6" style="text-align: center;width: 400px; background-color:#f1f1f1; white-space: nowrap" >
                                        <button type="button" style="margin:auto" onclick="document.getElementById('iduser'+${st.count}).style.display='none'" class="cancelbtn">Cancel</button>
                                    </div>
                                </form>
                            </div>
                        </td>

                    </tr>
                    </tbody>
                </c:forEach>
            </c:if>
        </table>

    </div>
    <div class="tab-pane fade" id="travelnote">

    </div>



</div>
<script>
    $(function () {
        $('#myTab li:eq(1) a').tab('show');
    });
</script>
</body>
</html>
