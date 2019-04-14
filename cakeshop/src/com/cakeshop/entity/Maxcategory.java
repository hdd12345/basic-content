package com.cakeshop.entity;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class Maxcategory {
    private String max_id;

    private String max_name;
    //以下为扩展属性，用于关联查询映射
	private List<Mincategory> list;
	
	public List<Mincategory> getList() {
		return list;
	}



	public void setList(List<Mincategory> list) {
		this.list = list;
	}



	public String getMax_id() {
		return max_id;
	}



	public void setMax_id(String max_id) {
		this.max_id = max_id;
	}



	public String getMax_name() {
		return max_name;
	}



	public void setMax_name(String max_name) {
		this.max_name = max_name;
	}



	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}