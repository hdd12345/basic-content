package com.time.entity;

import java.io.Serializable;

public class Goods implements Serializable {
    private Long gId;

    private String gNum;

    private String gName;

    private Integer consume;

    private Integer count;

    private String gLogo;

    private Integer gType;

    private static final long serialVersionUID = 1L;

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public String getgNum() {
        return gNum;
    }

    public void setgNum(String gNum) {
        this.gNum = gNum == null ? null : gNum.trim();
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public Integer getConsume() {
        return consume;
    }

    public void setConsume(Integer consume) {
        this.consume = consume;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getgLogo() {
        return gLogo;
    }

    public void setgLogo(String gLogo) {
        this.gLogo = gLogo == null ? null : gLogo.trim();
    }

    public Integer getgType() {
        return gType;
    }

    public void setgType(Integer gType) {
        this.gType = gType;
    }

	public Goods(Long gId, String gNum, String gName, Integer consume, Integer count, String gLogo, Integer gType) {
		super();
		this.gId = gId;
		this.gNum = gNum;
		this.gName = gName;
		this.consume = consume;
		this.count = count;
		this.gLogo = gLogo;
		this.gType = gType;
	}

	public Goods(String gNum, String gName, Integer consume, Integer count, String gLogo, Integer gType) {
		super();
		this.gNum = gNum;
		this.gName = gName;
		this.consume = consume;
		this.count = count;
		this.gLogo = gLogo;
		this.gType = gType;
	}

	public Goods() {
		super();
	}
}