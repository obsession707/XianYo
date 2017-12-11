package com.xianyo.util.scenicmodule.controller;

import com.xianyo.loginmodule.dao.pojo.UserData;
import com.xianyo.util.scenicmodule.dao.pojo.ScenicData;
import com.xianyo.util.scenicmodule.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class ScenicController {
    public String message;
    @Autowired
    ScenicService scenicService;
    @RequestMapping("toScenic")
    public ModelAndView JumpToScenic(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("/scenicjsp/submitscenic");
        return  mav;
    }
    @RequestMapping("scenic.user")
    public ModelAndView Submit(ScenicData scenicData,
                               HttpServletRequest request, HttpSession session)throws  Exception{
        ModelAndView mav = new ModelAndView();
        //判断用户是否登陆
        if (session.getAttribute("User") == null)
            mav.setViewName("loginjsp/login/userlogin");
        else{
            UserData tempData = (UserData)  session.getAttribute("User");
            System.out.println("用户id："+tempData.getUserid());
            scenicData.setUserid(tempData.getUserid());
            //存入图片
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> multipartFiles = multipartRequest.getFiles("scenicPhoto");
            if (multipartFiles ==null||multipartFiles.size()==0){
                System.out.println("上传图片为空");
            }else {
                String filePath = "no pitcture";
                for (MultipartFile file : multipartFiles) {
                    //System.out.println(file.getName());//获取的是myPhoto
                    filePath = UploadFile(file, request);
                    scenicData.setScenicpicdir(filePath);
                }
            }
            scenicService.SubmitScenic(scenicData);
            message = "提交成功";
            mav.addObject("message",message);
            mav = ShowMav(request,session);//显示所有的
        }
        return mav;
    }
    @RequestMapping("release.scenic")
    public ModelAndView ReleaseScenic(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("scenicjsp/releasescenic");
        String scenicid = request.getParameter("Scenicid");
        ScenicData tempData = scenicService.FindScenic(Long.parseLong(scenicid));
        request.setAttribute("scenicName",tempData.getScenicname());
        request.setAttribute("scenicPicdir",tempData.getScenicpicdir());
        request.setAttribute("scenicSynopsis",tempData.getScenicsynopsis());
        request.setAttribute("scenicFood",tempData.getScenicfood());
        request.setAttribute("scenicTraffic",tempData.getScenictraffic());
        return mav;
    }
    @RequestMapping(value = "delete.scenic")
    @ResponseBody
    public String DeleteScenic(@RequestBody String scenicID){
        System.out.println("该景点已被删除：景点ID为"+scenicID);
        scenicService.DeleteScenic(Long.parseLong(scenicID));
        return scenicID+"对应的景点已被删除";
    }
    @RequestMapping("scenicno.user")
    public ModelAndView ShowNo(HttpServletRequest request, HttpSession session){
        int state = Integer.parseInt(request.getParameter("state"));
        return  ShowMav(request,session,state);
    }
    @RequestMapping("scenical.user")
    public ModelAndView ShowAl(HttpServletRequest request, HttpSession session){
        int state = Integer.parseInt(request.getParameter("state"));
        return  ShowMav(request,session,state);
    }
    private ModelAndView ShowMav(HttpServletRequest request,HttpSession session,int state){
        UserData tempData = (UserData) session.getAttribute("User");
        ModelAndView mav = new ModelAndView("scenicjsp/showscenicuser");
        List<ScenicData> scenicDataList = scenicService.QueryScenic(tempData.getUserid(),state);
        for (int i = 0; i < scenicDataList.size(); i++) {
            System.out.println(scenicDataList.get(i));
        }
        request.setAttribute("username", tempData.getUsername());
        request.setAttribute("scenicDatas", scenicDataList);
        return mav;
    }

    private ModelAndView ShowMav(HttpServletRequest request,HttpSession session){
        UserData tempData = (UserData) session.getAttribute("User");
        ModelAndView mav = new ModelAndView("scenicjsp/showscenicuser");
        List<ScenicData> scenicDataList = scenicService.QueryScenic(tempData.getUserid());
        for (int i = 0; i < scenicDataList.size(); i++) {
            System.out.println(scenicDataList.get(i));
        }
        request.setAttribute("username", tempData.getUsername());
        request.setAttribute("scenicDatas", scenicDataList);
        return mav;
    }

    private String UploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/static/output/scenic");
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
