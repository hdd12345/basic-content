package com.cakeshop.entity;

import com.alibaba.fastjson.JSONObject;

public class Mincategory {
    private String min_id;

    private String min_name;

    private String max_id;

    

	public String getMin_id() {
		return min_id;
	}

	public void setMin_id(String min_id) {
		this.min_id = min_id;
	}

	public String getMin_name() {
		return min_name;
	}

	public void setMin_name(String min_name) {
		this.min_name = min_name;
	}

	public String getMax_id() {
		return max_id;
	}

	public void setMax_id(String max_id) {
		this.max_id = max_id;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}