package com.hdd.entity;

/**
 * Dto����û�д洢���壬�����������ݴ���
 * @author Administrator
 *
 */
public class PhoneDto {
	private String pname;
	
	private String username;
	
	public PhoneDto() {
		
	}
	
	public PhoneDto(String pname, String username) {
		super();
		this.pname = pname;
		this.username = username;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
