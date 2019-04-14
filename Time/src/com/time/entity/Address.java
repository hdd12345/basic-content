package com.time.entity;

import java.io.Serializable;
import java.util.Date;

public class Address implements Serializable {
    private Long adrId;

    private Long uId;

    private String province;

    private String city;

    private String detail;

    private Date addTime;

    private static final long serialVersionUID = 1L;

    public Long getAdrId() {
        return adrId;
    }

    public void setAdrId(Long adrId) {
        this.adrId = adrId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

	public Address(Long uId, String province, String city, String detail) {
		super();
		this.uId = uId;
		this.province = province;
		this.city = city;
		this.detail = detail;
	}

	public Address() {
		super();
	}
    
    
}