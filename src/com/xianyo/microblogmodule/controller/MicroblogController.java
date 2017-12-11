package com.xianyo.microblogmodule.controller;

import com.xianyo.loginmodule.dao.pojo.UserData;
import com.xianyo.microblogmodule.dao.pojo.MicroblogData;
import com.xianyo.microblogmodule.service.SetBlogService;
import com.xianyo.microblogmodule.service.ShowBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
//import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
public class MicroblogController {
    @Autowired
    SetBlogService setBlogService;
    @Autowired
    ShowBlogService showBlogService;

    @RequestMapping(value = "main.blog", method = RequestMethod.GET)
    public ModelAndView mainBlog(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        //判断用户是否登陆
        if (session.getAttribute("User") == null)
            mav.setViewName("loginjsp/login/userlogin");
        else{
            mav = ShowMAV(request, session);
        }
        return mav;
    }

//    @RequestMapping("toInput.blog")
//    public ModelAndView JumpToInputBlog() {
//        ModelAndView mav = new ModelAndView("microblogjsp/inputblog");
//        return mav;
//    }

    @RequestMapping(value = "upload.blog", method = RequestMethod.POST)
    public ModelAndView SubmitBlog(HttpServletRequest request, HttpSession session) throws Exception {
        MicroblogData data = new MicroblogData();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> multipartFiles = multipartRequest.getFiles("myPhoto");
        if (multipartFiles ==null||multipartFiles.size()==0){
            System.out.println("上传图片为空");
        }else {
            String filePath = "no pitcture";
            for (MultipartFile file : multipartFiles) {
                //System.out.println(file.getName());//获取的是myPhoto
                filePath = UploadFile(file, request);
                data.setPicturedir(filePath);
            }
        }
        data.setContext(request.getParameter("message"));
        UserData tempData = (UserData) session.getAttribute("User");//获取session里的Userdata对象
        data.setAuthorid(tempData.getUserid());//获取用户id--对应作者id
        setBlogService.SetBlog(data);//初始化Microblogdata
        return ShowMAV(request, session);
    }

    @RequestMapping(value = "praise.blog", method = RequestMethod.POST)
    public @ResponseBody
    String Praise(@RequestBody String blogID) {
        System.out.println(blogID);
        return Integer.toString(
                showBlogService.Praise(Long.parseLong(blogID), 1)
        );
    }

    @RequestMapping("cancelPraise.blog")
    public @ResponseBody
    String CancelPraise(@RequestBody String blogID) {
        return Integer.toString(
                showBlogService.Praise(Long.parseLong(blogID), -1));
    }

    @RequestMapping(value = "collect.blog", method = RequestMethod.POST)
    public void collect(@RequestBody Long blogID) {
        showBlogService.Collect(blogID);
    }

    @RequestMapping(value = "complaint", method = RequestMethod.POST)
    public void complaint(@RequestBody Long blogID) {
        showBlogService.Complaint(blogID);
    }

    private ModelAndView ShowMAV(HttpServletRequest request, HttpSession session) {
        UserData tempData = (UserData) session.getAttribute("User");
        System.out.println("发微博的用户信息："+tempData);
        ModelAndView mav = new ModelAndView("microblogjsp/showblog");
        List<MicroblogData> microblogDatas = showBlogService.ShowSortByTime(tempData.getUserid());
        for (int i = 0; i < microblogDatas.size(); i++) {
            System.out.println(microblogDatas.get(i));
            mav.addObject("imagesName",microblogDatas.get(0).getPicturedir());
        }
        request.setAttribute("authorName", tempData.getUsername());
        request.setAttribute("microblogData", microblogDatas);
        return mav;
    }


    private String UploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/static/output/");
        System.out.println("上传的path："+path);
        String suffix = file.getOriginalFilename().split("\\.")[1];
        String prefix = UUID.randomUUID().toString();
        String fileName = prefix +"."+ suffix;
        File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return  tempFile.getName();
    }
}

