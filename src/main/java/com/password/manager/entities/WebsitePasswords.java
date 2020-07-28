package com.password.manager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.password.manager.util.DatabaseConstants;

@Entity
@Table(name = "website_passwords")
public class WebsitePasswords implements java.io.Serializable {

	private String website;
	private String web_username;
	private String web_pwd;
	@Column(name="user_id", nullable = false)
	private Integer user_id;

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWeb_username() {
		return web_username;
	}

	public void setWeb_username(String web_username) {
		this.web_username = web_username;
	}

	public String getWeb_pwd() {
		return web_pwd;
	}

	public void setWeb_pwd(String web_pwd) {
		this.web_pwd = web_pwd;
	}

	@Id
	public Integer getUserId() {
		return user_id;
	}

	public void setUserId(Integer user_id) {
		this.user_id = user_id;
	}
	
}
