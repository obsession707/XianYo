package com.xianyo.feedbackmodule.dao.pojo;

import java.util.Date;

public class UserFeedbackData {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userfeedbackinfo_.feedbackid
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    private Long feedbackid;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userfeedbackinfo_.feedbackcontext
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    private String feedbackcontext;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userfeedbackinfo_.userid
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    private Long userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userfeedbackinfo_.feedbacktitle
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    private String feedbacktitle;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userfeedbackinfo_.picturedir
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    private String picturedir;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userfeedbackinfo_.state
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userfeedbackinfo_.date
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userfeedbackinfo_.reply
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    private String reply;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userfeedbackinfo_.feedbackid
     *
     * @return the value of userfeedbackinfo_.feedbackid
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public Long getFeedbackid() {
        return feedbackid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userfeedbackinfo_.feedbackid
     *
     * @param feedbackid the value for userfeedbackinfo_.feedbackid
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public void setFeedbackid(Long feedbackid) {
        this.feedbackid = feedbackid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userfeedbackinfo_.feedbackcontext
     *
     * @return the value of userfeedbackinfo_.feedbackcontext
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public String getFeedbackcontext() {
        return feedbackcontext;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userfeedbackinfo_.feedbackcontext
     *
     * @param feedbackcontext the value for userfeedbackinfo_.feedbackcontext
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public void setFeedbackcontext(String feedbackcontext) {
        this.feedbackcontext = feedbackcontext == null ? null : feedbackcontext.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userfeedbackinfo_.userid
     *
     * @return the value of userfeedbackinfo_.userid
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userfeedbackinfo_.userid
     *
     * @param userid the value for userfeedbackinfo_.userid
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userfeedbackinfo_.feedbacktitle
     *
     * @return the value of userfeedbackinfo_.feedbacktitle
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public String getFeedbacktitle() {
        return feedbacktitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userfeedbackinfo_.feedbacktitle
     *
     * @param feedbacktitle the value for userfeedbackinfo_.feedbacktitle
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public void setFeedbacktitle(String feedbacktitle) {
        this.feedbacktitle = feedbacktitle == null ? null : feedbacktitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userfeedbackinfo_.picturedir
     *
     * @return the value of userfeedbackinfo_.picturedir
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public String getPicturedir() {
        return picturedir;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userfeedbackinfo_.picturedir
     *
     * @param picturedir the value for userfeedbackinfo_.picturedir
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public void setPicturedir(String picturedir) {
        this.picturedir = picturedir == null ? null : picturedir.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userfeedbackinfo_.state
     *
     * @return the value of userfeedbackinfo_.state
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userfeedbackinfo_.state
     *
     * @param state the value for userfeedbackinfo_.state
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userfeedbackinfo_.date
     *
     * @return the value of userfeedbackinfo_.date
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userfeedbackinfo_.date
     *
     * @param date the value for userfeedbackinfo_.date
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userfeedbackinfo_.reply
     *
     * @return the value of userfeedbackinfo_.reply
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public String getReply() {
        return reply;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userfeedbackinfo_.reply
     *
     * @param reply the value for userfeedbackinfo_.reply
     *
     * @mbggenerated Sun Sep 17 18:25:19 CST 2017
     */
    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    @Override
    public String toString() {
        return "UserFeedbackData{" +
                "feedbackid=" + feedbackid +
                ", feedbackcontext='" + feedbackcontext + '\'' +
                ", userid=" + userid +
                ", feedbacktitle='" + feedbacktitle + '\'' +
                ", picturedir='" + picturedir + '\'' +
                ", state=" + state +
                ", date=" + date +
                ", reply='" + reply + '\'' +
                '}';
    }
}