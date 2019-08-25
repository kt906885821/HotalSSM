package com.ischoolbar.programmer.entity.admin;

import org.springframework.stereotype.Component;

/*
 * 房间类型实体类
 * @author kuangtao
 * @Date 2019-08-25 15:46:29
 * @Description 
 *
 */
@Component
public class RoomType {
	private Long id;
	private String name;
	private Float price;
	private Integer liveNum;
	private Integer bedNum;
	private Integer roomNum;
	private Integer avilableNum;
	private Integer status;
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getLiveNum() {
		return liveNum;
	}
	public void setLiveNum(Integer liveNum) {
		this.liveNum = liveNum;
	}
	public Integer getBedNum() {
		return bedNum;
	}
	public void setBedNum(Integer bedNum) {
		this.bedNum = bedNum;
	}
	public Integer getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	public Integer getAvilableNum() {
		return avilableNum;
	}
	public void setAvilableNum(Integer avilableNum) {
		this.avilableNum = avilableNum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
