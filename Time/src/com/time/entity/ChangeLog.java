package com.time.entity;

import java.io.Serializable;
import java.util.Date;

public class ChangeLog implements Serializable {
    private Long clId;

    private Long uId;

    private Integer consume;

    private Long gId;

    private Date clTime;

    private Long adrId;

    private static final long serialVersionUID = 1L;

    public Long getClId() {
        return clId;
    }

    public void setClId(Long clId) {
        this.clId = clId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Integer getConsume() {
        return consume;
    }

    public void setConsume(Integer consume) {
        this.consume = consume;
    }

    public Long getgId() {
        return gId;
    }

    public void setgId(Long gId) {
        this.gId = gId;
    }

    public Date getClTime() {
        return clTime;
    }

    public void setClTime(Date clTime) {
        this.clTime = clTime;
    }

    public Long getAdrId() {
        return adrId;
    }

    public void setAdrId(Long adrId) {
        this.adrId = adrId;
    }

	public ChangeLog(Long uId, Integer consume, Long gId, Long adrId) {
		super();
		this.uId = uId;
		this.consume = consume;
		this.gId = gId;
		this.adrId = adrId;
	}

	public ChangeLog() {
		super();
	}
    
}