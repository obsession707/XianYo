package com.xianyo.adminmodule.controller;

import com.xianyo.feedbackmodule.dao.pojo.UserFeedbackData;
import com.xianyo.feedbackmodule.service.FeedbackService;
import com.xianyo.loginmodule.dao.pojo.UserData;
import com.xianyo.util.reportmodule.dao.pojo.UserReportData;
import com.xianyo.util.reportmodule.service.ReportService;
import com.xianyo.util.scenicmodule.dao.pojo.ScenicData;
import com.xianyo.util.scenicmodule.service.ScenicService;
import com.xianyo.util.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    ReportService reportService;
    @Autowired
    FeedbackService feedbackService;
    @Autowired
    UserDataService userDataService;
    @Autowired
    ScenicService scenicService;

    @RequestMapping("mainPage.admin")
    public ModelAndView JumpToMainPage(HttpServletRequest request) {
        return ShowMav(request);
    }

    @RequestMapping("regist.admin")
    public ModelAndView JumpToRegist(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("administorjsp/registAdmin");
        return mav;
    }
    @RequestMapping("passwordfind0.admin")
    public ModelAndView JumpToFindPsw(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("administorjsp/findPassword0");
        return mav;
    }
    @RequestMapping("reply.feedback")
    public ModelAndView ReplyFeedback(HttpServletRequest request) {
        Long feedbackID = Long.parseLong(request.getParameter("feedbackid"));
        UserFeedbackData data = feedbackService.FindFeedback(feedbackID);
        data.setReply(request.getParameter("reply"));
        data.setState(1);
        feedbackService.ChangeFeedback(data);
        System.out.println("回复反馈之后的data:" + data);
        return ShowMav(request);
    }
    @RequestMapping("reply.report")
    public ModelAndView ReplyReport(HttpServletRequest request) {
        Long reportID = Long.parseLong(request.getParameter("reportid"));
        UserReportData data = reportService.FindReport(reportID);
        data.setReply(request.getParameter("reply"));
        data.setState(1);
        reportService.ChangeReport(data);
        System.out.println("回复举报之后的data:" + data);
        return ShowMav(request);
    }
    @RequestMapping("reply.scenic")
    public ModelAndView ReplyScenic(HttpServletRequest request) {
        Long scenicID = Long.parseLong(request.getParameter("scenicid"));
        ScenicData data = scenicService.FindScenic(scenicID);
        data.setReply(request.getParameter("reply"));
        data.setState(1);
        scenicService.ChangeScenic(data);
        System.out.println("通过审核之后的data:" + data);
        return ShowMav(request);
    }



    private ModelAndView ShowMav(HttpServletRequest request) {
        //feedback
        List<UserFeedbackData> feedbackDataList = feedbackService.QueryFeedbackAll();

        List<String> userNames = new ArrayList<>();
        for (int i = 0; i < feedbackDataList.size(); i++) {
            userNames.add(userDataService.FindWithID(feedbackDataList.get(i).getUserid()).getUsername());
        }
        ModelAndView mav = new ModelAndView("administorjsp/main");
        request.setAttribute("username", userNames);
        request.setAttribute("feedbackData", feedbackDataList);
        //feedbackno
        List<UserFeedbackData> feedbackDataList1 = feedbackService.QueryFeedbackAll(0);
        List<String> userNames1 = new ArrayList<>();
        for (int i = 0; i < feedbackDataList1.size(); i++) {
            userNames1.add(userDataService.FindWithID(feedbackDataList1.get(i).getUserid()).getUsername());
        }
        request.setAttribute("username1", userNames1);
        request.setAttribute("feedbackData1", feedbackDataList1);
        //feedbackal
        List<UserFeedbackData> feedbackDataList2 = feedbackService.QueryFeedbackAll(1);
        List<String> userNames2 = new ArrayList<>();
        for (int i = 0; i < feedbackDataList2.size(); i++) {
            userNames2.add(userDataService.FindWithID(feedbackDataList2.get(i).getUserid()).getUsername());
        }
        request.setAttribute("username2", userNames2);
        request.setAttribute("feedbackData2", feedbackDataList2);
        //==========================================//
        //report
        List<UserReportData> reportDataList = reportService.QueryReportAll();
        List<String> userNames3 = new ArrayList<>();
        for (int i = 0; i < reportDataList.size(); i++) {
            userNames3.add(userDataService.FindWithID(reportDataList.get(i).getUserid()).getUsername());
        }
        request.setAttribute("username3", userNames3);
        request.setAttribute("reportData", reportDataList);
        //reportno
        List<UserReportData> reportDataList1 = reportService.QueryReportAll(0);
        List<String> userNames4 = new ArrayList<>();
        for (int i = 0; i < reportDataList1.size(); i++) {
            userNames4.add(userDataService.FindWithID(reportDataList1.get(i).getUserid()).getUsername());
        }
        request.setAttribute("username4", userNames4);
        request.setAttribute("reportData1", reportDataList1);
        //reportal
        List<UserReportData> reportDataList2 = reportService.QueryReportAll(1);
        List<String> userNames5 = new ArrayList<>();
        for (int i = 0; i < reportDataList2.size(); i++) {
            userNames5.add(userDataService.FindWithID(reportDataList2.get(i).getUserid()).getUsername());
        }
        request.setAttribute("username5", userNames5);
        request.setAttribute("reportData2", reportDataList2);
        //=================================================//
        //user
        List<UserData> userDataList = userDataService.QueryUserAll();
        request.setAttribute("userData",userDataList);
        //================================================//
        //scenic
        List<ScenicData> scenicDataList = scenicService.QueryScenicAll();
        List<String> userNames6 = new ArrayList<>();
        for (int i = 0; i < scenicDataList.size(); i++) {
            userNames6.add(userDataService.FindWithID(scenicDataList.get(i).getUserid()).getUsername());
        }
        request.setAttribute("username6", userNames6);
        request.setAttribute("scenicDatas", scenicDataList);
        //scenicno
        List<ScenicData> scenicDataList1 = scenicService.QueryScenicAll(0);
        List<String> userNames7 = new ArrayList<>();
        for (int i = 0; i < scenicDataList1.size(); i++) {
            userNames7.add(userDataService.FindWithID(scenicDataList1.get(i).getUserid()).getUsername());
        }
        request.setAttribute("username7", userNames7);
        request.setAttribute("scenicDatas1", scenicDataList1);
        //scenical
        List<ScenicData> scenicDataList2 = scenicService.QueryScenicAll(1);
        List<String> userNames8 = new ArrayList<>();
        for (int i = 0; i < scenicDataList2.size(); i++) {
            userNames8.add(userDataService.FindWithID(scenicDataList2.get(i).getUserid()).getUsername());
        }
        request.setAttribute("username8", userNames8);
        request.setAttribute("scenicDatas2", scenicDataList2);
        //================================================//
        return mav;



    }
}



