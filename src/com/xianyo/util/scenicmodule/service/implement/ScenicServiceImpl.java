package com.xianyo.util.scenicmodule.service.implement;

import com.xianyo.util.scenicmodule.dao.mapper.ScenicDataMapper;
import com.xianyo.util.scenicmodule.dao.pojo.ScenicData;
import com.xianyo.util.scenicmodule.dao.pojo.ScenicDataExample;
import com.xianyo.util.scenicmodule.service.ScenicService;
import com.xianyo.util.service.IDGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class ScenicServiceImpl implements ScenicService{
    @Autowired
    ScenicDataMapper scenicDataMapper;
    @Autowired
    IDGeneratorService idGeneratorService;

    @Override
    public ScenicData FindScenic(Long scenicID) {
        return scenicDataMapper.selectByPrimaryKey(scenicID);
    }

    @Override
    public void SubmitScenic(ScenicData data) {
        Init(data,0);
        data.setScenicid(ScenicIDCreator());
        System.out.println(data);
        scenicDataMapper.insert(data);
    }

    //修改信息
    @Override
    public void ChangeScenic(ScenicData data) {
        scenicDataMapper.updateByPrimaryKey(data);
    }

    //delete
    @Override
    public void DeleteScenic(Long scenicID) {
        ScenicDataExample example = new ScenicDataExample();
        example.setDistinct(false);
        ScenicDataExample.Criteria criteria = example.createCriteria();
        criteria.andScenicidEqualTo(scenicID);
        scenicDataMapper.deleteByExample(example);
    }
    //根据用户查发送的景点信息
    @Override
    public List<ScenicData> QueryScenic(Long userID) {
        ScenicDataExample example = new ScenicDataExample();
        example.setDistinct(false);
        ScenicDataExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userID);
        List<ScenicData> datas = scenicDataMapper.selectByExample(example);
        datas.sort(Comparator.comparing(ScenicData::getDate).reversed());
        return datas;
    }
    //根据用户id查发送的景点信息  用state区分
    @Override
    public List<ScenicData> QueryScenic(Long userID, int state) {
        ScenicDataExample example = new ScenicDataExample();
        example.setDistinct(false);
        ScenicDataExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userID);
        criteria.andStateEqualTo(state);
        List<ScenicData> datas = scenicDataMapper.selectByExample(example);
        datas.sort(Comparator.comparing(ScenicData::getDate).reversed());
        return datas;
    }
    //查所有发送的景点信息   for管理员
    @Override
    public List<ScenicData> QueryScenicAll() {
        List<ScenicData> datas = scenicDataMapper.selectAll();
        datas.sort(Comparator.comparing(ScenicData::getDate).reversed());
        return datas;
    }

    //查发送的景点信息  用state区分  for管理员
    @Override
    public List<ScenicData> QueryScenicAll(int state) {
        ScenicDataExample example = new ScenicDataExample();
        example.setDistinct(false);
        ScenicDataExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(state);
        List<ScenicData> datas = scenicDataMapper.selectByExample(example);
        datas.sort(Comparator.comparing(ScenicData::getDate).reversed());
        return datas;
    }


    private Long ScenicIDCreator() {
        Long randomCreator = idGeneratorService.genetatorForOthers(6);
        long id;
        id = randomCreator;
        id = (id > 0) ? id : -id;
        return id;
    }
    private void  Init(ScenicData data, int state){
        Date date = new Date();
        System.out.println("生成的时间为："+date);
        data.setDate(date);
        //已读和未读的反馈信息  0为未读 1为已读
        data.setState(state);
        data.setTrafficscore(0.0f);
        data.setCulturalscore(0.0f);
        data.setTrafficscore(0.0f);
        data.setEntertainmentscore(0.0f);
        data.setFoodscore(0.0f);
        data.setTotalscore(0.0f);
        data.setSceneryscore(0.0f);
        data.setGradenumber(0);
        data.setVpnumber(0);
        data.setValidvpnumber(0);
    }
}
