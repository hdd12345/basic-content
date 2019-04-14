package com.time.entity;

import java.io.Serializable;

public class Manager implements Serializable {
    private Integer mId;

    private String mName;

    private String mPwd;

    private Integer rType = 1;

    private static final long serialVersionUID = 1L;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmPwd() {
        return mPwd;
    }

    public void setmPwd(String mPwd) {
        this.mPwd = mPwd == null ? null : mPwd.trim();
    }

    public Integer getrType() {
        return rType;
    }

    public void setrType(Integer rType) {
        this.rType = rType;
    }

	public Manager(String mName, String mPwd, Integer rType) {
		super();
		this.mName = mName;
		this.mPwd = mPwd;
		this.rType = rType;
	}

	public Manager() {
		super();
	}

	public Manager(String mName, String mPwd) {
		super();
		this.mName = mName;
		this.mPwd = mPwd;
	}
	
	
    
}