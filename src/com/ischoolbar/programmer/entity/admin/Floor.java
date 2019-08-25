package com.ischoolbar.programmer.entity.admin;

import org.springframework.stereotype.Component;

/*
 * 楼层的实体类
 * @author kuangtao
 * @Date 2019-08-25 11:17:09
 * @Description 
 *
 */
@Component
public class Floor {
	
	private Long id;
	private String name;
	private String remark;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
