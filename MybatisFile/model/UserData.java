package com.project.model;

public class UserData {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.userID
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private Long userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.username
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.password
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.phonenumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private String phonenumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.email
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.sex
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.allowGetLocation
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private Boolean allowgetlocation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.headshot
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private String headshot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.fansNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private Integer fansnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.concernNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private Integer concernnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.microblogNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private Integer microblognumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.answerNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private Integer answernumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.questionNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private Integer questionnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.newAnswers
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private Integer newanswers;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.selfIntroduce
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private String selfintroduce;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.indexUrl
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private String indexurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo_.islogin
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    private Boolean islogin;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.userID
     *
     * @return the value of userinfo_.userID
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.userID
     *
     * @param userid the value for userinfo_.userID
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.username
     *
     * @return the value of userinfo_.username
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.username
     *
     * @param username the value for userinfo_.username
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.password
     *
     * @return the value of userinfo_.password
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.password
     *
     * @param password the value for userinfo_.password
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.phonenumber
     *
     * @return the value of userinfo_.phonenumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.phonenumber
     *
     * @param phonenumber the value for userinfo_.phonenumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.email
     *
     * @return the value of userinfo_.email
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.email
     *
     * @param email the value for userinfo_.email
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.sex
     *
     * @return the value of userinfo_.sex
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.sex
     *
     * @param sex the value for userinfo_.sex
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.allowGetLocation
     *
     * @return the value of userinfo_.allowGetLocation
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public Boolean getAllowgetlocation() {
        return allowgetlocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.allowGetLocation
     *
     * @param allowgetlocation the value for userinfo_.allowGetLocation
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setAllowgetlocation(Boolean allowgetlocation) {
        this.allowgetlocation = allowgetlocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.headshot
     *
     * @return the value of userinfo_.headshot
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public String getHeadshot() {
        return headshot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.headshot
     *
     * @param headshot the value for userinfo_.headshot
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setHeadshot(String headshot) {
        this.headshot = headshot == null ? null : headshot.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.fansNumber
     *
     * @return the value of userinfo_.fansNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public Integer getFansnumber() {
        return fansnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.fansNumber
     *
     * @param fansnumber the value for userinfo_.fansNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setFansnumber(Integer fansnumber) {
        this.fansnumber = fansnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.concernNumber
     *
     * @return the value of userinfo_.concernNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public Integer getConcernnumber() {
        return concernnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.concernNumber
     *
     * @param concernnumber the value for userinfo_.concernNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setConcernnumber(Integer concernnumber) {
        this.concernnumber = concernnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.microblogNumber
     *
     * @return the value of userinfo_.microblogNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public Integer getMicroblognumber() {
        return microblognumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.microblogNumber
     *
     * @param microblognumber the value for userinfo_.microblogNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setMicroblognumber(Integer microblognumber) {
        this.microblognumber = microblognumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.answerNumber
     *
     * @return the value of userinfo_.answerNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public Integer getAnswernumber() {
        return answernumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.answerNumber
     *
     * @param answernumber the value for userinfo_.answerNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setAnswernumber(Integer answernumber) {
        this.answernumber = answernumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.questionNumber
     *
     * @return the value of userinfo_.questionNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public Integer getQuestionnumber() {
        return questionnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.questionNumber
     *
     * @param questionnumber the value for userinfo_.questionNumber
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setQuestionnumber(Integer questionnumber) {
        this.questionnumber = questionnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.newAnswers
     *
     * @return the value of userinfo_.newAnswers
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public Integer getNewanswers() {
        return newanswers;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.newAnswers
     *
     * @param newanswers the value for userinfo_.newAnswers
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setNewanswers(Integer newanswers) {
        this.newanswers = newanswers;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.selfIntroduce
     *
     * @return the value of userinfo_.selfIntroduce
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public String getSelfintroduce() {
        return selfintroduce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.selfIntroduce
     *
     * @param selfintroduce the value for userinfo_.selfIntroduce
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setSelfintroduce(String selfintroduce) {
        this.selfintroduce = selfintroduce == null ? null : selfintroduce.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.indexUrl
     *
     * @return the value of userinfo_.indexUrl
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public String getIndexurl() {
        return indexurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.indexUrl
     *
     * @param indexurl the value for userinfo_.indexUrl
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setIndexurl(String indexurl) {
        this.indexurl = indexurl == null ? null : indexurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo_.islogin
     *
     * @return the value of userinfo_.islogin
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public Boolean getIslogin() {
        return islogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo_.islogin
     *
     * @param islogin the value for userinfo_.islogin
     *
     * @mbggenerated Fri Sep 08 10:01:11 CST 2017
     */
    public void setIslogin(Boolean islogin) {
        this.islogin = islogin;
    }
}