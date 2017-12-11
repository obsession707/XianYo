package com.xianyo.loginmodule.controller;

//import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xianyo.loginmodule.dao.pojo.UserData;
import com.xianyo.util.service.UserDataService;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.jni.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
//import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Controller
public class ChangeController {
    @Autowired
    UserDataService userDataService;

    @RequestMapping("toUser.change")
    public ModelAndView JumpToChange(HttpServletRequest request, HttpSession session) {
        ModelAndView mav = new ModelAndView("/userchangejsp/userchange");
        return mav;
    }


    @RequestMapping("headshot.change")
    public @ResponseBody
    String ChangeUserHeadshot(@RequestParam(value = "myImage",required = true) String myImage, HttpServletRequest request) throws Exception {
        System.out.println(myImage);
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/static/output/");
        System.out.println("上传的path："+path);
        String prefix = UUID.randomUUID().toString();//前缀
        String suffix = ".png";//后缀
//        if("data:image/jpeg;".equalsIgnoreCase(myImage)){//data:image/jpeg;base64,base64编码的jpeg图片数据
//            suffix = ".jpg";
//        } else if("data:image/x-icon;".equalsIgnoreCase(myImage)){//data:image/x-icon;base64,base64编码的icon图片数据
//            suffix = ".ico";
//        } else if("data:image/gif;".equalsIgnoreCase(myImage)){//data:image/gif;base64,base64编码的gif图片数据
//            suffix = ".gif";
//        } else if("data:image/png;".equalsIgnoreCase(myImage)){//data:image/png;base64,base64编码的png图片数据
//            suffix = ".png";
//        }else{
//            throw new Exception("上传图片格式不合法");
//        }
        String fileName = prefix+suffix;
        System.out.println(fileName);
//        File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));
//        if (!tempFile.exists()) {
//            tempFile.createNewFile();
//        }
//        System.out.println(tempFile.getName());
        decoderBase64File(myImage,path+fileName);
//        String path = decoderBase64File(image,request);
//        System.out.println(path);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("image","ok");
        return jsonObject.toString();
    }
    public static void decoderBase64File(String base64Code, String targetPath)
            throws Exception {
        byte[] buffer = null;//new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.flush();
        out.close();
    }
    @RequestMapping("user.change")
    public ModelAndView ChangeUserInfo(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("loginjsp/login/userlogin");
        UserData tempData = (UserData) session.getAttribute("User");
        //修改用户信息
        System.out.println("输入的姓名：" + request.getParameter("username"));
        if (request.getParameter("username") != null) {
            tempData.setUsername(request.getParameter("username"));
        }
        if (request.getParameter("phonenumber") != null) {
            tempData.setPhonenumber(request.getParameter("phonenumber"));
        }
        if (request.getParameter("email") != null) {
            tempData.setEmail(request.getParameter("email"));
        }
        if (request.getParameter("selfIntroduce") != null) {
            tempData.setSelfintroduce(request.getParameter("selfIntroduce"));
        }
        tempData.setPassword(request.getParameter("password"));
        System.out.println("Change:用户：" + tempData);
        System.out.println("Change:用户id：" + tempData.getUserid());
        userDataService.ChangeUser(tempData);
        return mav;
    }
}


