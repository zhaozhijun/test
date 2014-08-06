package com.erayt.bean;

import java.io.Serializable;

public class User implements Serializable{
	/** 
	* @Fields serialVersionUID
	*/ 
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String password;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(Integer id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public User() {
		
	}
	@Override
	public String toString(){
		return "编号："+this.id+"姓名："+this.name+"密码："+this.password;
	}
}
