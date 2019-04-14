package com.time.entity;

import java.io.Serializable;
import java.util.Date;

public class TimeLog implements Serializable {
    private Long tlId;

    private Long uId;

    private Date start;

    private Date expire;

    private Integer achieve;

    private Date failtime;

    private static final long serialVersionUID = 1L;

    public Long getTlId() {
        return tlId;
    }

    public void setTlId(Long tlId) {
        this.tlId = tlId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Integer getAchieve() {
        return achieve;
    }

    public void setAchieve(Integer achieve) {
        this.achieve = achieve;
    }

    public Date getFailtime() {
        return failtime;
    }

    public void setFailtime(Date failtime) {
        this.failtime = failtime;
    }

	public TimeLog() {
		super();
	}

	public TimeLog(Long tlId, Long uId, Date start, Date expire, Integer achieve, Date failtime) {
		super();
		this.tlId = tlId;
		this.uId = uId;
		this.start = start;
		this.expire = expire;
		this.achieve = achieve;
		this.failtime = failtime;
	}

	public TimeLog(Long uId) {
		super();
		this.uId = uId;
	}
    
}