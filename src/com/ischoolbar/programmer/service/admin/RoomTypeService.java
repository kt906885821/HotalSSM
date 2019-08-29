package com.ischoolbar.programmer.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.admin.RoomType;
/*
 * 房间类型的Serivce
 * @author kuangtao
 * @Date 2019-08-25 15:56:46
 * @Description 
 *
 */
@Service
public interface RoomTypeService {
	public int add(RoomType roomType);
	
	public int edit(RoomType roomType);
	
	public int delete(Long id);
	
	public List<RoomType> findList(Map<String, Object> queryMap);
	
	public List<RoomType> getTotal(Map<String, Object> queryMap);
	
	public List<RoomType> findAll();
	
}
