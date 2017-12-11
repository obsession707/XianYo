package com.xianyo.util.reportmodule.service.implement;

import com.xianyo.util.reportmodule.dao.mapper.UserReportDataMapper;
import com.xianyo.util.reportmodule.dao.pojo.UserReportData;
import com.xianyo.util.reportmodule.dao.pojo.UserReportDataExample;
import com.xianyo.util.reportmodule.service.ReportService;
import com.xianyo.util.service.IDGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    UserReportDataMapper reportDataMapper;
    @Autowired
    IDGeneratorService idGeneratorService;

    @Override
    public void SubmitReport(UserReportData data) {
        Init(data,0);
        data.setReportid(ReportIDCreator());
        System.out.println(data);
        reportDataMapper.insert(data);
    }

    @Override
    public void ChangeReport(UserReportData data) {
        reportDataMapper.updateByPrimaryKey(data);
    }

    @Override
    public UserReportData FindReport(Long reportID) {
        return reportDataMapper.selectByPrimaryKey(reportID);
    }

    //显示所有的举报信息 for用户
    @Override
    public List<UserReportData> QueryReport(Long userID) {
        UserReportDataExample example = new UserReportDataExample();
        example.setDistinct(false);
        UserReportDataExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userID);
        List<UserReportData> datas = reportDataMapper.selectByExample(example);
        datas.sort(Comparator.comparing(UserReportData::getDate).reversed());
        return datas;
    }

    @Override
    public List<UserReportData> QueryReport(Long userID, int state) {
        UserReportDataExample example = new UserReportDataExample();
        example.setDistinct(false);
        UserReportDataExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userID);
        criteria.andStateEqualTo(state);
        List<UserReportData> datas = reportDataMapper.selectByExample(example);
        datas.sort(Comparator.comparing(UserReportData::getDate).reversed());
        return datas;
    }

    //显示所有的举报信息 for管理员
    @Override
    public List<UserReportData> QueryReportAll() {
        List<UserReportData> datas = reportDataMapper.selectAll();
        datas.sort(Comparator.comparing(UserReportData::getDate).reversed());
        return datas;
    }

    //根据state显示已审核和未审核的举报信息 for管理员
    @Override
    public List<UserReportData> QueryReportAll(int state) {
        UserReportDataExample example = new UserReportDataExample();
        example.setDistinct(false);
        UserReportDataExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo(state);
        List<UserReportData> datas = reportDataMapper.selectByExample(example);
        datas.sort(Comparator.comparing(UserReportData::getDate).reversed());
        return datas;
    }

    //删除某条
    @Override
    public void DeleteReport(Long reportID) {
        UserReportDataExample example = new UserReportDataExample();
        example.setDistinct(false);
        UserReportDataExample.Criteria criteria = example.createCriteria();
        criteria.andReportidEqualTo(reportID);
        reportDataMapper.deleteByExample(example);
    }

    private Long ReportIDCreator() {
        Long randomCreator = idGeneratorService.genetatorForOthers(8);
        long id;
        id = randomCreator;
        id = (id > 0) ? id : -id;
        return id;
    }
    private void  Init(UserReportData data,int state){
        Date date = new Date();
        System.out.println("生成的时间为："+date);
        data.setDate(date);
        //已读和未读的反馈信息  0为未读 1为已读
        data.setState(state);
    }
}
