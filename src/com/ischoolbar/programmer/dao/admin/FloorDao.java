package com.ischoolbar.programmer.dao.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.admin.Floor;

/*
 * ¥���Dao��
 * @author kuangtao
 * @Date 2019-08-25 11:23:14
 * @Description 
 *
 */
@Repository
public interface FloorDao {

public int add(Floor floor);
	
	public int edit(Floor floor);
	
	public int delete(Long id);
	
	public List<Floor> findList(Map<String, Object> queryMap);
	
	public List<Floor> findAll();
	
	public Integer getTotal(Map<String, Object> queryMap);
}
