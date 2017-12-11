package com.xianyo.util.scenicmodule.service;

import com.xianyo.util.scenicmodule.dao.pojo.ScenicData;

import java.util.List;

public interface ScenicService {
    void SubmitScenic(ScenicData data);
    void ChangeScenic(ScenicData data);
    void DeleteScenic(Long scenicID);
    ScenicData FindScenic(Long scenicID);
    List<ScenicData> QueryScenicAll();
    List<ScenicData> QueryScenicAll(int state);
    List<ScenicData> QueryScenic(Long userID, int state);
    List<ScenicData> QueryScenic(Long userID);
}
