package com.xianyo.util.service.implement;

import com.xianyo.loginmodule.dao.mapper.UserDataExample;
import com.xianyo.loginmodule.dao.mapper.UserDataMapper;
import com.xianyo.loginmodule.dao.pojo.UserData;
import com.xianyo.util.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService{
    @Autowired
    UserDataMapper userDataMapper;
    @Override
    public UserData FindWithID(Long userID) {
        return  userDataMapper.selectByPrimaryKey(userID);
    }

    @Override
    public void ChangeUser(UserData data) {
        userDataMapper.updateByPrimaryKey(data);
    }

    @Override
    public List<UserData> QueryUserAll() {
        return userDataMapper.selectAll();
    }
}
