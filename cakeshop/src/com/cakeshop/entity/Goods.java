package com.cakeshop.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class Goods {
    private String goods_id;

    private String gname;

    private Double gprice;

    private String gimage;

    private Integer number;

    private Date gdate;

    private String min_id;

    private String gdesc;

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public String getGimage() {
        return gimage;
    }

    public void setGimage(String gimage) {
        this.gimage = gimage == null ? null : gimage.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getGdate() {
        return gdate;
    }

    public void setGdate(Date gdate) {
        this.gdate = gdate;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc == null ? null : gdesc.trim();
    }

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getMin_id() {
		return min_id;
	}

	public void setMin_id(String min_id) {
		this.min_id = min_id;
	}
    
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}