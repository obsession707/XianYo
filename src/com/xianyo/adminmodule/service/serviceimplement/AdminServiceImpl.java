package com.xianyo.adminmodule.service.serviceimplement;

import com.xianyo.adminmodule.service.AdminService;
import com.xianyo.feedbackmodule.dao.mapper.UserFeedbackDataMapper;
import com.xianyo.feedbackmodule.dao.pojo.UserFeedbackData;
import com.xianyo.feedbackmodule.dao.pojo.UserFeedbackDataExample;
import com.xianyo.feedbackmodule.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserFeedbackDataMapper userFeedbackDataMapper;
}
