package com.zongqiao.onesystem.domain;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String nickName;

    private String telephone;

    private String password;

    private String email;

    private Boolean emailActive;

    private Boolean isLogin;

    private Boolean isDeleted;

    private Date createTime;

    private Date updateTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getEmailActive() {
        return emailActive;
    }

    public void setEmailActive(Boolean emailActive) {
        this.emailActive = emailActive;
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() { 
		return "User [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", telephone="
				+ telephone + ", password=" + password + ", email=" + email + ", emailActive=" + emailActive
				+ ", isLogin=" + isLogin + ", isDeleted=" + isDeleted + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
    
    
}