//    @RequestMapping("feedbackno.query")
//    public @ResponseBody String ShowFeedbackNo(HttpServletRequest request){
//        //feedback
//        List<UserFeedbackData> feedbackDataList = feedbackService.QueryFeedbackAll(0);
//        List<String> userNames = new ArrayList<>();
//        for (int i = 0; i < feedbackDataList.size(); i++) {
//            userNames.add(userDataService.FindWithID(feedbackDataList.get(i).getUserid()).getUsername());
//        }
//        request.setAttribute("username", userNames);
//        request.setAttribute("feedbackData", feedbackDataList);
//        return "success";
//    }

//    @RequestMapping("feedbackal.query")
//    public @ResponseBody
//    JSONArray ShowFeedbackAl(HttpServletRequest request){
//        List<UserFeedbackData> feedbackDataList = feedbackService.QueryFeedbackAll(1);
//        //List<String> userNames = new ArrayList<>();
//        for (int i = 0; i < feedbackDataList.size(); i++) {
//            feedbackDataList.get(i).setUsername(userDataService.FindWithID(feedbackDataList.get(i).getUserid()).getUsername());
//        }
//   //     request.setAttribute("username", userNames);
//    //    request.setAttribute("feedbackData", feedbackDataList);
////        HashMap map = new HashMap();
////        map.put("username", userNames);
////        map.put("feedbackData", feedbackDataList);
////        return map;
//        JSONArray jsonArray = JSONArray.fromObject(feedbackDataList);
//        return  jsonArray;
//    }
//}
