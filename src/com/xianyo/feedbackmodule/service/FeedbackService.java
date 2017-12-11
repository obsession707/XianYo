package com.xianyo.feedbackmodule.service;

import com.xianyo.feedbackmodule.dao.pojo.UserFeedbackData;

import java.util.List;

public interface FeedbackService {
    void SubmitFeedback(UserFeedbackData data);
    void ChangeFeedback(UserFeedbackData data);
    UserFeedbackData FindFeedback(Long feedbackID);
    List<UserFeedbackData> QueryFeedbackAll();
    List<UserFeedbackData> QueryFeedbackAll(int state);
    List<UserFeedbackData> QueryFeedback(Long userID, int state);
    List<UserFeedbackData> QueryFeedback(Long userID);
    void DeleteFeedback(Long feedbackID);
}
