package com.xianyo.util.reportmodule.service;

import com.xianyo.util.reportmodule.dao.pojo.UserReportData;

import java.util.List;

public interface ReportService {
    void SubmitReport(UserReportData data);
    void ChangeReport(UserReportData data);
    void DeleteReport(Long reportID);
    UserReportData FindReport(Long reportID);
    List<UserReportData> QueryReportAll();
    List<UserReportData> QueryReportAll(int state);
    List<UserReportData> QueryReport(Long userID, int state);
    List<UserReportData> QueryReport(Long userID);
}
