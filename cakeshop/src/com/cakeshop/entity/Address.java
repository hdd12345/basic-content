package com.cakeshop.entity;

import com.alibaba.fastjson.JSONObject;

public class Address {
    private String address_id;

    private String name;

    private String telephone;

    private String postcode;

    private String address_content;

    private String user_id;

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id == null ? null : address_id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

	public String getAddress_content() {
		return address_content;
	}

	public void setAddress_content(String address_content) {
		this.address_content = address_content;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}