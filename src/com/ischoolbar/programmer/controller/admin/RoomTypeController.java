package com.ischoolbar.programmer.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.util.StringUtil;
import com.ischoolbar.programmer.entity.admin.Floor;
import com.ischoolbar.programmer.entity.admin.RoomType;
import com.ischoolbar.programmer.page.admin.Page;
import com.ischoolbar.programmer.service.admin.RoomTypeService;
@RequestMapping("/admin/room_type")
@Controller
public class RoomTypeController {

	@Autowired
	private RoomTypeService roomTypeService;
	
	/*
	 * 楼层管理列表页面
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model) {
		model.setViewName("room_type/list");
		return model;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> add(RoomType roomType){
		Map<String,String> map = new HashMap<>();
		if (roomType == null&&roomType.equals(" ")) {
			map.put("type", "error");
			map.put("msg", "请填写正确的信息");
			return map;
			
		}
		if (StringUtil.isEmpty(roomType.getName())) {
			map.put("type", "error");
			map.put("msg", "楼层不能为空");
			return map;
		}
		if (roomTypeService.add(roomType) <= 0) {
			map.put("type", "error");
			map.put("msg", "添加失败");
			return map;
		}
		map.put("type", "success");
		map.put("msg", "添加成功");
		return map;
	}
	
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(RoomType roomType) {
		Map<String,String> map = new HashMap<>();
		if (roomType == null&&roomType.equals(" ")) {
			map.put("type", "error");
			map.put("msg", "请填写正确的信息");
			return map;
			
		}
		if (StringUtil.isEmpty(roomType.getName())) {
			map.put("type", "error");
			map.put("msg", "楼层不能为空");
			return map;
		}
		if (roomTypeService.edit(roomType) <= 0) {
			map.put("type", "error");
			map.put("msg", "修改失败");
			return map;
		}
		map.put("type", "success");
		map.put("msg", "添加成功");
		return map;
	}
	
	/*
	 * 楼层删除操作
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(Long id) {
		Map<String,String> map = new HashMap<>();
		if (id == null&&id.equals(" ")) {
			map.put("type", "error");
			map.put("msg", "请填写正确的信息");
			return map;
			
		}
		try {
			if (roomTypeService.delete(id) <= 0) {
				map.put("type", "error");
				map.put("msg", "删除失败");
				return map;
			}
		}catch (Exception e) {
			map.put("type", "error");
			map.put("msg", "该楼层存在已入住的房间，不能删除");
			return map;
		}
		map.put("type", "success");
		map.put("msg", "删除成功");
		return map;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(@RequestParam(name="name",defaultValue="")String name,Page page){
		Map<String,Object> map = new HashMap<>();
		HashMap<String, Object> queryMap = new HashMap<>();
		queryMap.put("name", name);
		queryMap.put("offset",page.getOffset());
		queryMap.put("rows", page.getRows());
		map.put("rows", roomTypeService.findList(queryMap));
		map.put("total", roomTypeService.getTotal(queryMap));
		return queryMap;
	}

	
}
