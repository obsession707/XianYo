package com.xianyo.feedbackmodule.controller;

//import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xianyo.feedbackmodule.dao.pojo.UserFeedbackData;
import com.xianyo.feedbackmodule.service.FeedbackService;
import com.xianyo.loginmodule.dao.pojo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FeedbackController {
    public String message;
    @Autowired
    FeedbackService feedbackService;
    @RequestMapping("toFeedback")
    public ModelAndView JumpToFeedback(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/feedbackjsp/submitfeedback");
        return  mav;
    }
    @RequestMapping(value = "feedback.user",method = RequestMethod.POST)
    public ModelAndView Submit(UserFeedbackData feedback, HttpServletRequest request, HttpSession session){
        ModelAndView mav = new ModelAndView();
        //判断用户是否登陆
        if (session.getAttribute("User") == null)
            mav.setViewName("loginjsp/login/userlogin");
        else{
            UserData tempData = (UserData)  session.getAttribute("User");
            feedback.setUserid(tempData.getUserid());
            feedbackService.SubmitFeedback(feedback);
            message = "提交成功";
            mav.addObject("message",message);
            mav = ShowMav(request,session);//显示所有的
        }
        return mav;
    }

    @RequestMapping(value = "delete.feedback")
    @ResponseBody
    public String DeleteFeedback(@RequestBody String feedbackID){
        System.out.println("该反馈已被删除：反馈ID为"+feedbackID);
        feedbackService.DeleteFeedback(Long.parseLong(feedbackID));
        return feedbackID+"对应的反馈已被删除";
    }
    @RequestMapping("feedbackno.user")
    public ModelAndView ShowNo(HttpServletRequest request, HttpSession session){
        int state = Integer.parseInt(request.getParameter("state"));
        return  ShowMav(request,session,state);
    }
    @RequestMapping("feedbackal.user")
    public ModelAndView ShowAl(HttpServletRequest request, HttpSession session){
        int state = Integer.parseInt(request.getParameter("state"));
        return  ShowMav(request,session,state);
    }

    private ModelAndView ShowMav(HttpServletRequest request,HttpSession session,int state){
        UserData tempData = (UserData) session.getAttribute("User");
        ModelAndView mav = new ModelAndView("feedbackjsp/showfeedbackuser");
       List<UserFeedbackData> feedbackDataList = feedbackService.QueryFeedback(tempData.getUserid(),state);
        for (int i = 0; i < feedbackDataList.size(); i++) {
            System.out.println(feedbackDataList.get(i));
        }
        request.setAttribute("username", tempData.getUsername());
        request.setAttribute("feedbackData", feedbackDataList);
        return mav;
    }

    private ModelAndView ShowMav(HttpServletRequest request,HttpSession session){
        UserData tempData = (UserData) session.getAttribute("User");
        ModelAndView mav = new ModelAndView("feedbackjsp/showfeedbackuser");
        List<UserFeedbackData> feedbackDataList = feedbackService.QueryFeedback(tempData.getUserid());
        for (int i = 0; i < feedbackDataList.size(); i++) {
            System.out.println(feedbackDataList.get(i));
        }
        request.setAttribute("username", tempData.getUsername());
        request.setAttribute("feedbackData", feedbackDataList);
        return mav;
    }
}
