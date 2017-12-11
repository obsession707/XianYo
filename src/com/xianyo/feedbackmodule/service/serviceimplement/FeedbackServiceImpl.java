package com.xianyo.feedbackmodule.service.serviceimplement;

import com.xianyo.feedbackmodule.dao.mapper.UserFeedbackDataMapper;
import com.xianyo.feedbackmodule.dao.pojo.UserFeedbackData;
import com.xianyo.feedbackmodule.dao.pojo.UserFeedbackDataExample;
import com.xianyo.feedbackmodule.service.FeedbackService;
import com.xianyo.util.service.IDGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    UserFeedbackDataMapper feedbackDataMapper;
    @Autowired
    IDGeneratorService idGeneratorService;

    @Override
    public void ChangeFeedback(UserFeedbackData data) {
        feedbackDataMapper.updateByPrimaryKey(data);
    }

    @Override
    public UserFeedbackData FindFeedback(Long feedbackID) {
        return feedbackDataMapper.selectByPrimaryKey(feedbackID);
    }

    //删除单条攻略
    @Override
    public void DeleteFeedback(Long feedbackID) {
        UserFeedbackDataExample example = new UserFeedbackDataExample();
        example.setDistinct(false);
        UserFeedbackDataExample.Criteria criteria = example.createCriteria();
        criteria.andFeedbackidEqualTo(feedbackID);
        feedbackDataMapper.deleteByExample(example);
    }

    //显示所有的反馈信息   for 管理员
    @Override
    public List<UserFeedbackData> QueryFeedbackAll() {
        List<UserFeedbackData>datas = feedbackDataMapper.selectAll();
        datas.sort(Comparator.comparing(UserFeedbackData::getDate).reversed());
        return datas;
    }

    //根据state信息显示所有的反馈信息  未审核信息和已审核信息
    @Override
    public List<UserFeedbackData> QueryFeedbackAll(int state) {
        UserFeedbackDataExample example = new UserFeedbackDataExample();
        example.setDistinct(false);
        UserFeedbackDataExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(state);
        List<UserFeedbackData> datas = feedbackDataMapper.selectByExample(example);
        datas.sort(Comparator.comparing(UserFeedbackData::getDate).reversed());
        return datas;
    }

    //显示   绑定用户   所有的反馈信息
    @Override
    public List<UserFeedbackData> QueryFeedback(Long userID) {
        UserFeedbackDataExample example = new UserFeedbackDataExample();
        example.setDistinct(false);
        UserFeedbackDataExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userID);
        List<UserFeedbackData> datas = feedbackDataMapper.selectByExample(example);
        datas.sort(Comparator.comparing(UserFeedbackData::getDate).reversed());
        return datas;
    }

    //根据state显示反馈信息
    @Override
    public List<UserFeedbackData> QueryFeedback(Long userID,int state) {
        UserFeedbackDataExample example = new UserFeedbackDataExample();
        example.setDistinct(false);
        UserFeedbackDataExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userID);
        criteria.andStateEqualTo(state);
        List<UserFeedbackData> datas = feedbackDataMapper.selectByExample(example);
        datas.sort(Comparator.comparing(UserFeedbackData::getDate).reversed());
        return datas;
    }

    @Override
    //提交用户的反馈并且存入数据库
    public void SubmitFeedback(UserFeedbackData data) {
        Init(data,0);
        data.setFeedbackid(FeedbackIDCreator());
        System.out.println(data);
        feedbackDataMapper.insert(data);
    }
    private Long FeedbackIDCreator() {
        Long randomCreator = idGeneratorService.genetatorForOthers(7);
        long id;
        id = randomCreator;
        id = (id > 0) ? id : -id;
        return id;
    }
    private void  Init(UserFeedbackData data,int state){
        Date date = new Date();
        System.out.println("生成的时间为："+date);
        data.setDate(date);
        //已读和未读的反馈信息  0为未读 1为已读
        data.setState(state);
    }
}
