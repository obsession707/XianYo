package com.xianyo.microblogmodule.service;

import com.xianyo.microblogmodule.dao.pojo.MicroblogData;

import java.util.List;

public interface ShowBlogService {
    List<MicroblogData> Show(Long authorID);
    int Praise(Long id,int model);
    void Collect(Long id);
    void Complaint(Long id);
    List<MicroblogData> ShowSortByTime(Long authorID);

}
