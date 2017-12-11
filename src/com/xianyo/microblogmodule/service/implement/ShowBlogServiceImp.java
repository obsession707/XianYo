package com.xianyo.microblogmodule.service.implement;

import com.xianyo.microblogmodule.dao.mapper.MicroblogDataMapper;
import com.xianyo.microblogmodule.dao.pojo.MicroblogData;
import com.xianyo.microblogmodule.dao.mapper.MicroblogDataExample;
import com.xianyo.microblogmodule.service.ShowBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Comparator;
import java.util.List;

@Service
public class ShowBlogServiceImp implements ShowBlogService{
    @Autowired
    MicroblogDataMapper microblogDataMapper;
    @Override
    public List<MicroblogData> Show(Long authorID) {
        MicroblogDataExample example = new MicroblogDataExample();
        example.setDistinct(false);
        MicroblogDataExample.Criteria criteria = example.createCriteria();
        criteria.andAuthoridEqualTo(authorID);
        List<MicroblogData> datas = microblogDataMapper.selectByExample(example);
        return datas;
    }
    @Override
    public int Praise(Long id,int model){
        MicroblogData data =  microblogDataMapper.selectByPrimaryKey(id);
        data.setPraisetime(data.getPraisetime()+model);
        microblogDataMapper.updateByPrimaryKey(data);
        int time = data.getPraisetime();
        return time;
    }
    @Override
    public void Collect(Long id){
        MicroblogData data =  microblogDataMapper.selectByPrimaryKey(id);
        data.setCollecttime(data.getCollecttime()+1);
        microblogDataMapper.updateByPrimaryKey(data);
    }
    @Override
    public void Complaint(Long id){
        MicroblogData data =  microblogDataMapper.selectByPrimaryKey(id);
        data.setComplainttime(data.getComplainttime()+1);
        microblogDataMapper.updateByPrimaryKey(data);
    }

    @Override
    public List<MicroblogData> ShowSortByTime(Long authorID) {
        MicroblogDataExample example = new MicroblogDataExample();
        example.setDistinct(false);
        MicroblogDataExample.Criteria criteria = example.createCriteria();
        criteria.andAuthoridEqualTo(authorID);
        List<MicroblogData> datas = microblogDataMapper.selectByExample(example);
        datas.sort(Comparator.comparing(MicroblogData::getPublishtime).reversed());
        return datas;
    }
}
