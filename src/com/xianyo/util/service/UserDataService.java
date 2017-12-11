package com.xianyo.util.service;

import com.xianyo.loginmodule.dao.pojo.UserData;

import java.util.List;

public interface UserDataService {
    //根据用户id查询用户数据
    void ChangeUser(UserData data);
    UserData FindWithID(Long userID);
    List<UserData> QueryUserAll();
}
