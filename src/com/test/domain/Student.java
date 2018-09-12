package com.test.domain;

import java.util.Date;

/**
 * 学生类对象的封装bean
 * @author Administrator
 *
 */
public class Student {
	private int id;
	private String name;
	private String sex;
	private String phone;
	private String info;
	private String hobby;
	
	
	public Student() {
		super();
	}

	
	public Student(int id, String name, String sex, String phone, String info, String hobby, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.info = info;
		this.hobby = hobby;
		this.birthday = birthday;
	}
	
	public Student(String name, String sex, String phone, String info, String hobby, Date birthday) {
		super();
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.info = info;
		this.hobby = hobby;
		this.birthday = birthday;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	private Date birthday;
	
}
