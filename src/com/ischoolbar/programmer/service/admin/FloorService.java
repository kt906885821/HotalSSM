package com.ischoolbar.programmer.service.admin;

import java.util.List;
import java.util.Map;

import com.ischoolbar.programmer.entity.admin.Floor;

/*
 * Â¥²ãÒµÎñ²ã
 * @author kuangtao
 * @Date 2019-08-25 11:19:31
 * @Description 
 *
 */
public interface FloorService {

	public int add(Floor floor);
	
	public int edit(Floor floor);
	
	public int delete(Long id);
	
	public List<Floor> findList(Map<String, Object> queryMap);
	
	public List<Floor> findAll();
	
	public Integer getTotal(Map<String, Object> queryMap);
}
