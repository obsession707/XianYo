package com.xianyo.util.reportmodule.controller;

import com.xianyo.loginmodule.dao.pojo.UserData;
import com.xianyo.util.reportmodule.dao.pojo.UserReportData;
import com.xianyo.util.reportmodule.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ReportController {
    public String message;
    @Autowired
    ReportService reportService;
    @RequestMapping("toReport")
    public ModelAndView JumpToReport(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/reportjsp/submitreport");
        return  mav;
    }
    @RequestMapping("report.user")
    public ModelAndView Submit(UserReportData reportData, HttpServletRequest request, HttpSession session){
        ModelAndView mav = new ModelAndView();
        //判断用户是否登陆
        if (session.getAttribute("User") == null)
            mav.setViewName("loginjsp/login/userlogin");
        else{
            UserData tempData = (UserData)  session.getAttribute("User");
            reportData.setUserid(tempData.getUserid());
            reportService.SubmitReport(reportData);
            message = "提交成功";
            mav.addObject("message",message);
            mav = ShowMav(request,session);//显示所有的
        }
        return mav;
    }

    @RequestMapping(value = "delete.report")
    @ResponseBody
    public String DeleteReport(@RequestBody String reportID){
        System.out.println("该举报已被删除：反馈ID为"+reportID);
        reportService.DeleteReport(Long.parseLong(reportID));
        return reportID+"对应的反馈已被删除";
    }
    @RequestMapping("reportno.user")
    public ModelAndView ShowNo(HttpServletRequest request, HttpSession session){
        int state = Integer.parseInt(request.getParameter("state"));
        return  ShowMav(request,session,state);
    }
    @RequestMapping("reportal.user")
    public ModelAndView ShowAl(HttpServletRequest request, HttpSession session){
        int state = Integer.parseInt(request.getParameter("state"));
        return  ShowMav(request,session,state);
    }

    private ModelAndView ShowMav(HttpServletRequest request,HttpSession session,int state){
        UserData tempData = (UserData) session.getAttribute("User");
        ModelAndView mav = new ModelAndView("reportjsp/showreportuser");
        List<UserReportData> reportDataList = reportService.QueryReport(tempData.getUserid(),state);
        for (int i = 0; i < reportDataList.size(); i++) {
            System.out.println(reportDataList.get(i));
        }
        request.setAttribute("username", tempData.getUsername());
        request.setAttribute("reportData", reportDataList);
        return mav;
    }

    private ModelAndView ShowMav(HttpServletRequest request,HttpSession session){
        UserData tempData = (UserData) session.getAttribute("User");
        ModelAndView mav = new ModelAndView("reportjsp/showreportuser");
        List<UserReportData> reportDataList = reportService.QueryReport(tempData.getUserid());
        for (int i = 0; i < reportDataList.size(); i++) {
            System.out.println(reportDataList.get(i));
        }
        request.setAttribute("username", tempData.getUsername());
        request.setAttribute("reportData", reportDataList);
        return mav;
    }



}
