package com.ischoolbar.programmer.dao.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.admin.RoomType;

/*
 * 房间类型的Dao
 * @author kuangtao
 * @Date 2019-08-25 15:56:22
 * @Description 
 *
 */
@Repository
public interface RoomTypeDao {
public int add(RoomType roomType);
	
	public int edit(RoomType roomType);
	
	public int delete(RoomType roomType);
	
	public List<RoomType> findList(Map<String, Object> queryMap); 
	
}
