package com.beaver.sep193.member;

import java.util.Date;

public class Member {
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_phone;
	private Date m_birthday;
	private String m_photo;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String m_id, String m_pw, String m_name, String m_phone, Date m_birthday, String m_photo) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_phone = m_phone;
		this.m_birthday = m_birthday;
		this.m_photo = m_photo;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public Date getM_birthday() {
		return m_birthday;
	}

	public void setM_birthday(Date m_birthday) {
		this.m_birthday = m_birthday;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}
	
	
}
