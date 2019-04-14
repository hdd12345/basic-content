package com.time.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Long uId;

    private String uName;

    private String uPwd;

    private Integer credit;

    private Long duration;

    private Integer rType = 2;

    private static final long serialVersionUID = 1L;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd == null ? null : uPwd.trim();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getrType() {
        return rType;
    }

    public void setrType(Integer rType) {
        this.rType = rType;
    }

    
	public User(Long uId, String uName, String uPwd, Integer credit, Long duration, Integer rType) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPwd = uPwd;
		this.credit = credit;
		this.duration = duration;
		this.rType = rType;
	}

	public User(String uName, String uPwd, Integer rType) {
		super();
		this.uName = uName;
		this.uPwd = uPwd;
		this.rType = rType;
	}

	public User(String uName, String uPwd) {
		super();
		this.uName = uName;
		this.uPwd = uPwd;
	}

	public User(Long uId, Long duration) {
		super();
		this.uId = uId;
		this.duration = duration;
	}

	public User() {
		super();
	}

}