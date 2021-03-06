package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author CodeGenerator
 * @date 2018/03/19
 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String password;
	private Date createTime;

	public UserEntity(Integer id, String name, String password, Date createTime) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.createTime = createTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

}
